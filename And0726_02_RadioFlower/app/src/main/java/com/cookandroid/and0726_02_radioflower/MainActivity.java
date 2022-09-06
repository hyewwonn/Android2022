package com.cookandroid.and0726_02_radioflower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rose, pansy, lily;
    RadioGroup flower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rose = findViewById(R.id.rose);
        pansy = findViewById(R.id.pansy);
        lily = findViewById(R.id.lily);
        flower = findViewById(R.id.flower);

        flower.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rose: Toast.makeText(getApplicationContext(), "장미", Toast.LENGTH_SHORT).show(); break;
                    case R.id.pansy: Toast.makeText(getApplicationContext(), "팬지", Toast.LENGTH_SHORT).show(); break;
                    case R.id.lily: Toast.makeText(getApplicationContext(), "백합", Toast.LENGTH_SHORT).show(); break;
                }
            }
        });
    }
}