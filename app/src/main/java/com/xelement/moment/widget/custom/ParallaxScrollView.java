package com.xelement.moment.widget.custom;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;

public class ParallaxScrollView extends MyScrollView {

    private boolean isRestoring;
    private int mActivePointerId;
    private float mInitialMotionY;
    private float mLastMotionY;
    private boolean isBeingDragged;
    private float mDistance;
    private int mTouchSlop;

    private OnOverScrollListener OverScrollListener;

    public interface OnOverScrollListener {
        void onOverScroll(float deltaY);
    }

    public void setOnOverScrollListener(OnOverScrollListener listener) {
        this.OverScrollListener = listener;
    }

    public ParallaxScrollView(Context context) {
        this(context, null);
    }

    public ParallaxScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParallaxScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        if (isRestoring && action == MotionEvent.ACTION_DOWN) {
            isRestoring = false;
        }
        if (!isEnabled() || isRestoring || (!isScrollToTop() && !isScrollToBottom())) {
            return super.onInterceptTouchEvent(event);
        }
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                mActivePointerId = event.getPointerId(0);
                isBeingDragged = false;
                float initialMotionY = mLastMotionY = getMotionEventY(event);
                if (initialMotionY == -1) {
                    return super.onInterceptTouchEvent(event);
                }
                mInitialMotionY = initialMotionY;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if (mActivePointerId == MotionEvent.INVALID_POINTER_ID) {
                    return super.onInterceptTouchEvent(event);
                }
                final float y = mLastMotionY = getMotionEventY(event);
                if (y == -1f) {
                    return super.onInterceptTouchEvent(event);
                }
                if (isScrollToTop() && !isScrollToBottom()) {
                    // 在顶部不在底部
                    float yDiff = y - mInitialMotionY;
                    if (yDiff > mTouchSlop && !isBeingDragged) {
                        isBeingDragged = true;
                    }
                } else if (isScrollToTop() && isScrollToBottom()) {
                    // 在底部也在顶部
                    float yDiff = y - mInitialMotionY;
                    if (Math.abs(yDiff) > mTouchSlop && !isBeingDragged) {
                        isBeingDragged = true;
                    }
                } else {
                    // 不在底部也不在顶部
                    return super.onInterceptTouchEvent(event);
                }
                break;
            }
            case MotionEventCompat.ACTION_POINTER_UP:
                onSecondaryPointerUp(event);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mActivePointerId = MotionEvent.INVALID_POINTER_ID;
                isBeingDragged = false;
                break;
        }
        return isBeingDragged || super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (MotionEventCompat.getActionMasked(event)) {
            case MotionEvent.ACTION_DOWN:
                mActivePointerId = event.getPointerId(0);
                isBeingDragged = false;
                break;
            case MotionEvent.ACTION_MOVE: {
                float y = mLastMotionY = getMotionEventY(event);
                if (isScrollToTop() && !isScrollToBottom()) {
                    // 在顶部不在底部
                    mDistance = y - mInitialMotionY;
                    if (mDistance < 0) {
                        return super.onTouchEvent(event);
                    }
                    overScroll(mDistance);
                    return true;
                } else if (isScrollToTop() && isScrollToBottom()) {
                    // 在底部也在顶部
                    mDistance = y - mInitialMotionY;
                    if (mDistance > 0) {
                        overScroll(mDistance);
                    }
                    return true;
                } else {
                    // 不在底部也不在顶部
                    mInitialMotionY = getMotionEventY(event);
                    return super.onTouchEvent(event);
                }
            }
            case MotionEventCompat.ACTION_POINTER_DOWN:
                mActivePointerId = event.getPointerId(MotionEventCompat.getActionIndex(event));
                mInitialMotionY = mInitialMotionY + (getMotionEventY(event) - mLastMotionY);
                break;
            case MotionEventCompat.ACTION_POINTER_UP:
                onSecondaryPointerUp(event);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                if (isScrollToTop() && !isScrollToBottom()) {
                    animateRestore(true);
                } else if (isScrollToTop() && isScrollToBottom()) {
                    if (mDistance > 0) {
                        animateRestore(true);
                    }
                } else {
                    return super.onTouchEvent(event);
                }
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    private boolean isScrollToTop() {
        //-1表示下拉，返还false表示到顶部
        return !ViewCompat.canScrollVertically(this, -1);
    }

    private boolean isScrollToBottom() {
        //1表示下拉，返还false表示到底部
        return !ViewCompat.canScrollVertically(this, 1);
    }

    private float getMotionEventY(MotionEvent ev) {
        int index = ev.findPointerIndex(mActivePointerId);
        return index < 0 ? -1f : ev.getY(index);
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = ev.getActionIndex();
        final int pointerId = ev.getPointerId(pointerIndex);
        if (pointerId == mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mActivePointerId = ev.getPointerId(newPointerIndex);
            mInitialMotionY = mInitialMotionY + (getMotionEventY(ev) - mLastMotionY);
        }
    }

    private void overScroll(float distance) {
        if (OverScrollListener != null) {
            OverScrollListener.onOverScroll(distance);
        }
    }

    private void animateRestore(final boolean isPullRestore) {
        ValueAnimator animator = ValueAnimator.ofFloat(mDistance, 0f);
        animator.setDuration(300);
        animator.setInterpolator(new DecelerateInterpolator(2f));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                if (isPullRestore) {
                    overScroll(value);
                }
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                isRestoring = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isRestoring = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }
}
