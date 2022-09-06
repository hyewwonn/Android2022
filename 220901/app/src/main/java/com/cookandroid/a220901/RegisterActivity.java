package com.cookandroid.a220901;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText edt_id, edt_pass, edt_name, edt_age;
    Button btn_register;
    SQLiteDatabase sqlDB;
    MyDBHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edt_id = findViewById(R.id.edt_id);
        edt_pass = findViewById(R.id.edt_pass);
        edt_name = findViewById(R.id.edt_name);
        edt_age = findViewById(R.id.edt_age);
        btn_register = findViewById(R.id.btn_register);
        myHelper = new MyDBHelper(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = edt_id.getText().toString().trim();
                String userPass = edt_pass.getText().toString().trim();
                String userName = edt_name.getText().toString().trim();
                int userAge = Integer.parseInt(edt_age.getText().toString().trim());
                try{
                    if(!userID.isEmpty()&&!userPass.isEmpty()){
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.exeSQL("INSERT INTO user(userID, userPass, userName, userAge)"+"VALUES ('"+userID + "',"+'"'
                    }
                }
            }
        });
    }
}