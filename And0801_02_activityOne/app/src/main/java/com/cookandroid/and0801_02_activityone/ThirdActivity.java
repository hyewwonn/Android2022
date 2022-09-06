package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button btnThird;
    TextView txtContent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btnThird = findViewById(R.id.btnThird);
        txtContent3 = findViewById(R.id.txtContent3);
        Intent in = getIntent();
        String str = in.getStringExtra("Content");
        txtContent3.setText("넘겨 받은 내용 : "+str);

        setTitle("세번째화면");

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}