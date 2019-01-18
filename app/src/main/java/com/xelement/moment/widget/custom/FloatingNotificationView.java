package com.xelement.moment.widget.custom;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.entity.NotificationEntity;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.UIUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FloatingNotificationView extends FrameLayout {

    private Context mContext;

    @BindView(R.id.mNotificationLayout)
    View mNotificationLayout;
    @BindView(R.id.mAvatarImg)
    CircleImageView mAvatarImg;
    @BindView(R.id.mNotificationLabel)
    TextView mNotificationLabel;

    private List<NotificationEntity> entities;
    private int currentCount = 0;

    ObjectAnimator animOut;
    ObjectAnimator animIn;

    public FloatingNotificationView(@NonNull Context context) {
        super(context, null);
    }

    public FloatingNotificationView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatingNotificationView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_floating_notification, this);
        ButterKnife.bind(this, view);

        animIn = ObjectAnimator.ofFloat(mNotificationLayout, "alpha", 0f, 1f, 1f, 1f, 1f, 1f);
        animIn.setDuration(3000);

        animOut = ObjectAnimator.ofFloat(mNotificationLayout, "alpha", 1f, 1f, 1f, 1f, 1f, 0f, 0f, 0f);
        animOut.setDuration(4000);
    }

    public void refresh() {
        entities = DataUtil.getNotificationData();
        startShowNotification();
    }

    private Handler mHanlder = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    setVisibility(VISIBLE);
                    animIn();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            mHanlder.sendEmptyMessage(1);
            mHanlder.postDelayed(this, 8 * 1000);//延迟5秒,再次执行task本身,实现了循环的效果
        }
    };

    private void startShowNotification() {
        if (entities == null || entities.isEmpty()) {
            return;
        }

        currentCount = 0;
        updateView();
        mHanlder.postDelayed(task, 3000);//第一次调用,延迟1秒执行task
    }

    private void updateView() {
        if (!((BaseActivity) mContext).isFinishing()) {
            Glide.with(mContext)
                    .load(entities.get(currentCount).image)
                    .into(mAvatarImg);

            NotificationEntity entity = entities.get(currentCount);

            String str = entity.name + "1分钟前以" + CommonUtil.getPrice("", entity.price) + "购买了" + entity.product;
            mNotificationLabel.setText(CommonUtil.getColorfulString(str, UIUtil.getColor(R.color.flash_red), 5 + entity.name.length(), 5+entity.name.length() + CommonUtil.getPrice("", entity.price).length()));
        }
    }

    private void animIn() {
        animIn.start();
        animIn.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animOut();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    private void animOut() {
        animOut.start();
        animOut.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                currentCount = (currentCount + 1) % entities.size();
                updateView();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void release() {
        animIn.cancel();
        animOut.cancel();
        animIn.removeAllListeners();
        animOut.removeAllListeners();
        mHanlder.removeCallbacks(task);
    }
}
