package com.cookandroid.and0726_02_radioidol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton changsub, eunkwang, sungjae;
    RadioGroup idol;
    Button vote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changsub = findViewById(R.id.changsub);
        eunkwang = findViewById(R.id.eunkwang);
        sungjae = findViewById(R.id.sungjae);
        vote = findViewById(R.id.vote);
        idol = findViewById(R.id.idol);

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (idol.getCheckedRadioButtonId()){
                    case R.id.changsub: Toast.makeText(getApplicationContext(), "창섭", Toast.LENGTH_SHORT).show(); break;
                    case R.id.eunkwang: Toast.makeText(getApplicationContext(), "은광", Toast.LENGTH_SHORT).show(); break;
                    case R.id.sungjae: Toast.makeText(getApplicationContext(), "성재", Toast.LENGTH_SHORT).show(); break;
                }
            }
        });
    }
}