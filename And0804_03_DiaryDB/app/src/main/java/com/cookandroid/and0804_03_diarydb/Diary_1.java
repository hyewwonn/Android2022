package com.cookandroid.and0804_03_diarydb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Diary_1 extends AppCompatActivity {
    DatePicker dataPicker1;
    EditText edtDiary;
    Button btnDWrite;
    String fileName;
    String strSDPath;
    MyDBHelper myDBHelper;
    SQLiteDatabase sqlDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        setTitle("일기장 SQLite 소영잉");

        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        dataPicker1=findViewById(R.id.dataPicker1);
        edtDiary=findViewById(R.id.edtDiary);
        btnDWrite=findViewById(R.id.btnDWrite);
        int cYear = Calendar.getInstance().get(Calendar.YEAR);
        int cMonth = Calendar.getInstance().get(Calendar.MONTH);
        int cDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();

        myDBHelper = new MyDBHelper(this);
        sqlDB =myDBHelper.getWritableDatabase();
        myDBHelper.onUpgrade(sqlDB,1,2);
        sqlDB.close();

        fileName = strSDPath + cYear + "_" + (cMonth + 1) + "_" + cDay + ".txt";
        String str = readDiary(fileName);
        edtDiary.setText(str);

        dataPicker1.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int mothOfYear, int dayOfMonth) {
                fileName =Integer.toString(year)+"_"+Integer.toString(mothOfYear+1)+"_"+Integer.toString(dayOfMonth);
                String str =readDiary(fileName);
                edtDiary.setText(str);
                btnDWrite.setEnabled(true);
            }
        });
        btnDWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnDWrite.getText().toString() == "새로저장"){
                    sqlDB=myDBHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO myDiary VALUES '"+fileName+"','"+edtDiary.getText().toString()+"');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"입력됨",Toast.LENGTH_SHORT).show();
                    btnDWrite.setText("수정하기");
                }else{
                    sqlDB=myDBHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE myDiary SET content = '"+edtDiary.getText().toString()+"'WHERE diaryDate = '"+fileName+"';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    String readDiary(String fName) {
        String diaryStr = null;
        sqlDB = myDBHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM myDiary WHERE diaryDate = '" + fName + "';", null);
        if(cursor == null){
            edtDiary.setHint("일기없음");
            btnDWrite.setText("새로저장");
        }else{
            if (cursor.moveToFirst() == true){
                diaryStr = cursor.getString(1);
                btnDWrite.setText("수정하기");
            }else{
                edtDiary.setHint("일기없음");
                btnDWrite.setText("새로저장");
            }
        }
        cursor.close();
        sqlDB.close();
        return diaryStr;
    }
}