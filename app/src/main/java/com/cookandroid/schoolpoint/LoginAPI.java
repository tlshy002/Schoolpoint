package com.cookandroid.schoolpoint;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginAPI {

    @POST("user/login")
    Call<LoginResponce> getLoginResponce(@Body LoginRequest loginRequest);
}
