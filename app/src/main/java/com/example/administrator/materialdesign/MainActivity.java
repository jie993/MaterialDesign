package com.example.administrator.materialdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.materialdesign.fragment.myNewsFragment;
import com.example.administrator.materialdesign.fragment.news_aboutme;
import com.example.administrator.materialdesign.fragment.news_comment;
import com.example.administrator.materialdesign.fragment.news_inform;
import com.example.administrator.materialdesign.fragment.news_privatechat;

public class MainActivity extends AppCompatActivity {
    private NavigationView navView;

    private Toolbar toolbar;
    private DrawerLayout draw_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "你点击了菜单按钮", Toast.LENGTH_SHORT).show();
                draw_layout.openDrawer(GravityCompat.START);
                break;
            case R.id.more:
                Toast.makeText(this, "你点击了more按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.download:
                Toast.makeText(this, "你的点击了download按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.other:
                Toast.makeText(this, "你的点击了other按钮", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        draw_layout = (DrawerLayout) findViewById(R.id.draw_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
           actionBar.setDisplayHomeAsUpEnabled(true);
           actionBar.setHomeAsUpIndicator(R.drawable.menu_more);
       }
        navView = (NavigationView) findViewById(R.id.nav_view);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_frame,new myNewsFragment());
                transaction.commit();
                draw_layout.closeDrawers();

                return true;
            }
        });

    }
}
