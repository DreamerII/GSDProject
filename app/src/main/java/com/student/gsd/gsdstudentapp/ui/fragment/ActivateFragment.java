package com.student.gsd.gsdstudentapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.base.BaseFragment;
import com.student.gsd.gsdstudentapp.ui.activities.LoginActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by dreamfire on 22.05.16.
 */
@EFragment(R.layout.fragment_activate)
public class ActivateFragment extends Fragment implements View.OnClickListener {
    private LoginActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (LoginActivity) context;
    }

    @AfterViews
    void afterViews(){
        mActivity.getAbController().hideSkip(false);
        mActivity.getAbController().setTitle("ACTIVATE CARD");
        mActivity.getAbController().menuVisible(false);
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
