package com.example.usher.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by USHER on 2017/7/3.
 */

public class CustomView4 extends View {

    private int widthSize;
    private int heightSize;

    public CustomView4(Context context) {
        super(context);
    }

    public CustomView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);//这里面是原始的大小，需要重新计算可以修改本行
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        Path path = new Path();
        int wd = widthSize / 8;
        paint.setAntiAlias(true);
        int hd = heightSize / 5;
        path.moveTo(25, 0);
        path.quadTo(0, 0, 0, 25);
        path.lineTo(0, hd + 10);
        path.quadTo(0, hd + 20, 10, hd + 30);
        path.quadTo(20, hd + 40, 10, hd + 50);
        path.quadTo(0, hd + 60, 0, hd + 80);
        path.lineTo(0, heightSize - 25);
        path.quadTo(0, heightSize, 25, heightSize);
        path.lineTo(widthSize - 25, heightSize);
        path.quadTo(widthSize, heightSize, widthSize, heightSize - 25);
        path.lineTo(widthSize, hd + 80);
        path.quadTo(widthSize, hd + 60, widthSize - 10, hd + 50);
        path.quadTo(widthSize - 20, hd + 40, widthSize - 10, hd + 30);
        path.quadTo(widthSize, hd + 20, widthSize, hd + 10);
        path.lineTo(widthSize, 25);
        path.quadTo(widthSize, 0, widthSize - 25, 0);
        path.lineTo(25, 0);
        canvas.drawPath(path, paint);
    }


}
