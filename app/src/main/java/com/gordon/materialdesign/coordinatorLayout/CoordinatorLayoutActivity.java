package com.gordon.materialdesign.coordinatorLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gordon.materialdesign.R;

/**
 * Created by gordon on 2017/2/24
 */


/**
 * CoordinatorLayout作为“super-powered FrameLayout”基本实现两个功能：
 1、作为顶层布局
 2、调度协调子布局

 CoordinatorLayout使用新的思路通过协调调度子布局的形式实现触摸影响布局的形式产生动画效果。
 CoordinatorLayout通过设置子View的 Behaviors来调度子View。
 系统（Support V7）提供了AppBarLayout.Behavior, AppBarLayout.ScrollingViewBehavior,
 FloatingActionButton.Behavior, SwipeDismissBehavior<V extends View> 等。

 CoordinatorLayout的使用核心是Behavior，Behavior就是执行你定制的动作。
 在讲Behavior之前必须先理解两个概念：Child和Dependency，什么意思呢？
 Child当然是子View的意思了，是谁的子View呢，当然是CoordinatorLayout的子View；
 其实Child是指要执行动作的CoordinatorLayout的子View。而Dependency是指Child依赖的View。
 比如上面的gif图中，蓝色的View就是Dependency，黄色的View就是Child，因为黄色的View的动作是依赖于蓝色的View。
 简而言之，就是如过Dependency这个View发生了变化，那么Child这个View就要相应发生变化。
 发生变化是具体发生什么变化呢？这里就要引入Behavior，Child发生变化的具体执行的代码都是放在Behavior这个类里面。
 */
public class CoordinatorLayoutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);


    }
}
