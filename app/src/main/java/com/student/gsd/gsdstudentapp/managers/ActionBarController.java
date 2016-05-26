package com.student.gsd.gsdstudentapp.managers;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.base.BaseActivity;

/**
 * Created by dreamfire on 22.05.16.
 */
public final class ActionBarController {
    private Toolbar mToolbar;
    private AppCompatActivity baseActivity;

    private TextView mTvTitle, mTvSkip;
    private ImageView mIvMenu, mIvBack;

    public void register(AppCompatActivity baseActivity){
        this.baseActivity = baseActivity;
        mToolbar = (Toolbar) baseActivity.findViewById(R.id.toolbar);

        findUI();

        baseActivity.setSupportActionBar(mToolbar);
        baseActivity.getSupportActionBar().setHomeButtonEnabled(true);
        baseActivity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    private void findUI(){
        mTvSkip = $(R.id.tvSkip);
        mTvTitle = $(R.id.tvTitle);
        mIvMenu = $(R.id.ivMenu);
        mIvBack = $(R.id.ivBack);
    }

    public Toolbar getToolbar(){
        return mToolbar;
    }

    public void setTitle(String title){
        mTvTitle.setText(title);
    }

    public void menuVisible(boolean isMenu){
        if(isMenu){
            mIvMenu.setVisibility(View.VISIBLE);
            mIvBack.setVisibility(View.GONE);
            hideToolbar(false);
        } else {
            mIvMenu.setVisibility(View.GONE);
            mIvBack.setVisibility(View.VISIBLE);
        }
    }

    public void hideHomeButton(){
        mIvBack.setVisibility(View.GONE);
        mIvMenu.setVisibility(View.GONE);
    }

    public void hideToolbar(boolean isHide){
        if(isHide){
            mToolbar.setVisibility(View.GONE);
        } else {
            mToolbar.setVisibility(View.VISIBLE);
        }
    }

    public void hideSkip(boolean _isVisible){
        if(_isVisible)
        mTvSkip.setVisibility(View.VISIBLE);
        else
            mTvSkip.setVisibility(View.GONE);
    }

    private <T extends View> T $(@IdRes int _resourceId){
        return (T) mToolbar.findViewById(_resourceId);
    }

    public void setClickListener(View.OnClickListener listener){
      mIvBack.setOnClickListener(listener);
    }

    public void initEmptyToolbar(){
        baseActivity.getSupportActionBar().setDisplayShowTitleEnabled(true);
        baseActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mIvBack.setVisibility(View.GONE);
        mTvSkip.setVisibility(View.GONE);
    }

    public void initLoginToolbar(){
        initEmptyToolbar();
        mTvSkip.setVisibility(View.VISIBLE);
        mIvMenu.setVisibility(View.VISIBLE);
        setTitle("WELCOME");
    }

    public void initForgotToolbar(){
        initEmptyToolbar();
        menuVisible(false);
        hideToolbar(false);
        setTitle("Forgot Password");
    }

    public void initRegisteredToolbar(){
        initEmptyToolbar();
        setTitle("REGISTER FOR GSD CARD");
    }

    public void initComProfToolbar(){
        initEmptyToolbar();
        mIvMenu.setVisibility(View.GONE);
        setTitle("COMPLETE PROFILE");

    }
}
