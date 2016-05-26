package com.student.gsd.gsdstudentapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.gsd.gsdstudentapp.managers.FragmentNavigator;

import org.androidannotations.annotations.EFragment;

/**
 * Created by dreamfire on 21.05.16.
 */
public class BaseFragment extends Fragment {


    //____________________ Protected variables ___________________//
    protected BaseActivity  mActivity;
    protected View inflatedView;
    protected FragmentNavigator mFragmentNavigator;


    //_____________________ Private variables ____________________//
    private int             fragmentResId = -1;

    /**
     * The method sets resources into fragment.
     * @param resId - resource for inflating view in fragment
     */
    protected void setContentView(int resId){
        this.fragmentResId = resId;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
        mFragmentNavigator = mActivity.getFragmentNavigator();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (fragmentResId != -1) {
            inflatedView = inflater.inflate(fragmentResId, container, false);
            return inflatedView;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * The method finding view in parent view
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T $(int resId){
        if (inflatedView == null)
            return null;
        return (T) inflatedView.findViewById(resId);
    }

}
