package com.cookandroid.schoolpoint;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class singUP2 extends AppCompatActivity {

    private RetrofitClient retrofitClient;
    private RegisterAPI registerAPI;

    private RadioGroup radioGroup;
    private RadioButton radio_stu, radio_te;
    private EditText user_email, user_id, user_pw, userpwreturn, answer1, answer2, usernickname;
    public Button next2, phoneyes;
    private Spinner spinner1, spinner2;
    private ImageView imageView1, imageView2, imagefull;
    private CheckBox allcheck, fcheck, scheck;
    private Button tv_dita1, tv_dita2;

    private TextView textView, textView2;

    public final int putEdit =0;


    String[] items = {"학창시절 나의 별명은?", "다시 태어나면 되고싶은것은?", "나의 최애 드라마는?", "가장 좋아하는 음식은?", "가장 존경하는 사람은?"};
    String[] itemse = {"학창시절 나의 별명은?", "다시 태어나면 되고싶은것은?", "나의 최애 드라마는?", "가장 좋아하는 음식은?", "가장 존경하는 사람은?"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up2);

        radioGroup = findViewById(R.id.radio_group);
        radio_stu = findViewById(R.id.radio_stu);
        radio_te = findViewById(R.id.radio_te);

        user_email = findViewById(R.id.edt_email);
        user_id = findViewById(R.id.edt_userid);
        user_pw = findViewById(R.id.edt_userpw);
        userpwreturn = findViewById(R.id.edt_userpwreturn);
        usernickname = findViewById(R.id.edt_usernickname);
        phoneyes = findViewById(R.id.btn_certification);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);

        next2 = findViewById(R.id.btn_yse);

        textView = findViewById(R.id.tv_sp);
        textView2 = findViewById(R.id.tv_sp1);

        tv_dita1 = findViewById(R.id.tv_details1);
        tv_dita2 = findViewById(R.id.tv_details2);


        spinner1 = findViewById(R.id.sp_seq1);
        spinner2 = findViewById(R.id.sp_seq2);

        imageView1 = findViewById(R.id.img_v);
        imageView1 = findViewById(R.id.img_v1);
        imagefull = findViewById(R.id.imgfull);

        allcheck = findViewById(R.id.all_chek);
        fcheck = findViewById(R.id.f_chek);
        scheck = findViewById(R.id.s_chek);






        //스피너
        //스피너 기능을 활성하 하려면 어뎁터가 필요
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //드롭다운을 통해 스피너를 화면에 출력
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //스피너 안에다 어뎁터 연결
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("");
            }
        });



        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemse);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView2.setText(itemse[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView2.setText("");
            }
        });

        //전체동의
       allcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if(allcheck.isChecked() == true) {
                  fcheck.setChecked(true);
                  scheck.setChecked(true);
              }else {
                  fcheck.setChecked(false);
                  scheck.setChecked(false);
              }
           }
       });

      tv_dita1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(singUP2.this, Agreement.class);
              startActivity(intent);
          }
      });

        tv_dita2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(singUP2.this, Agreement.class);
                startActivity(intent);
            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userid = user_id.getText().toString();
                String userpw = user_pw.getText().toString();
//               String userreturn = userpwreturn.getText().toString();
               String nickname = usernickname.getText().toString();
                String username = user_email.getText().toString();

               if(username.isEmpty() || userid.isEmpty() || userpw.isEmpty() || nickname.isEmpty()){
                   AlertDialog.Builder builder = new AlertDialog.Builder(singUP2.this);
                   builder.setTitle("알림").setMessage("정보란확인바람!").setPositiveButton("확인", null).create().show();
                   AlertDialog alertDialog = builder.create();
                   alertDialog.show();
               }else{
                   RegisterResponce();
//                   Intent intent = new Intent(singUP2.this, Roginsucesse.class);
//                   intent.putExtra("id", userid);
//                   intent.putExtra("pw", userpw);
//                   startActivity(intent);
               }
            }
        });
    }


     public void RegisterResponce(){



         String userid = user_id.getText().toString();
         String userpw = user_pw.getText().toString();
//         String userreturn = userpwreturn.getText().toString();
         String nickname = usernickname.getText().toString();
         String useremail = user_email.getText().toString();

         RegisterRequest registerRequest = new RegisterRequest(userid, userpw, nickname, useremail);

         //레트로핏 연동
         retrofitClient = RetrofitClient.getInstance();
         registerAPI = RetrofitClient.getRetrofitInterface();

         //레지스터리퀘스트에 저장된 데이터와 함께 레지스터메이아이피에서 정의한 갯 레지스터리스폰스
         registerAPI.getRegisterResponce(registerRequest).enqueue(new Callback<RegisterResponce>() {
             @Override
             public void onResponse(Call<RegisterResponce> call, Response<RegisterResponce> response) {
                 Log.d("레트로핏", "성공?");
                 Log.d("성공??", String.valueOf(response));

                 if(response.isSuccessful() && response.body() != null) {
                     RegisterResponce result = response.body();
                     if(result.getSuc() == true) {
                         Toast.makeText(getApplicationContext(), "회원가입성공", Toast.LENGTH_LONG).show();
                         Intent intent = new Intent(singUP2.this, Roginsucesse.class);
                         intent.putExtra("id", userid);
                         intent.putExtra("pw", userpw);
                         startActivity(intent);
                     }else{
                         Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_LONG).show();
                     }
                 }
             }

             @Override
             public void onFailure(Call<RegisterResponce> call, Throwable t) {
                   Toast.makeText(getApplicationContext(),"통신실패", Toast.LENGTH_LONG).show();
             }
         });

     }

}