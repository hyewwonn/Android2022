package com.cookandroid.project_0614;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rdbtn2, rdbtn3;
    RadioGroup rdgroup;
    Button btnok, btncancel, btn;
    CheckBox chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdbtn2 = findViewById(R.id.rdbtn2);
        rdbtn3 = findViewById(R.id.rdbtn3);
        btnok = findViewById(R.id.btnok);
        btncancel = findViewById(R.id.btncancel);
        rdgroup = findViewById(R.id.rdgroup);
        chk = findViewById(R.id.chk);
        btn = findViewById(R.id.btn);


        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rdgroup.getCheckedRadioButtonId()){
                    case R.id.rdbtn2:
                        Toast.makeText(getApplicationContext(), "2학년", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdbtn3:
                        Toast.makeText(getApplicationContext(), "3학년", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdgroup.clearCheck();
                Toast.makeText(getApplicationContext(),"취소", Toast.LENGTH_SHORT).show();
            }
        });

        chk.setChecked(true);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)btn.setEnabled(true);
                else btn.setEnabled(false);
            }
        });
    }
}