package com.cookandroid.and0801_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtTel, edtAdd;
    Button btn;
    RadioGroup rg;
    //RadioButton rbMan, rbWoman; RadioGroup으로 checked할 거면 이거 주석 처리!
    String name, gender, tel, add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 화면");
        edtName = findViewById(R.id.edtName);
        edtTel = findViewById(R.id.edtTel);
        edtAdd = findViewById(R.id.edtAdd);
        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.rg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                tel = edtTel.getText().toString();
                add = edtAdd.getText().toString();
                if(rg.getCheckedRadioButtonId() == R.id.rbMan){
                    gender = "남자";
                }else{
                    gender = "여자";
                }
                Person p = new Person(name, gender, tel, add);
                Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                in.putExtra("person", p); //객체로 데이터 전송
                startActivity(in);
            }
        });
    }
}