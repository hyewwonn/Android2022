package com.cookandroid.and0727_03_gridtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton seafood, tomato, carbonara;
    Button btn;
    RadioGroup rg;
    ImageView imgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seafood = findViewById(R.id.seafood);
        tomato = findViewById(R.id.tomato);
        carbonara = findViewById(R.id.carbonara);
        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.rg);
        imgv = findViewById(R.id.imgv);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.seafood: imgv.setImageResource(R.drawable.cat); break;
                    case R.id.tomato: imgv.setImageResource(R.drawable.dog); break;
                    case R.id.carbonara: imgv.setImageResource(R.drawable.rabbit); break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(seafood.isChecked() == true) Toast.makeText(getApplicationContext(), "9,500", Toast.LENGTH_SHORT).show();
                else if(tomato.isChecked() == true) Toast.makeText(getApplicationContext(), "9,000", Toast.LENGTH_SHORT).show();
                else if(carbonara.isChecked() == true) Toast.makeText(getApplicationContext(), "9,500", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getApplicationContext(), "선택해주세요", Toast.LENGTH_SHORT).show();
            }
        });
    }
}