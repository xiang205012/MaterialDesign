package com.gordon.materialdesign.coordinatorLayout;

/**
 * Created by gordon on 2017/2/24
 */

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 继承CoordinatorLayout.Behavior<T>,其中，泛型参数T是我们要执行动作的View类，
 * 也就是Child。然后就是去实现Behavior的两个方法：


  判断child的布局是否依赖dependency
 @Override
 public boolean layoutDependsOn(CoordinatorLayout parent, T child, View dependency) {
     boolean rs;
     //根据逻辑判断rs的取值
     //返回false表示child不依赖dependency，ture表示依赖
     return rs;
 }


  当dependency发生改变时（位置、宽高等），执行这个函数
  返回true表示child的位置或者是宽高要发生改变，否则就返回false
 @Override
 public boolean onDependentViewChanged(CoordinatorLayout parent, T child, View dependency) {
     //child要执行的具体动作
     return true;
 }
 */
public class MyBehavior extends CoordinatorLayout.Behavior<Button>{

    private int screenWidth;

    public MyBehavior(){}

    public MyBehavior(Context context, AttributeSet attrs){
        super(context,attrs);
        Log.d("TAG -- >>"," Behavior 构造函数调用");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
    }



    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        //如果dependency是TempView的实例，说明它就是我们所需要的Dependency
        return dependency instanceof TempView;
    }

    /**
     * //每次dependency位置发生变化，都会执行onDependentViewChanged方法
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {
        // 根据dependency的位置，设置button的位置
        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = screenWidth - left - child.getWidth();
        int y = top;

        setButtonLayout(child,x,y);

        return true;
    }

    private void setButtonLayout(Button child, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) child.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        child.setLayoutParams(layoutParams);
    }
}
