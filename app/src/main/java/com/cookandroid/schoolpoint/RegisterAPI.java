package com.cookandroid.schoolpoint;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterAPI {

    @POST("user/signUp")
    Call<RegisterResponce> getRegisterResponce(@Body RegisterRequest registerRequest);

}
