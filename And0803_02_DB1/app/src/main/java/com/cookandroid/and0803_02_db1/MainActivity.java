package com.cookandroid.and0803_02_db1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    TextView txtNameResult, txtNumberResult;
    Button btnClear, btnInsert, btnSelect, btnAm, btnDel;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MPDB1");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        txtNameResult = findViewById(R.id.txtNameResult);
        txtNumberResult = findViewById(R.id.txtNumberResult);
        btnAm = findViewById(R.id.btnUpdate);
        btnDel = findViewById(R.id.btnDelete);

        btnClear = findViewById(R.id.btnClear);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);

        myHelper = new MyDBHelper(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "초기화", Toast.LENGTH_SHORT).show();
            }
        });

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
                Cursor cursor = sqlDB.rawQuery("select * from groupTBL;", null);
                String strNames = "그룹이름\r\n"+"---------------\r\n";
                String strNums = "인원수\r\n"+"---------------\r\n";
                while(cursor.moveToNext()){
                    strNames+=cursor.getString(0)+"\n";
                    strNums+=cursor.getString(1)+"\n";
                }
                txtNameResult.setText(strNames);
                txtNumberResult.setText(strNums);
                cursor.close();
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회 성공", Toast.LENGTH_SHORT).show();
            }
        });

        btnAm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.update, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 정보 변경");
                dlg.setView(v);
                final EditText edtAmGName = v.findViewById(R.id.edtchgname);
                final EditText edtAmNumber = v.findViewById(R.id.edtchgnum);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtAmGName.getText().toString().trim();
                            String number = edtAmNumber.getText().toString().trim();
                            if(!name.isEmpty() && !number.isEmpty()){
                                String sql = "UPDATE groupTBL SET gNumber = "+number+" WHERE gName = '"+name+"'";
                                sqlDB.execSQL(sql);
                                sqlDB.close();
                                btnSelect.callOnClick();
                                Toast.makeText(getApplicationContext(), name+" 수정되었습니다.", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getApplicationContext(), "이름과 인원을 입력해야 합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(), "수정에 실패했습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소하였습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.delete, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 삭제");
                dlg.setView(v);
                final EditText edtDeleteGName = v.findViewById(R.id.edtdelname);
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtDeleteGName.getText().toString().trim();
                            if(!name.isEmpty()){
                                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '"+name+"';");
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(), name+" 삭제됨",
                                        Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            }else{
                                Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(), "삭제에 실패했습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "삭제 취소되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
    }
}