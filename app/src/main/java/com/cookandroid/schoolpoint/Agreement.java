package com.cookandroid.schoolpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Agreement extends AppCompatActivity {

    private ImageView img_agree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);


        img_agree = findViewById(R.id.img_agree);

        Button btn_close = findViewById(R.id.btn_close);


          btn_close.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(Agreement.this, singUP2.class);
                  startActivity(intent);
              }
          });

    }
}