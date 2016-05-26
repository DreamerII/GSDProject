package com.student.gsd.gsdstudentapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.base.BaseFragment;
import com.student.gsd.gsdstudentapp.ui.activities.LoginActivity;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by dreamfire on 22.05.16.
 */
@EFragment(R.layout.fragment_forgot)
public class FragmentForgot extends Fragment implements OnClickListener {
    private LoginActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (LoginActivity)context;
    }

    @AfterViews
    void afterViews(){
        mActivity.getAbController().initForgotToolbar();
        mActivity.getAbController().setClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                mActivity.onBackPressed();
                break;
        }
    }
}
