package com.cookandroid.getsum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtxt;
    Button sumbtn;
    TextView txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt = findViewById(R.id.edtxt);
        sumbtn = findViewById(R.id.sumbtn);
        txtv = findViewById(R.id.txtv);

        sumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                int n = Integer.parseInt(edtxt.getText().toString());
                for(int i = 1; i<=n; i++){
                    sum += i;
                }
                txtv.setText("결과 : 1~"+n+" 까지의 합 = "+ sum);
                edtxt.setText("");
            }
        });
    }
}