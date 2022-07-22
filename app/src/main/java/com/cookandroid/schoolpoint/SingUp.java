package com.cookandroid.schoolpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SingUp extends AppCompatActivity {

    String[] items = {"시/도","서울특별시", "인천광역시", "부산광역시", "광주광역시", "경기도"};
    String[] itemse = {"구","관악구", "동작구", "서대문구", "용산구", "구로구"};
    String[] itemss = {"명지전문대", "명지대", "인화여대"};

      Spinner spinner, spinner1, spinner2;
      TextView textView1, textView2, textView3;
      Button btnnext;
      ImageView img1, img2, img3;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        textView1 = findViewById(R.id.tv_sp);
          textView2 = findViewById(R.id.tv_sp1);
          textView3 = findViewById(R.id.tv_sp2);

          btnnext = findViewById(R.id.btn2);

          img1 = findViewById(R.id.img_v);
          img2 = findViewById(R.id.img_v1);
          img3 = findViewById(R.id.img_v2);


       btnnext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(SingUp.this, singUP2.class);
               startActivity(intent);
           }
       });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView1.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                 textView1.setText("");
            }
        });


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemse);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView2.setText(itemse[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView2.setText("");
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(SingUp.this, android.R.layout.simple_spinner_item, itemss);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView3.setText(itemss[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               textView3.setText("");
            }
        });



    }
}