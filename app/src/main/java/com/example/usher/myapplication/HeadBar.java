package com.example.usher.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by UsherChen on 2017/7/12.
 * Details
 */

public class HeadBar extends LinearLayout {

    private Context context;

    class STATE {
        public static final int STATE1 = 1;
        public static final int STATE2 = 2;
        public static final int STATE3 = 3;
        public static final int STATE4 = 4;
        public static final int STATE5 = 5;
    }

    private CustomBesselHeadView mChv1;
    private CustomBesselHeadView mChv2;
    private CustomBesselHeadView mChv3;
    private CustomBesselHeadView mChv4;
    private CustomBesselHeadView mChv5;

    public HeadBar(Context context) {
        super(context);
        initView(context);
    }

    public HeadBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        inflate(context, R.layout.view_headtab, this);
        mChv1 = (CustomBesselHeadView) findViewById(R.id.chv_1);
        mChv2 = (CustomBesselHeadView) findViewById(R.id.chv_2);
        mChv3 = (CustomBesselHeadView) findViewById(R.id.chv_3);
        mChv4 = (CustomBesselHeadView) findViewById(R.id.chv_4);
        mChv5 = (CustomBesselHeadView) findViewById(R.id.chv_5);
    }

    public void setThisState(int state) {
        if (state == STATE.STATE1) {
            mChv1.setState(true, false, false, true, context.getResources().getColor(R.color.yellow_1), context.getResources().getColor(R.color.grey_1), true, "20%");
            mChv2.setState(false, false, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
            mChv3.setState(false, false, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
            mChv4.setState(false, false, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
            mChv5.setState(false, true, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
        }
        if (state == STATE.STATE2) {
            mChv1.setState(true, false, false, true, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.yellow_1), false, "√");
            mChv2.setState(false, false, false, true, context.getResources().getColor(R.color.yellow_1), context.getResources().getColor(R.color.grey_1), true, "40%");
            mChv3.setState(false, false, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
            mChv4.setState(false, false, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
            mChv5.setState(false, true, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
        }
        if (state == STATE.STATE3) {
            mChv1.setState(true, false, false, false, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.blue_4), false, "√");
            mChv2.setState(false, false, false, true, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.yellow_1), false, "√");
            mChv3.setState(false, false, false, true, context.getResources().getColor(R.color.yellow_1), context.getResources().getColor(R.color.grey_1), true, "60%");
            mChv4.setState(false, false, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
            mChv5.setState(false, true, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
        }
        if (state == STATE.STATE4) {
            mChv1.setState(true, false, false, false, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.blue_4), false, "√");
            mChv2.setState(false, false, false, false, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.blue_4), false, "√");
            mChv3.setState(false, false, false, true, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.yellow_1), false, "√");
            mChv4.setState(false, false, false, true, context.getResources().getColor(R.color.yellow_1), context.getResources().getColor(R.color.grey_1), true, "80%");
            mChv5.setState(false, true, false, false, context.getResources().getColor(R.color.grey_1), context.getResources().getColor(R.color.grey_1), false, "");
        }
        if (state == STATE.STATE5) {
            mChv1.setState(true, false, false, false, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.blue_4), false, "√");
            mChv2.setState(false, false, false, false, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.blue_4), false, "√");
            mChv3.setState(false, false, false, false, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.blue_4), false, "√");
            mChv4.setState(false, false, false, true, context.getResources().getColor(R.color.blue_4), context.getResources().getColor(R.color.yellow_1), false, "√");
            mChv5.setState(false, true, false, false, context.getResources().getColor(R.color.yellow_1), context.getResources().getColor(R.color.yellow_1), true, "100%");
        }
        invalidate();
    }

}
