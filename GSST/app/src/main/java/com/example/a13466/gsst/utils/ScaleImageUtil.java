package com.example.a13466.gsst.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;

   public class ScaleImageUtil extends android.support.v7.widget.AppCompatImageView implements ViewTreeObserver.OnGlobalLayoutListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {
        //放大最大值
        public static final float SCALE_MAX = 20.0f;
        //初始化时的缩放比例，如果图片宽或高大于屏幕，此值将小于0
        private float initScale = 3.0f;
        //用于存放矩阵的9个值
        private final float[] matrixValues = new float[9];
        private boolean once = false;
        // 缩放的手势检测
        private ScaleGestureDetector mScaleGestureDetector = null;
        private final Matrix mScaleMatrix = new Matrix();


        @SuppressLint("ClickableViewAccessibility")
        public ScaleImageUtil(Context context) {
            super(context);
            super.setScaleType(ScaleType.MATRIX);
            mScaleGestureDetector = new ScaleGestureDetector(context, this);
            this.setOnTouchListener(this);
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scale = getScale();
            float scaleFactor = detector.getScaleFactor();
            if (getDrawable() == null)
                return true;

            //缩放的范围控制
            if ((scale < SCALE_MAX && scaleFactor > 1.0f) || (scale > initScale && scaleFactor < 1.0f)) {
                //最大值最小值判断
                if (scaleFactor * scale < initScale) {
                    scaleFactor = initScale / scale;
                }
                if (scaleFactor * scale > SCALE_MAX) {
                    scaleFactor = SCALE_MAX / scale;
                }
                //设置缩放比例
                mScaleMatrix.postScale(scaleFactor, scaleFactor, getWidth() / 2,getHeight() / 2);
                setImageMatrix(mScaleMatrix);
            }
            return true;

        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return mScaleGestureDetector.onTouchEvent(event);
        }

        /**
         * 获得当前的缩放比例
         * @return
         */
        public final float getScale() {
            mScaleMatrix.getValues(matrixValues);
            return matrixValues[Matrix.MSCALE_X];
        }

        @Override
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            getViewTreeObserver().addOnGlobalLayoutListener(this);//注册onGlobalLayoutListener
        }

        @Override
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            getViewTreeObserver().removeGlobalOnLayoutListener(this); //移除onGlobalLayoutListener
        }

        @Override
        public void onGlobalLayout() {
            if (!once) {
                Drawable d = getDrawable();
                if (d == null)return;
                int width = getWidth();
                int height = getHeight();
                // 拿到图片的宽和高
                int dw = d.getIntrinsicWidth();
                int dh = d.getIntrinsicHeight();
                initScale = 3.0f;
                // 图片移动至屏幕中心
                mScaleMatrix.postTranslate((width - dw) / 2, (height - dh) / 2);
                mScaleMatrix.postScale(initScale, initScale, getWidth() / 2, getHeight() / 2);
                setImageMatrix(mScaleMatrix);
                once = true;
            }
        }
    }





