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

public class CustomView2 extends View {

    private int widthSize;
    private int heightSize;
    int color[];

    public CustomView2(Context context) {
        super(context);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs) {
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

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(20);
        Path path = new Path();
        int wd = widthSize / 8;
        paint.setAntiAlias(true);
        LinearGradient lg = new LinearGradient(wd, 0, 0, 0, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        paint.setShader(lg);
        int hd = heightSize / 5;
        path.moveTo(0, 0);
        path.lineTo(wd, 0);
        path.quadTo(wd * 2, 0, wd * 3, hd);
        path.quadTo(wd * 4, hd * 2, wd * 5, hd);
        path.quadTo(wd * 6, 0, wd * 7, 0);
        path.lineTo(wd * 8, 0);

        canvas.drawPath(path, paint);
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        paint1.setStrokeWidth(5);
        paint1.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        canvas.drawCircle(wd * 4, (float) (hd * 2.5), 5, paint1);

        Paint paint3 = new Paint();
        paint3.setColor(Color.WHITE);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        paint3.setStrokeWidth(1);
        paint3.setAntiAlias(true);
        paint3.setTextSize(20);
        paint3.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("20%", 4 * wd, hd, paint3);
    }


}
