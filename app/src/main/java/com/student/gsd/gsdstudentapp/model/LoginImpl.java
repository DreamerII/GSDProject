package com.student.gsd.gsdstudentapp.model;

import com.student.gsd.gsdstudentapp.api.RetrofitAdapter;
import com.student.gsd.gsdstudentapp.api.RetrofitInterface;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dreamfire on 23.05.16.
 */
public class LoginImpl implements ILogin {

    RetrofitInterface mApiInterface = RetrofitAdapter.getInterface();

    @Override
    public Observable<LoginInfo> getLoginInfo(String email, String password) {
        return mApiInterface.login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
