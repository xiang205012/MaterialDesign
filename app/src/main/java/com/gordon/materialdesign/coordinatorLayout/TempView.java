package com.gordon.materialdesign.coordinatorLayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by gordon on 2017/2/24
 */

public class TempView extends View {

    private float lastX;
    private float lastY;

    public TempView(Context context) {
        this(context,null);
    }

    public TempView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TempView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getRawX();
        float y = event.getRawY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) this.getLayoutParams();
                layoutParams.leftMargin = (int) (layoutParams.leftMargin + x - lastX);
                layoutParams.topMargin = (int) (layoutParams.topMargin + y - lastY);
                setLayoutParams(layoutParams);
                requestLayout();
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        lastX = x;
        lastY = y;

        return true;
    }
}
