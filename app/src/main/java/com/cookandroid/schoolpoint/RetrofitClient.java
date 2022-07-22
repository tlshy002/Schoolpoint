package com.cookandroid.schoolpoint;

import android.os.Build;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private static RegisterAPI registerAPI;
    private static LoginAPI loginAPI;
    private static String baseUrl = "http://220.72.220.20:3026";



    //레트로핏 설정
    private RetrofitClient(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        registerAPI = retrofit.create(RegisterAPI.class);
        loginAPI = retrofit.create(LoginAPI.class);

    }

    public static RetrofitClient getInstance() {
        if(instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static RegisterAPI getRetrofitInterface(){
        return registerAPI;
    }

    public static LoginAPI getlRetrofitInterface(){
        return loginAPI;
    }






}
