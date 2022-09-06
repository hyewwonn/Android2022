package com.cookandroid.and0729_02_innerrawmem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Button btnInnerRead, btnInnerWrite, btnRawRead;
    EditText edtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[양혜원]파일 입출력(내장, RAW");
        btnInnerRead = findViewById(R.id.btninnerRead);
        btnInnerWrite = findViewById(R.id.btninnerWrite);
        btnRawRead = findViewById(R.id.btnRawRead);
        edtData = findViewById(R.id.edtData);

        //input 스트림은 읽기용, output 스트림은 쓰기용!!!
        btnInnerWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput("fileTest.txt", Context.MODE_PRIVATE); //MODE_PRIVATE: 파일 쓰기용으로 open
                    String str = "하이";
                    outFs.write(str.getBytes());
                    outFs.close(); //파일 다 썼으면 반드시 닫아 주기!!!
                    Toast.makeText(getApplicationContext(), "fileTest 파일 생성함",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                }
            }
        });

        btnInnerRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFs = openFileInput("fileTest.txt");
                    byte[] str = new byte[100]; //읽을 크기
                    inFs.read(str);
                    edtData.setText(new String(str)); //new String(str) 대신 str.toString() 해도 됨
                    inFs.close();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "파일없음", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRawRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inS = getResources().openRawResource(R.raw.test);
                    byte[] in = new byte[inS.available()];
                    inS.read(in);
                    String data = new String(in);
                    edtData.setText(data);
                    inS.close();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "파일없음", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}