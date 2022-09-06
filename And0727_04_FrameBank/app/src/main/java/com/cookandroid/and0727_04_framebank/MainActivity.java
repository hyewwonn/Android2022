package com.cookandroid.and0727_04_framebank;

import static com.cookandroid.and0727_04_framebank.R.color.gray;
import static com.cookandroid.and0727_04_framebank.R.color.yellow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button balance, deposit, withdraw, btndeposit, btnwithdraw;
    TextView txtbalance;
    EditText edtdeposit, edtwithdraw;
    LinearLayout linbalance, lindeposit, linwithdraw;
    int bal = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        balance = findViewById(R.id.balance);
        deposit = findViewById(R.id.deposit);
        withdraw = findViewById(R.id.withdraw);
        btndeposit = findViewById(R.id.btndeposit);
        btnwithdraw = findViewById(R.id.btnwithdraw);
        txtbalance = findViewById(R.id.txtbalance);
        edtdeposit = findViewById(R.id.edtdeposit);
        edtwithdraw = findViewById(R.id.edtwithdraw);
        linbalance = findViewById(R.id.linbalance);
        lindeposit = findViewById(R.id.lindeposit);
        linwithdraw = findViewById(R.id.linwithdraw);

        balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linbalance.setVisibility(View.VISIBLE);
                lindeposit.setVisibility(View.INVISIBLE);
                linwithdraw.setVisibility(View.INVISIBLE);
                balance.setBackgroundColor(Color.parseColor("#FFF59B"));
                deposit.setBackgroundColor(Color.parseColor("#C8C8C8"));
                withdraw.setBackgroundColor(Color.parseColor("#C8C8C8"));
                txtbalance.setText(""+bal);
            }
        });
        deposit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                linbalance.setVisibility(View.INVISIBLE);
                lindeposit.setVisibility(View.VISIBLE);
                linwithdraw.setVisibility(View.INVISIBLE);
                balance.setBackgroundColor(Color.parseColor("#C8C8C8"));
                deposit.setBackgroundColor(Color.parseColor("#FFF59B"));
                withdraw.setBackgroundColor(Color.parseColor("#C8C8C8"));

            }
        });
        withdraw.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                linbalance.setVisibility(View.INVISIBLE);
                lindeposit.setVisibility(View.INVISIBLE);
                linwithdraw.setVisibility(View.VISIBLE);
                balance.setBackgroundColor(Color.parseColor("#C8C8C8"));
                deposit.setBackgroundColor(Color.parseColor("#C8C8C8"));
                withdraw.setBackgroundColor(Color.parseColor("#FFF59B"));
            }
        });

        btndeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bal += Integer.parseInt(edtdeposit.getText().toString());
                edtdeposit.setText("");
            }
        });
        btnwithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bal >= Integer.parseInt(edtwithdraw.getText().toString())) {
                    bal -= Integer.parseInt(edtwithdraw.getText().toString());
                    edtwithdraw.setText("");
                }
                else {
                    Toast.makeText(getApplicationContext(), "잔액부족", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}