package com.cookandroid.a0725_05imagechange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnimgcng, btnvsb;
    ImageView img;
    int imgType=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnimgcng = findViewById(R.id.btnimgcng);
        btnvsb = findViewById(R.id.btnvsb);
        img = findViewById(R.id.img);

        btnimgcng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgType==1){
                    img.setImageResource(R.drawable.eclair); imgType=2;
                }
                else{
                    img.setImageResource(R.drawable.honeycomb);imgType=1;
                }
            }
        });
        btnvsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img.getVisibility() == View.VISIBLE){
                    btnvsb.setText("보이기");
                    img.setVisibility(View.INVISIBLE);
                }
                else{
                    btnvsb.setText("숨기기");
                    img.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}