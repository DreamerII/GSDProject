package com.student.gsd.gsdstudentapp.model;

import rx.Observable;

/**
 * Created by dreamfire on 23.05.16.
 */
public interface ILogin {
    Observable<LoginInfo> getLoginInfo(String email, String password);
}
