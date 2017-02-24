package com.gordon.materialdesign.toolbar;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.gordon.materialdesign.R;

/**
 * Created by gordon on 2017/2/23
 */

public class CustomToolBarActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout2);
        // 5.0以下才调用此方法设置状态栏透明，只为了让4.4 ~ 5.0之间的机型适配。
        // 5.0以上不需要，只需要将colorPrimaryDark设置成colorPrimary一样的颜色就可以了
        // 如果判断Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT,
        // 那么5.0的机型状态栏是半透明的，6.0是不透明的只是primaryDark和primary颜色一样所以看起来就成了传说中的沉浸式状态栏

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        // 如果想要做成背景是一张图片且延伸到状态栏的效果4.4以上的版本都需要设置状态栏透明
        // 并且去掉android:fitsSystemWindows="true"从而让内容布局延伸到状态栏内
        // fitsSystemWindow="true" 在toolbar上的体现其实相当于设置paddingTop="25dp"
    }
}
