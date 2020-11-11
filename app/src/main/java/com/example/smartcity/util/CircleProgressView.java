package com.example.smartcity.util;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;


/**
 * @LogIn Name com.example.smartcity.util
 * @Create by 张瀛煜 on 2020/11/5 at 9:16 PM
 */
public class CircleProgressView extends View {
    public CircleProgressView(Context context) {
        super(context);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    Paint paint;

    private void initView(Context context, AttributeSet attrs) {
        paint = new Paint();
        startAnim(0);

    }

    private float progress = 0f;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int circlePoint = getWidth() / 2;
        //第一步:画背景(即内层圆)
        paint.setColor(Color.parseColor("#cccccc")); //设置圆的颜色
        paint.setStyle(Paint.Style.STROKE); //设置空心
        paint.setStrokeWidth(6); //设置圆的宽度
        paint.setAntiAlias(true);  //消除锯齿
        canvas.drawCircle(circlePoint, circlePoint, getWidth() / 2, paint); //画出圆
        RectF oval = new RectF(circlePoint-getWidth()/2, circlePoint-getWidth()/2,
                circlePoint+getWidth()/2, circlePoint+getWidth()/2);  //用于定义的圆弧的形状和大小的界限
        paint.setColor(Color.RED);  //设置进度的颜色
        canvas.drawArc(oval, -90, 360-360 * (progress / 100), false, paint);  //根据进度画圆弧
    }

     private ValueAnimator animator;
    private void startAnim(float startProgress) {
        animator = ObjectAnimator.ofFloat(100, startProgress);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                CircleProgressView.this.progress = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        }); 
        animator.setDuration(3000);
        animator.setInterpolator(new LinearInterpolator());   //动画匀速
        animator.start();
    }
}
