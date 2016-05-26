package com.student.gsd.gsdstudentapp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.managers.FragmentNavigator;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by dreamfire on 21.05.16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private FragmentNavigator mFragmentNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mFragmentNavigator = new FragmentNavigator();
        mFragmentNavigator.register(getSupportFragmentManager(), R.id.container);

    }

//    @AfterInject
//    protected void afterInject(){
//        mFragmentNavigator = new FragmentNavigator();
//        mFragmentNavigator.register(getSupportFragmentManager(), R.id.container);
//    }


    /**
     * The method finding view in activity
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T $(int resId) {
        return (T) findViewById(resId);
    }


    public FragmentNavigator getFragmentNavigator() {
        return mFragmentNavigator;
    }
}
