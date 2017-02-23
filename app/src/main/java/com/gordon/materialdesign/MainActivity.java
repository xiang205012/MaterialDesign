package com.gordon.materialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
//            layoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | layoutParams.flags);
//            // 也可以在theme里添加，但是最好在代码中添加 theme中有些机型不生效
//            // 添加style: <item name="android:windowTranslucentStatus"> true </item>后,
//            // 包含toolbar的内容布局就可以扩展至系统状态栏,状态栏会覆盖在toolbar上,
//            // 如果此时使用android:fitsSystemWindows="true",就可以调整内容布局(估计也是在根布局上加padding)恢复到原来位置.
//            // 但是,上面的解决方案确是给toolbar加上一个padding-top="25dp",(因为源码中状态栏的高度是25dp)
//            // 这样就可以做到系统状态栏的颜色和toolbar的颜色保持一致
//
//        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // 将actionBar替换成toolbar
        setSupportActionBar(toolbar);

        // 给左上角图标的左边加上一个返回的图标(系统默认图片) 。对应ActionBar.DISPLAY_HOME_AS_UP
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 设置最左边图标是否显示
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //setHomeButtonEnabled()这个小于4.0版本的默认值为true的。
        //但是在4.0及其以上是false，该方法的作用：决定左上角的图标是否可以点击。
        //没有向左的小图标。 true 图标可以点击  false 不可以点击.

        //使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，
        // 否则，显示应用程序图标，对应id为Android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
        //actionBar.setDisplayShowHomeEnabled(true);
        // 其中setHomeButtonEnabled和setDisplayShowHomeEnabled共同起作用，
        // 如果setHomeButtonEnabled设成false，即使setDisplayShowHomeEnabled设成true，图标也不能点击

        // 自定义最左边的图标，此时setDisplayHomeAsUpEnable被覆盖，
        // 也可以在xml toolbar标签中添加这两句 app:navigationIcon="@drawable/navigationIcon"
        //                                  android:navigationIcon="@drawable/navigationIcon"
//        toolbar.setNavigationIcon(R.mipmap.top_back_icon);
        // 返回图标的id为android.R.id.home  最好在onOptionsItemSelected中监听，
        // 因为NavigationOnClickListener可能找不到android.R.id.home,但是却能拦截onOptionsItemSelected中的响应
        // 如下：
        //    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        //        @Override
        //        public void onClick(View v) {
                      //if(v.getId() == android.R.id.home){
                      // 这样写返回按钮不会响应，直接走下面的toast，同时拦截了onOptionsItemSelected中的返回监听
                      //   Log.d("TAG","click back icon");
                      //}

        //            Toast.makeText(MainActivity.this,"click back icon",Toast.LENGTH_LONG).show();
        //        }
        //    });

        // 添加menu点击事件的监听
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);

    }

    private Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            String msg = "";
            switch(item.getItemId()){
                case R.id.action_edit:
                    msg = "click edit";
                    break;
                case R.id.action_share:
                    msg = "click share";
                    break;
                case R.id.action_settings:
                    msg = "click settings";
                    break;
                case R.id.action_shoucang:
                    msg = "click shoucang";
                    break;
            }
            if (!TextUtils.isEmpty(msg)) {
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }
            return true;
        }
    };

    // 监听返回按钮
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(MainActivity.this,"onItemSelected click back icon",Toast.LENGTH_LONG).show();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // 添加menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
}
