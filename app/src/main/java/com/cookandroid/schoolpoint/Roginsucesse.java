package com.cookandroid.schoolpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Roginsucesse extends AppCompatActivity {

    private TextView getid, getpw;

    private Button btn_rogingo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roginsucesse);

        getid = findViewById(R.id.get_tv_id);
        getpw = findViewById(R.id.get_tv_pw);

        btn_rogingo = findViewById(R.id.btn_rogingo);



        Intent i = getIntent();
        String data = i.getStringExtra("id");
        String data1 = i.getStringExtra("pw");
        getid.setText(data);
        getpw.setText(data1);


        Log.v("test1", data);
        Log.v("test2", data1);













        btn_rogingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Roginsucesse.this, MainActivity.class);
                startActivity(intent1);
            }
        });


    }
}