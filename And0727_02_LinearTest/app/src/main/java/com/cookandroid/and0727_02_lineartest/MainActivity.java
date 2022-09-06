package com.cookandroid.and0727_02_lineartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edtX, edtY;
    Spinner op;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        op = findViewById(R.id.op);
        txtResult = findViewById(R.id.txtResult);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                int i = op.getSelectedItemPosition();
                switch (i){
                    case 0: txtResult.setText("결과 : "+(x+y)); break;
                    case 1: txtResult.setText("결과 : "+(x-y)); break;
                    case 2: txtResult.setText("결과 : "+(x*y)); break;
                    case 3: txtResult.setText("결과 : "+(x%y)); break;
                }
                op.setSelection(0);
            }
        });
    }
}