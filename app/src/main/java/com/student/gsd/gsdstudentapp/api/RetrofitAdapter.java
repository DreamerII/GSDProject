package com.student.gsd.gsdstudentapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.student.gsd.gsdstudentapp.utility.ItemTypeAdapterFactory;

import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dreamfire on 23.05.16.
 */
public abstract class RetrofitAdapter {
    private static RetrofitInterface retrofitInterface;
    private static Retrofit retrofit;

    public static RetrofitInterface getInterface() {
        if (retrofitInterface == null) {

            Gson gson = new GsonBuilder()
                    .registerTypeAdapterFactory(new ItemTypeAdapterFactory()) // This is the important line ;)

                    .create();

            final OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.DAYS.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS ).build();


            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstant.BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();

            retrofitInterface = retrofit.create(RetrofitInterface.class);
        }
        return retrofitInterface;
    }
}
