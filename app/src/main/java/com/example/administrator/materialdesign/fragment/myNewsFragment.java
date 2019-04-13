package com.example.administrator.materialdesign.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.materialdesign.R;

/**
 * Created by Administrator on 2019\4\6 0006.
 */

public class myNewsFragment extends Fragment {
    private news_aboutme news_aboutme_fragment;
    private news_comment news_comment_fragment;
    private news_inform news_inform_fragment;
    private news_privatechat news_privatechat_fragment;
    private BottomNavigationView navigationMenu;
    private Button but1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mynews_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show_news_privatechatFragment();
        navigationMenu = (BottomNavigationView) getActivity().findViewById(R.id.news_Bottom);
        navigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.news_sx:
                        show_news_privatechatFragment();
                        break;
                    case R.id.news_comment:
                        show_news_commentFragment();
                        break;
                    case R.id.news_inform:
                        show_news_informFragment();
                        break;
                    case R.id.news_me:
                        show_news_aboutmeFragment();
                        break;
                    default:
                }
                return true;
            }
        });
    }
    /*viewPager1.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startX = (int) motionEvent.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    endX = (int) motionEvent.getX();
                    if (currentPage == vlist.size()-1){
                        if(startX-endX> ScreenUtils.width/4){
                            startActivity(new Intent(Main3Activity.this,Main2Activity.class));
                        }
                    }
                    break;
            }
            return false;
        }
    });*/
    public void hideNewsAllFragment(FragmentTransaction ft) {
        if (news_aboutme_fragment != null) {
            ft.hide(news_aboutme_fragment);
        }
        if (news_comment_fragment != null) {
            ft.hide(news_comment_fragment);
        }
        if (news_inform_fragment != null) {
            ft.hide(news_inform_fragment);
        }
        if (news_privatechat_fragment != null) {
            ft.hide(news_privatechat_fragment);
        }
    }

    public void show_news_commentFragment() {

//      注意这里是调用getChildFragmentManager()方法
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

       /* FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();*/
        hideNewsAllFragment(transaction);
        if (news_comment_fragment == null) {
            news_comment_fragment = new news_comment();
            transaction.add(R.id.news_frameLayout, news_comment_fragment);
        }
        transaction.show(news_comment_fragment);
        transaction.commit();
    }

    public void show_news_informFragment() {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();*/
        hideNewsAllFragment(transaction);
        if (news_inform_fragment == null) {
            news_inform_fragment = new news_inform();
            transaction.add(R.id.news_frameLayout, news_inform_fragment);
        }
        transaction.show(news_inform_fragment);
        transaction.commit();
    }

    public void show_news_privatechatFragment() {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideNewsAllFragment(transaction);
        if (news_privatechat_fragment == null) {
            news_privatechat_fragment = new news_privatechat();
            transaction.add(R.id.news_frameLayout, news_privatechat_fragment);
        }
        transaction.show(news_privatechat_fragment);
        transaction.commit();
    }

    public void show_news_aboutmeFragment() {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideNewsAllFragment(transaction);
        if (news_aboutme_fragment == null) {
            news_aboutme_fragment = new news_aboutme();
            transaction.add(R.id.news_frameLayout, news_aboutme_fragment);
        }
        transaction.show(news_aboutme_fragment);
        transaction.commit();
    }
}
