package com.cookandroid.a220901;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt_id, edt_pass;
    private Button btn_login, btn_register;
    SQLiteDatabase sqlDB;
    MyDBHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_id = findViewById(R.id.edt_id);
        edt_pass = findViewById(R.id.edt_pass);
        btn_login= findViewById(R.id.btn_login);
        btn_register= findViewById(R.id.btn_register);
        myHelper = new MyDBHelper(this);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = edt_id.getText().toString().trim();
                String userPass = edt_pass.getText().toString().trim();
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT userID, userPass FROM user where userID='"+userID+"' " +
                        "and userPass='"+userPass+"';", null);
                if(cursor.moveToFirst()){
                    Intent in = new Intent(MainActivity.this, LoginOkActivity.class);
                    in.putExtra("userID", userID);
                    in.putExtra("userPass", userPass );
                    startActivity(in);
                }
                else{//비밀번호나 id가 틀림, 로그인 실패(회원가입안되거나)
                    Toast.makeText(getApplicationContext(), "로그인 실패(id, pw확인)",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}