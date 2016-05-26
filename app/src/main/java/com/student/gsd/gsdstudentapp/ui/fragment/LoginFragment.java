package com.student.gsd.gsdstudentapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.base.BaseFragment;
import com.student.gsd.gsdstudentapp.presenter.LoginPresenter;
import com.student.gsd.gsdstudentapp.ui.activities.LoginActivity;
import com.student.gsd.gsdstudentapp.ui.activities.MainActivity_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by dreamfire on 22.05.16.
 */
@EFragment(R.layout.fragment_login)
public class LoginFragment extends Fragment implements ILoginView {
    private LoginActivity mActivity;
    private LoginPresenter mPresenter;

    @ViewById(R.id.etUserName)
    protected EditText mUserName;
    @ViewById(R.id.etPassword)
    protected EditText mPassword;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (LoginActivity)context;
    }

    @AfterViews
    protected void afterViews(){
        mActivity.getAbController().initLoginToolbar();
        mPresenter = new LoginPresenter(this);
    }

    @Click(R.id.tvForgot)
    void forgot(){
        FragmentForgot fragment = FragmentForgot_.builder().build();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment).commit();
    }

    @Click(R.id.btnLogin)
    void login(){
        mPresenter.login();
    }

    public String getUserName(){
        return mUserName.getText().toString();
    }

    public String getPass(){
        return mPassword.getText().toString();
    }

    @Override
    public void onComplite(String next) {
//        if(next.equals("showprofilecomplete")) {
            CompliteProfileFragment fragment = CompliteProfileFragment_.builder().build();
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment).commit();
//        }
//        MainActivity_.intent(getActivity()).start();
//        getActivity().finish();
    }

    @Override
    public void onError() {
        Toast.makeText(getActivity(), "Try again", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mPresenter != null){
            mPresenter.onStop();
        }
    }
}
