package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    RadioButton rdSecond, rdThird;
    Button btn;
    EditText edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        rdSecond = findViewById(R.id.rdSecond);
        rdThird = findViewById(R.id.rdThird);
        edtContent = findViewById(R.id.edtContent);

        setTitle("첫번째화면");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtContent.getText().toString();
                if(rdSecond.isChecked() == true){
                    Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                    in.putExtra("Content", str); //변수이름, 값->보내기
                    startActivity(in); //SecondActivity 화면에 열기 => 클릭했을 때 화면 넘어가는 코드!
                }
                else if(rdThird.isChecked() == true){
                    Intent in = new Intent(getApplicationContext(), ThirdActivity.class);
                    in.putExtra("content", str); //변수이름, 값->보내기
                    startActivity(in); //SecondActivity 화면에 열기 => 클릭했을 때 화면 넘어가는 코드!
                }
                else {
                    Toast.makeText(getApplicationContext(), "선택안됨", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}