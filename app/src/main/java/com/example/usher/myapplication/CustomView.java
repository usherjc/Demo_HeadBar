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

public class CustomView extends View {

    private int widthSize;
    private int heightSize;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
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
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        Path path = new Path();
        int wd = widthSize / 6;
        int hd = heightSize / 3;
        path.moveTo(0, 0);
        path.quadTo(wd, 0, wd * 2, hd);
        path.quadTo(wd * 3, hd * 2, wd * 4, hd);
        path.quadTo(wd * 5, 0, wd * 6, 0);
        canvas.drawPath(path, paint);
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        paint1.setStrokeWidth(2);
        paint1.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        canvas.drawCircle(wd * 3, (float) (hd * 2.5), 5, paint1);
    }


}
