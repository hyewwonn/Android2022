package com.cookandroid.and0804_03_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.and0804_03_diary.DiaryActivity;
import com.cookandroid.and0804_03_diary.DiaryAdapter;
import com.cookandroid.and0804_03_diary.MyDBHelper;

import org.w3c.dom.Text;

public class ListActivity extends AppCompatActivity {
    ListView list;
    MyDBHelper myHelper;
    Cursor cursor;
    SQLiteDatabase sqlDB;
    DiaryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        list = findViewById(R.id.list);
        myHelper = new MyDBHelper(this);
        sqlDB = myHelper.getReadableDatabase();
        cursor = sqlDB.rawQuery("SELECT * FROM DiaryTBL order by diaryDate desc;",null);
        if(cursor.getCount()>0) {
            adapter = new DiaryAdapter(ListActivity.this, cursor, true);
            list.setAdapter(adapter);
        } else {
            adapter = null;
            list.setAdapter(adapter);
            Toast.makeText(getApplicationContext(), "일기 없음", Toast.LENGTH_SHORT).show();
        }
        sqlDB.close();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                Intent in = new Intent(getApplicationContext(), DiaryActivity.class);
                in.putExtra("fname", txtName.getText().toString());
                startActivity(in);
                finish();
            }
        });
    }
}