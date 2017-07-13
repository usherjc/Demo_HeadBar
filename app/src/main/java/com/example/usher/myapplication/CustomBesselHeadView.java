package com.example.usher.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by UsherChen on 2017/7/3.
 * Details
 */

public class CustomBesselHeadView extends View {

    private Context context;
    private int mTotalWidth;
    private int mTotalHight;
    private boolean isLeftEdge;
    private boolean isRightEdge;
    private boolean isLeftGradient;
    private boolean isRightGradient;
    private int leftColorPath;
    private int rightColorPath;
    private boolean isNow;
    private String text;

    public CustomBesselHeadView(Context context) {
        super(context);
        this.context = context;
    }

    public CustomBesselHeadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initAttr(context, attrs);
    }

    private void initAttr(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomBesselHeadView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取宽度
        mTotalWidth = MeasureSpec.getSize(widthMeasureSpec);
        //获取高度
        mTotalHight = MeasureSpec.getSize(heightMeasureSpec);
        //重新计算
        setMeasuredDimension(mTotalWidth, mTotalHight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBesselSingle(
                canvas,
                isLeftEdge,
                isRightEdge,
                isLeftGradient,
                isRightGradient,
                leftColorPath,
                rightColorPath
        );
        if (isNow) {
            drawCircleDot(canvas, 5, 6);
        }
        drawNumPercent(canvas, text, mTotalWidth / 8, 0, false);
        super.onDraw(canvas);
    }


    /**
     * 绘制贝塞尔曲线
     *
     * @param canvas          画布
     * @param isLeftEdge      是否是左侧第一个
     * @param isRightEdge     是否是右侧第一个
     * @param isLeftGradient  左侧是否需要渐变色
     * @param isRightGradient 右侧是否需要渐变色
     * @param leftColorPath   左侧颜色
     * @param rightColorPath  右侧颜色
     */
    private void drawBesselSingle(
            Canvas canvas,
            boolean isLeftEdge,
            boolean isRightEdge,
            boolean isLeftGradient,
            boolean isRightGradient,
            int leftColorPath,
            int rightColorPath
    ) {
        int x = mTotalWidth / 8;
        int y = mTotalHight / 5;
        //初始化画笔
        Paint paint = new Paint();
        paint.setColor(leftColorPath);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        LinearGradient linearGradient = null;
        if (isLeftGradient) {
            linearGradient = new LinearGradient(
                    20,
                    0,
                    0,
                    0,
                    rightColorPath,
                    leftColorPath,
                    Shader.TileMode.CLAMP
            );
        }
        if (isRightGradient) {
            linearGradient = new LinearGradient(
                    mTotalWidth - 20,
                    0,
                    mTotalWidth,
                    0,
                    leftColorPath,
                    rightColorPath,
                    Shader.TileMode.CLAMP
            );
        }
        if (linearGradient != null) {
            paint.setShader(linearGradient);
        }
        paint.setAntiAlias(true);
        //初始化Path
        Path path = new Path();
        if (isLeftEdge) {
            //绘制左侧边缘弧线
            {
                path.moveTo(8, 0);//第一个点即为起点
                path.quadTo(0, 4, 8, 8);//(0,1)相当于控制点(3,2)相当于终点
            }
        } else {
            path.moveTo(8, 0);
            path.lineTo(0, 0);
            path.lineTo(0, 8);
        }
        //绘制从边缘弧线结束到第一个突起启动的位置
        {
            path.lineTo(x * 2, 8);//相当于下一次绘制贝塞尔曲线的起点
        }
        //绘制突起
        {
            //绘制第一个曲线
            float x3_1 = x * 2 + x / 2;
            float y3_1 = 8;
            float x3_2 = x * 3;
            float y3_2 = y;
            path.quadTo(x3_1, y3_1, x3_2, y3_2);
            //绘制第二个曲线
            float x3_3 = x * 4;
            float y3_3 = y * 2;
            float x3_4 = x * 5;
            float y3_4 = y;
            path.quadTo(x3_3, y3_3, x3_4, y3_4);
            //绘制第三个曲线
            float x3_5 = x * 5 + x / 2;
            float y3_5 = 8;
            float x3_6 = x * 6;
            float y3_6 = 8;
            path.quadTo(x3_5, y3_5, x3_6, y3_6);
        }
        //绘制曲线结束到下一个边缘再到起点闭合
        if (isRightEdge) {
            path.lineTo(mTotalWidth - 8, 8);
            path.quadTo(mTotalWidth, 4, mTotalWidth - 8, 0);
        } else {
            path.lineTo(mTotalWidth, 8);
            path.lineTo(mTotalWidth, 0);
        }
        {
            path.lineTo(8, 0);
        }
        canvas.drawPath(path, paint);
    }

    /**
     * 绘制文字
     * 注：对号直接使用此方法绘制
     *
     * @param canvas      画布
     * @param textSize    文字大小
     * @param off_y       竖直方向上的偏移量用来微调高度
     * @param isTypeFaced 是否使用特殊字体
     */
    private void drawNumPercent(Canvas canvas, String text, float textSize, int off_y, boolean isTypeFaced) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        if (isTypeFaced) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/calibril.ttf");
            paint.setTypeface(typeface);
        }
        int x = mTotalWidth / 2 - 2;
        int y = mTotalHight / 5 - off_y;//稍作偏移
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, x, y, paint);
    }

    /**
     * 绘制圆点
     *
     * @param canvas 画布
     * @param off_y  竖直方向上的偏移量用来微调高度
     * @param radius 半径
     */
    private void drawCircleDot(Canvas canvas, int off_y, float radius) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(leftColorPath);
        paint.setAntiAlias(true);
        int x = mTotalWidth / 2 - 2;
        int y = mTotalHight / 5 * 2 + off_y;
        canvas.drawCircle(x, y, radius, paint);
    }

    public void setState(boolean isLeftEdge,
                         boolean isRightEdge,
                         boolean isLeftGradient,
                         boolean isRightGradient,
                         int leftColorPath,
                         int rightColorPath,
                         boolean isNow,
                         String text
    ) {
        this.isLeftEdge = isLeftEdge;
        this.isRightEdge = isRightEdge;
        this.isLeftGradient = isLeftGradient;
        this.isRightGradient = isRightGradient;
        this.leftColorPath = leftColorPath;
        this.rightColorPath = rightColorPath;
        this.isNow = isNow;
        this.text = text;
    }

}
