package com.cookandroid.schoolpoint;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("user_id")
    public String userid;

    public String getUserid(){
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    @SerializedName("password")
    public String password;

    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }
}
