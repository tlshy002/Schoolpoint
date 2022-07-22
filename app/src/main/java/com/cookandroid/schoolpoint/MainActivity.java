package com.cookandroid.schoolpoint;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RetrofitClient retrofitClient;
    LoginAPI loginAPI;

    ImageView baselogin, baserogo;
    Button btn_rogin;
    TextView tv_id, tv_pw, tv_request;
    EditText edt_id, edt_pw;

    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        baselogin = findViewById(R.id.base_login);
        baserogo = findViewById(R.id.base_rogo);

        tv_id = findViewById(R.id.tv_id);
        tv_pw = findViewById(R.id.tv_pw);
        tv_request = findViewById(R.id.rv_request);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);

        btn_rogin = findViewById(R.id.btn_longin);


        edt_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    btn_rogin.setClickable(true);

                    btn_rogin.setBackground(getDrawable(R.drawable.btnlogin));
                } else if(s.length() == 0 ) {

                    btn_rogin.setBackground(getDrawable(R.drawable.btnloginnull));
                }
            }
        });


        tv_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SingUp.class);
                startActivity(intent);
            }
        });

        btn_rogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = edt_id.getText().toString();
                String pw = edt_pw.getText().toString();

                if (id.trim().length() == 0 || pw.trim().length() == 0 || id == null || pw == null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("알림!").setMessage("아이디와 비밀번호를 입력하세요").setPositiveButton("닫기", null).create().show();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                     RoginResponce();
                }

            }
        });

    }

    public void RoginResponce(){

           String userid = edt_id.getText().toString();
           String userpw = edt_pw.getText().toString();

        LoginRequest loginRequest = new LoginRequest(userid, userpw);

           //레트로핏 연결

        retrofitClient = RetrofitClient.getInstance();
        loginAPI = RetrofitClient.getlRetrofitInterface();

      loginAPI.getLoginResponce(loginRequest).enqueue(new Callback<LoginResponce>() {
          @Override
          public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
              Log.d("성공ㅇ??", String.valueOf(response));

              if(response.isSuccessful() && response.body() != null) {
                  LoginResponce result = response.body();
                  if(result.getSuc() == true) {
                      Toast.makeText(getApplicationContext(), "로그인성공", Toast.LENGTH_SHORT).show();
                  } else {
                      Toast.makeText(getApplicationContext(), "로그인실패", Toast.LENGTH_SHORT).show();
                  }
              }

          }

          @Override
          public void onFailure(Call<LoginResponce> call, Throwable t) {

              AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
              builder.setTitle("알림").setMessage("통신실패").setPositiveButton("확인", null).create().show();
              AlertDialog alertDialog = builder.create();
              alertDialog.show();

          }
      });




    }

}