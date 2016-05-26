package com.student.gsd.gsdstudentapp.ui.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.student.gsd.gsdstudentapp.R;
import com.student.gsd.gsdstudentapp.base.BaseFragment;
import com.student.gsd.gsdstudentapp.model.Profile;
import com.student.gsd.gsdstudentapp.ui.activities.LoginActivity;
import com.student.gsd.gsdstudentapp.ui.activities.MainActivity_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Calendar;
import java.util.TimeZone;

import io.realm.Realm;

/**
 * Created by dreamfire on 24.05.16.
 */
@EFragment(R.layout.fragment_complite_profile)
public class CompliteProfileFragment extends Fragment {
    private LoginActivity mActivity;
    private Profile mProfile;
    private Realm realm;

    @ViewById(R.id.tvDatePicker)
    protected TextView mTvDate;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (LoginActivity)context;
    }

    @AfterInject
    protected void afterInject(){
        realm = Realm.getInstance(getActivity());
        realm.beginTransaction();
        mProfile = realm.createObject(Profile.class);
    }

    @AfterViews
    protected void afterViews(){
        mActivity.getAbController().initComProfToolbar();
    }

    @Click(R.id.tvDatePicker)
    void datePick(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        DatePickerDialog datePicker = new DatePickerDialog(getActivity(),
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePicker.setCancelable(true);
        datePicker.setTitle("Select the date");
        datePicker.show();
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mProfile.setbDay(dayOfMonth);
            mProfile.setbMonth(monthOfYear);
            mProfile.setbYear(year);
            mTvDate.setText(mProfile.getbDay()+"/"+mProfile.getbMonth()+"/"+mProfile.getbYear());

        }
    };

    @Click(R.id.tvBack_FCP)
    void backClick(){
        mActivity.onBackPressed();
    }

    @Click(R.id.tvNext_FCP)
    void nextClick(){
        mProfile.setUserID(1);
        mProfile.setCity("Kiev");
        mProfile.setGender(1);
        mProfile.setInstitutid("KPI");
        realm.commitTransaction();
        MainActivity_.intent(getActivity()).start();
        getActivity().finish();
    }
}
