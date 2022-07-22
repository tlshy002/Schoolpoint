package com.cookandroid.schoolpoint;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

     @SerializedName("user_id")
    public String userid;

     public String getUserid(){
         return userid;
     }

     public void setUserid(String userid){
         this.userid = userid;
     }

     @SerializedName("password")
    public String password;

     public String getPassword(){
         return password;
     }
     public void setPassword(String password) {
         this.password= password;
     }

     @SerializedName("nickname")
     public String nickname;

     public String getNickname(){
         return nickname;
     }

     public void setNickname(String nickname) {
         this.nickname = nickname;
     }

     @SerializedName("email")
     public String email;

     public String getemail(){
         return email;
     }
     public void setemail (String email){
         this.email = email;
     }

     public RegisterRequest(String userid, String password, String nickname, String email){
         this.userid = userid;
         this.password = password;
         this.nickname = nickname;
         this.email = email;
     }
}
