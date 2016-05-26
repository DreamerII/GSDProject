package com.student.gsd.gsdstudentapp.ui.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.adapters.AddCashRVAdapter;
import com.student.gsd.gsdstudentapp.ui.activities.LoginActivity;
import com.student.gsd.gsdstudentapp.ui.activities.MainActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by dreamfire on 25.05.16.
 */
@EFragment(R.layout.fragment_my_wallet)
public class MyGSDWallet extends Fragment implements View.OnClickListener {
    private MainActivity mActivity;
    private AddCashRVAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
    }

    @AfterViews
    protected void afterViews(){
        mActivity.getAbController().setClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }
}
