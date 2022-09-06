package com.cookandroid.and_0802_05_multi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtData;
    ListView list;
    Button btnAdd, btnDelete;
    ArrayList<String> data = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트 동적 추가 삭제[양혜원]");
        list = findViewById(R.id.list);
        edtData = findViewById(R.id.edtData);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        adapter = new ArrayAdapter<>(this, android.R.layout. simple_list_item_multiple_choice, data);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(edtData.getText().toString());
                adapter.notifyDataSetChanged(); //데이터 추가로 새로고침
                edtData.setText("");
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray sbArray = list.getCheckedItemPositions();
                if(sbArray.size()!=0){
                    for(int i = list.getCount()-1; i>=0; i--)
                        if(sbArray.get(i)) data.remove(i);

                    list.clearChoices();
                    adapter.notifyDataSetChanged();//데이터 추가로 새로고침
                }
            }
        });
        edtData.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER){ //enter키 일 경우
                    data.add(edtData.getText().toString());
                    adapter.notifyDataSetChanged();
                    edtData.setText("");
                }
                return true;
            }
        });
    }
}