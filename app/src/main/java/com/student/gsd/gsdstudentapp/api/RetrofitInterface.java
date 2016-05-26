package com.student.gsd.gsdstudentapp.api;

import com.student.gsd.gsdstudentapp.model.LoginInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by dreamfire on 23.05.16.
 */
public interface RetrofitInterface {

    //Login
    @FormUrlEncoded
    @POST("api/call/logincheck")
    Observable<LoginInfo> login(@Field("email") String email,
                           @Field("password") String pass);

    //Profile complite
//    @FormUrlEncoded
//    @POST("api/call/profilecompletecheck")


}
