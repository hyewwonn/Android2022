package com.cookandroid.and0802_01_act_twoway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btnReturn;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnReturn = findViewById(R.id.btnReturn);
        Intent in = getIntent();
        int x = in.getIntExtra("Num1", 0);
        int y = in.getIntExtra("Num2", 0);

        String op = in.getStringExtra("op");
        switch (op){
            case "+": sum = x+y; break;
            case "-": sum = x-y; break;
            case "*": sum = x*y; break;
            case "/": sum = x/y; break;
        }

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), MainActivity.class);
                out.putExtra("sum", sum);
                setResult(RESULT_OK, out); //되돌려줌
                finish();
            }
        });
    }
}