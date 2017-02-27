package com.gordon.materialdesign.drawerLayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.gordon.materialdesign.R;

/**
 * Created by gordon on 2017/2/27
 */

public class DrawerLayoutActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_drawerlayout);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        toolbar = (Toolbar) findViewById(R.id.toolbar_drawer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_content_layout,new DrawerMainFragment()).commit();

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        actionBarDrawerToggle.syncState();// 初始化
        // 关联actionBar和drawerLayout的监听
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        // 让item menu的图标颜色不过滤，以原图显示（设置菜单项的图标的着色）
        navigationView.setItemIconTintList(null);
        // navigationView 头部控件处理
        View naviHeaderView = navigationView.getHeaderView(0);
        ImageView headerImg = (ImageView) naviHeaderView.findViewById(R.id.profile_image);
        headerImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DrawerLayoutActivity.this,"navigationView 头像点击",Toast.LENGTH_SHORT).show();
            }
        });
        // navigationView item点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);// 改变选中状态的item背景，默认是灰色
                String msg = "";
                switch (item.getItemId()) {
                    case R.id.navigation_person:
                        msg = "个人设置";
                        break;
                    case R.id.navigation_item_intimity:
                        msg = "隐私设置";
                        break;
                    case R.id.navigation_item_system:
                        msg = "系统设置";
                        break;
                    case R.id.navigation_item_about:
                        msg = "关于";
                        break;
                }
                Toast.makeText(DrawerLayoutActivity.this,msg,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Log.d("TAG","按返回键....");
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //drawerLayout.closeDrawers();
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
