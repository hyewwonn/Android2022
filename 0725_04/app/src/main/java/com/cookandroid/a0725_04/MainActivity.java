package com.cookandroid.a0725_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    Button btnEven, point;
    TextView txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btnEven = findViewById(R.id.btnEven);
        point = findViewById(R.id.point);
        txtv = findViewById(R.id.txtv);

        btnEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt1.getText().toString());
                int n2 = Integer.parseInt(edt2.getText().toString());
                int sum = 0;
                for(int i = n1; i<=n2; i++){
                    if(i % 2 ==0) {
                        sum += i;
                    }
                }
                txtv.setText("결과 값 출력 : "+sum);
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt1.getText().toString());
                int n2 = Integer.parseInt(edt2.getText().toString());
                int p = (n2 / n1)*n1;
                txtv.setText("결과 값 출력 : "+p);
            }
        });

    }
}