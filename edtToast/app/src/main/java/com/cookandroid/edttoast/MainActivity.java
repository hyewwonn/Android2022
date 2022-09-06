package com.cookandroid.edttoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt = findViewById(R.id.edtxt);

        edtxt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_UP){
                    Toast.makeText(getApplicationContext(), edtxt.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                if(keyEvent.getKeyCode() == keyEvent.KEYCODE_ENTER){
                    int n = Integer.parseInt(edtxt.getText().toString());
                    int sum = 0;
                    for (int j = 1; j<=n; j++) sum += j;
                    String str = "결과 : 1~"+n+"까지 합 = "+sum;
                    Toast.makeText(getApplicationContext(), sum, Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
    }
}