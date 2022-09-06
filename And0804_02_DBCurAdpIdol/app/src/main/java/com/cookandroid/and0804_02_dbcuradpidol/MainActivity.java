package com.cookandroid.and0804_02_dbcuradpidol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    Button btnInsert, btnSelect;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    ListView listView;
    IdolAdapter iAdapter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MPDB1");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        listView = findViewById(R.id.listView);

        myHelper = new MyDBHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String name = edtName.getText().toString().trim();
                    int num = Integer.parseInt(edtNumber.getText().toString().trim());
                    if(name.isEmpty()){
                        Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }else{
                        // "이름"+name+"나이"+num
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.execSQL("insert into groupTBL(gName, gNumber) values('"+name+"', "+num+");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력 성공", Toast.LENGTH_SHORT).show();
                        edtName.setText(""); edtNumber.setText("");
                        btnSelect.callOnClick(); // btnSelect()함수 호출
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);
                if(cursor.getCount()>0) {
                    iAdapter = new IdolAdapter(MainActivity.this, cursor, true);

                    listView.setAdapter(iAdapter);
                }
                else { //초기화 되어 테이블이 없는 경우 adapter 초기화시킴
                    iAdapter=null;
                    listView.setAdapter(iAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"조회 되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        cursor.close(); //커서를 닫으면 오류가 남! 커서는 onStop()에서 닫기
    }
}