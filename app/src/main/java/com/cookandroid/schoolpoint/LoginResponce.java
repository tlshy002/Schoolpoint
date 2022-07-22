package com.cookandroid.schoolpoint;

import com.google.gson.annotations.SerializedName;

public class LoginResponce {

    @SerializedName("suc")
    public Boolean suc;

    public Boolean getSuc(){
        return suc;
    }
    public void setSuc(Boolean suc) {
        this.suc = suc;
    }
}
