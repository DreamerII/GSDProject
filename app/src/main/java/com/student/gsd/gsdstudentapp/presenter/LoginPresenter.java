package com.student.gsd.gsdstudentapp.presenter;

import android.util.Log;
import android.view.View;

import com.student.gsd.gsdstudentapp.model.ILogin;
import com.student.gsd.gsdstudentapp.model.LoginImpl;
import com.student.gsd.gsdstudentapp.model.LoginInfo;
import com.student.gsd.gsdstudentapp.ui.fragment.LoginFragment;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by dreamfire on 23.05.16.
 */
public class LoginPresenter implements ILoginPresenter {
    private ILogin iLogin = new LoginImpl();
    private LoginFragment view;
    private Subscription subscription = Subscriptions.empty();

    public LoginPresenter(LoginFragment view){
        this.view = view;
    }


    @Override
    public void login() {
        if(!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }

        subscription = iLogin.getLoginInfo(view.getUserName(), view.getPass())
                .subscribe(new Observer<LoginInfo>() {
                    @Override
                    public void onCompleted() {
                        Log.d("DENYSYUK", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("DENYSYUK", "onError");
                    }

                    @Override
                    public void onNext(LoginInfo loginInfo) {
                        Log.d("DENYSYUK", "onNext");
                        if(loginInfo != null)
                        view.onComplite(loginInfo.getNextstep());
                    }
                });
    }

    @Override
    public void onStop() {
        if(!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }
}
