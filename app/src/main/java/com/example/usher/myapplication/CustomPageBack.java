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
 * Created by UsherChen on 2017/7/12.
 * Details
 */

public class CustomPageBack extends View {

    private int mTotalWidth;
    private int mTotalHight;

    public CustomPageBack(Context context) {
        super(context);
    }

    public CustomPageBack(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取宽度
        mTotalWidth = MeasureSpec.getSize(widthMeasureSpec);
        //获取高度
        mTotalHight = MeasureSpec.getSize(heightMeasureSpec);
        //重新计算
        setMeasuredDimension(mTotalWidth, mTotalHight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawPageBack(canvas, 20, 150);
        super.onDraw(canvas);
    }

    /**
     * 绘制背板
     *
     * @param canvas 画布
     * @param angle  圆角角度
     * @param off_y  竖直方向的偏移量
     */
    private void drawPageBack(Canvas canvas, float angle, float off_y) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        Path path = new Path();
        //起点
        {
            path.moveTo(angle, 0);
        }
        //左上方圆角
        {
            path.quadTo(0, 0, 0, angle);
        }
        {
            //到左侧第一个缺口处
            path.lineTo(0, off_y);
            //开始绘制缺口
            path.quadTo(0, off_y + 10, 10, off_y + 20);
            path.quadTo(20, off_y + 30, 10, off_y + 40);
            path.quadTo(0, off_y + 50, 0, off_y + 70);
        }
        //左下方圆角
        {
            path.lineTo(0, mTotalHight - angle);
            path.quadTo(0, mTotalHight, angle, mTotalHight);
        }
        //右下方圆角
        {
            path.lineTo(mTotalWidth - angle, mTotalHight);
            path.quadTo(mTotalWidth, mTotalHight, mTotalWidth, mTotalHight - angle);
        }
        {
            //到右侧第一个缺口处
            path.lineTo(mTotalWidth, off_y + 70);
            //开始绘制缺口
            path.quadTo(mTotalWidth, off_y + 50, mTotalWidth - 10, off_y + 40);
            path.quadTo(mTotalWidth - 20, off_y + 30, mTotalWidth - 10, off_y + 20);
            path.quadTo(mTotalWidth, off_y + 10, mTotalWidth, off_y);
        }
        //右上方圆角
        {
            path.lineTo(mTotalWidth, angle);
            path.quadTo(mTotalWidth, 0, mTotalWidth - angle, 0);
        }
        path.lineTo(angle, 0);
        path.close();//封闭
        canvas.drawPath(path, paint);
    }

}
