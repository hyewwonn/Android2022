package com.cookandroid.a220609;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtID, edtPW;
    Button btnLogin;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);
        btnLogin = findViewById(R.id.btnLogin);
        txtResult = findViewById(R.id.txtResult);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtID.getText().toString()+"님 로그인 되었습니다.";
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();

                String str2 = "입력결과 : 아이디("+edtID.getText().toString()+"), 비밀번호("+edtPW.getText().toString()+")";
                txtResult.setText(str2);

                edtID.setText(""); edtPW.setText("");
            }
        });
    }
}