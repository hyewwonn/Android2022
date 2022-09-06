package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    Button btn;
    TextView txtName, txtAge, txtHobby;
    Person p;
    String name, age, hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn = findViewById(R.id.btn);
        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        txtHobby = findViewById(R.id.txtHobby);

        Intent in = getIntent();

        String name = in.getStringExtra("Name"); //받음
        txtName.setText("이름 : "+name);
        int age = in.getIntExtra("Age", 0); //받음
        txtAge.setText("나이 : "+age);
        String hobby = in.getStringExtra("Hobby"); //받음
        txtHobby.setText("취미 : "+hobby);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}