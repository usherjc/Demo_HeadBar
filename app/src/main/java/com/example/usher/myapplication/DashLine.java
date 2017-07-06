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
 * Created by UsherChen on 2017/7/5.
 * Details
 */

public class DashLine extends View {
    public DashLine(Context context) {
        super(context);
    }

    public DashLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private int widthSize;
    private int heightSize;

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
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.GRAY);
        int wd = widthSize / 19;
        int hd = heightSize / 2;
        for (int i = 0; i < 10; i++) {
            Path path = new Path();
            path.moveTo(wd * i * 2, hd);
            path.lineTo(wd * 2 * i + wd, hd);
            canvas.drawPath(path, paint);
        }

    }
}
