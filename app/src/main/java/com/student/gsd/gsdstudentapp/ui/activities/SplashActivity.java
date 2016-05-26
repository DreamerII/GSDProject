package com.student.gsd.gsdstudentapp.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.base.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by dreamfire on 22.05.16.
 */
@EActivity(R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity {

    @AfterViews
    protected void afterViews(){
        new Handler().postDelayed(mRunnable, 3000);
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            LoginActivity_.intent(SplashActivity.this).start();
            finish();
        }
    };
}
