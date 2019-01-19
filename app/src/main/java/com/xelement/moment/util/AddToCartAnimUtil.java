package com.xelement.moment.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.View;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;
import com.xelement.moment.R;
import com.xelement.moment.widget.custom.CircleImageView;
import com.youth.banner.loader.ImageLoader;

/**
 * Datetime: 2019/1/12 10:51
 * Author: zcj
 */
public class AddToCartAnimUtil {

    public static void startAnim(Activity activity, final FrameLayout decorView, PointF endPos, Integer imgUrl) {
        final CircleImageView circleImageView = new CircleImageView(activity);
        Glide.with(activity)
                .load(imgUrl)
                .into(circleImageView);
        int radius = (int) UIUtil.getDimen(R.dimen.x80);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(radius, radius);
        decorView.addView(circleImageView, lp);

        //①执行透明度动画   0f -> 1f -> 0.5f;
        //②执行缩放动画     8f -> 0.8f -> 1.1f -> 0.2f
        //②执行位移动画     startPos -> startPos -> endPos

        Keyframe aK1 = Keyframe.ofFloat(0, 0f);
        Keyframe aK2 = Keyframe.ofFloat(0.1f, 1f);
        Keyframe aK3 = Keyframe.ofFloat(0.5f, 1f);
        Keyframe aK4 = Keyframe.ofFloat(1f, 0.5f);
        PropertyValuesHolder aPVH = PropertyValuesHolder.ofKeyframe("alpha", aK1, aK2, aK3, aK4);

        Keyframe sK1 = Keyframe.ofFloat(0, 8f);
        Keyframe sK2 = Keyframe.ofFloat(0.1f, 1f);
        Keyframe sK3 = Keyframe.ofFloat(0.5f, 2f);
        Keyframe sK4 = Keyframe.ofFloat(1f, 0.2f);
        PropertyValuesHolder sXPVH = PropertyValuesHolder.ofKeyframe("scaleX", sK1, sK2, sK3, sK4);
        PropertyValuesHolder sYPVH = PropertyValuesHolder.ofKeyframe("scaleY", sK1, sK2, sK3, sK4);

        Keyframe tXK1 = Keyframe.ofFloat(0, (decorView.getWidth() - radius) / 2);
        Keyframe tXk2 = Keyframe.ofFloat(0.5f, (decorView.getWidth() - radius) / 2);
        Keyframe tXk3 = Keyframe.ofFloat(1f, endPos.x);
        //PropertyValuesHolder tXPVH = PropertyValuesHolder.ofKeyframe("translationX", tXK1, tXk2, tXk3);

        Keyframe tYK1 = Keyframe.ofFloat(0, (decorView.getWidth() - radius) / 2);
        Keyframe tYk2 = Keyframe.ofFloat(0.5f, (decorView.getWidth() - radius) / 2);
        Keyframe tYk3 = Keyframe.ofFloat(1f, endPos.y);
        //PropertyValuesHolder tYPVH = PropertyValuesHolder.ofKeyframe("translationY", tYK1, tYk2, tYk3);

        final Path path = new Path();
        PropertyValuesHolder.ofObject(View.X, new TypeEvaluator<Float>() {
            @Override
            public Float evaluate(float fraction, Float startValue, Float endValue) {
                return null;
            }
        }, 0f, 1f);

        final float startX = (decorView.getWidth() - radius) / 2;
        final float startY = (decorView.getWidth() - radius) / 2;
        float endX = endPos.x;
        float endY = endPos.y;
        float controlX = endX;
        float controlY = startY;
        path.moveTo(startX, startY);
        path.quadTo(controlX, controlY, endX, endY);
        final PathMeasure pathMeasure = new PathMeasure(path, false);
        final float[] pos = new float[2];
        final float[] tan = new float[2];
        TypeEvaluator<Float> BezierX = new TypeEvaluator<Float>() {
            @Override
            public Float evaluate(float fraction, Float startValue, Float endValue) {
                if (fraction <= 0.5f) {
                    return startX;
                } else {
                    pathMeasure.getPosTan(pathMeasure.getLength() * ((fraction - 0.5f) * 2), pos, tan);
                    return pos[0];
                }
            }
        };

        TypeEvaluator<Float> BezierY = new TypeEvaluator<Float>() {
            @Override
            public Float evaluate(float fraction, Float startValue, Float endValue) {
                if (fraction <= 0.5f) {
                    return startY;
                } else {
                    pathMeasure.getPosTan(pathMeasure.getLength() * ((fraction - 0.5f) * 2), pos, tan);
                    return pos[1];
                }
            }
        };

        PropertyValuesHolder tXPVH = PropertyValuesHolder.ofObject(View.TRANSLATION_X.getName(), BezierX, 0f, 1f);
        PropertyValuesHolder tYPVH = PropertyValuesHolder.ofObject(View.TRANSLATION_Y.getName(), BezierY, 0f, 1f);

        ValueAnimator anim = ObjectAnimator.ofPropertyValuesHolder(circleImageView, aPVH, sXPVH, sYPVH, tXPVH, tYPVH);
        anim.setDuration(1000);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                onAnimationEnd(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                decorView.removeView(circleImageView);
            }
        });
        anim.start();
    }
}
