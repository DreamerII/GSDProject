package com.student.gsd.gsdstudentapp.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.base.BaseActivity;
import com.student.gsd.gsdstudentapp.managers.ActionBarController;
import com.student.gsd.gsdstudentapp.ui.fragment.WelcomeFragment;
import com.student.gsd.gsdstudentapp.ui.fragment.WelcomeFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by dreamfire on 21.05.16.
 */
@EActivity(R.layout.activity_base)
public class LoginActivity extends AppCompatActivity {
    private ActionBarController mAbController;

    @AfterViews
    protected void afterViews(){
        initActionBar();

        Fragment fragment1 = getSupportFragmentManager().findFragmentById(R.id.container);
        if(fragment1 != null){
            fragment1.onResume();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new WelcomeFragment_())
                    .commit();
        }
    }

    private void initActionBar() {
        mAbController = new ActionBarController();
        mAbController.register(this);
    }

    public ActionBarController getAbController(){
        return mAbController;
    }
//
    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 0) {
            if (getSupportFragmentManager().findFragmentById(R.id.container) instanceof WelcomeFragment_) {
                super.onBackPressed();
            } else {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new WelcomeFragment_()).commit();
            }
        } else {
            super.onBackPressed();
        }
    }
}
