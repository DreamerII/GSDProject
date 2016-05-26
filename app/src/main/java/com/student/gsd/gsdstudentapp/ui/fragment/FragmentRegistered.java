package com.student.gsd.gsdstudentapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.base.BaseFragment;
import com.student.gsd.gsdstudentapp.ui.activities.LoginActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by dreamfire on 22.05.16.
 */
@EFragment(R.layout.registered_fragment)
public class FragmentRegistered extends Fragment {
    private LoginActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (LoginActivity) context;
    }

    @AfterViews
    protected void afterViews(){
        mActivity.getAbController().initRegisteredToolbar();
    }
}
