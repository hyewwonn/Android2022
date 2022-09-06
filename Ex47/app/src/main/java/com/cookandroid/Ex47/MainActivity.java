package com.cookandroid.Ex47;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    CheckBox chkEn;
    CheckBox chkVi;
    CheckBox chkRt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("양혜원");
        chkEn = findViewById(R.id.chkEn);
        chkVi = findViewById(R.id.chkVi);
        chkRt = findViewById(R.id.chkRt);
        btn = findViewById(R.id.btn);
        chkVi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkVi.isChecked()){//true
                    btn.setVisibility(View.VISIBLE);
                }
                else{
                    btn.setVisibility(View.INVISIBLE);
                }
            }
        });
        chkEn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkEn.isChecked()){//true
                    btn.setEnabled(true);
                }
                else{
                    btn.setEnabled(false);
                }
            }
        });
        chkRt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkRt.isChecked()){//true
                    btn.setRotation(45);
                }
                else{
                    btn.setRotation(0);
                }
            }
        });
    }
}
