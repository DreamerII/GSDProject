package com.student.gsd.gsdstudentapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.base.BaseFragment;
import com.student.gsd.gsdstudentapp.ui.activities.LoginActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

/**
 * Created by dreamfire on 21.05.16.
 */
@EFragment(R.layout.fragment_welcome)
public class WelcomeFragment extends Fragment {
    private LoginActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (LoginActivity)context;
    }

    @AfterViews
    protected void afterViews(){
        mActivity.getAbController().hideSkip(true);
        mActivity.getAbController().setTitle("WELCOME");
        mActivity.getAbController().menuVisible(true);
    }

    @Click(R.id.tvActivate)
    void mTvActivate(){

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new ActivateFragment_()).commit();
    }

    @Click(R.id.rlRegister)
    void register(){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new FragmentRegistered_()).commit();
    }

    @Click(R.id.rlLogin)
    void login(){
        LoginFragment fragment = LoginFragment_.builder().build();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment).commit();
    }

}
