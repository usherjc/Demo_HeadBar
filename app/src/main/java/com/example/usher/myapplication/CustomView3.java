package com.example.usher.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by USHER on 2017/7/3.
 */

public class CustomView3 extends View {

    private int widthSize;
    private int heightSize;
    int color[];

    public CustomView3(Context context) {
        super(context);
    }

    public CustomView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);//这里面是原始的大小，需要重新计算可以修改本行
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制贝塞尔曲线
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(20);
        Path path = new Path();
        int wd = widthSize / 8;
        paint.setAntiAlias(true);
        LinearGradient lg = new LinearGradient(wd / 2, 0, 0, 0, Color.parseColor("#17abe3"), Color.parseColor("#ea9518"), Shader.TileMode.CLAMP);
        paint.setShader(lg);
        int hd = heightSize / 5;
        path.moveTo(0, 0);
        path.lineTo(wd, 0);
        path.quadTo(wd * 2, 0, wd * 3, hd);
        path.quadTo(wd * 4, hd * 2, wd * 5, hd);
        path.quadTo(wd * 6, 0, wd * 7, 0);
        path.lineTo(wd * 8, 0);
        canvas.drawPath(path, paint);

        //绘制圆点
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        paint1.setStrokeWidth(5);
        paint1.setColor(Color.parseColor("#17abe3"));
        paint.setAntiAlias(true);
        canvas.drawCircle(wd * 4, (float) (hd * 2.5), 5, paint1);

        //绘制文字
        Paint paint3 = new Paint();
        paint3.setColor(Color.WHITE);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        paint3.setStrokeWidth(1);
        paint3.setAntiAlias(true);
        paint3.setTextSize(20);
        paint3.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("20%", 4 * wd, (float) (hd * 1.2), paint3);
/*
        //绘制对号
        Paint paint4 = new Paint();
        paint4.setColor(Color.WHITE);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(5);
        paint4.setAntiAlias(true);
        Path path1 = new Path();
        path1.moveTo((float) (3.5 * wd)+2, hd / 2 + 7);
        path1.lineTo(4 * wd, hd + 5);
        path1.lineTo((float) (4.5 * wd), hd / 4 + 5);
        canvas.drawPath(path1, paint4);*/
    }


}
