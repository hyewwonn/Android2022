package com.cookandroid.and0726_06_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox start;
    LinearLayout survey;
    RadioGroup rg;
    RadioButton korean, chinese, snack, night;
    Button btnReset;
    ImageView imgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        survey = findViewById(R.id.survey);
        rg = findViewById(R.id.rg);
        btnReset = findViewById(R.id.btnReset);
        imgv = findViewById(R.id.imgv);
        korean = findViewById(R.id.korean);
        chinese = findViewById(R.id.chinese);
        snack = findViewById(R.id.snack);
        night = findViewById(R.id.night);

        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (start.isChecked() == true) {
                    survey.setVisibility(View.VISIBLE);
                }
                else {
                    survey.setVisibility(View.INVISIBLE);
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.korean: imgv.setImageResource(R.drawable.cat); break;
                    case R.id.chinese: imgv.setImageResource(R.drawable.dog2); break;
                    case R.id.snack: imgv.setImageResource(R.drawable.dog3); break;
                    case R.id.night: imgv.setImageResource(R.drawable.fox2); break;
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                imgv.setImageResource(0);
            }
        });

    }
}