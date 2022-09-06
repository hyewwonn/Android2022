package com.cookandroid.project0616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtX, edtY;
    TextView result;
    Button btnPlus, btnMinus, btnMulti;


    Button[] btnNums = new Button[10];
    Integer[] ids = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
    R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0; i<btnNums.length; i++){
            btnNums[i] = findViewById(ids[i]);

            final int index = i;
            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edtX.isFocused()){
                        String s = edtX.getText().toString()+index;
                        edtX.setText(s);
                    }
                    else if(edtY.isFocused()){
                        String s = edtY.getText().toString()+index;
                        edtY.setText(s);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),
                                "에디터부터 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        result = findViewById(R.id.result);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);





        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                result.setText("계산 결과 : " + (x+y));
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                result.setText("계산 결과 : " + (x-y));
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                result.setText("계산 결과 : " + (x*y));
            }
        });
    }//onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}