package com.cookandroid.and0803_01_carlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    CarAdapter mAdapter;
    ArrayList<Car> mArray;
    Car mItem;

    Integer[] poster = {R.drawable.car1, R.drawable.car2,R.drawable.car3, R.drawable.car4, R.drawable.car5,
            R.drawable.car6, R.drawable.car7, R.drawable.car8, R.drawable.car9, R.drawable.car10};
    String[] title = {"SM3", "SM4", "SM5", "SM6", "S4",
            "A5", "A3", "A7", "K8", "카니발"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("CarCustomList");
        list = findViewById(R.id.list);
        mArray = new ArrayList<>();
        for(int i = 0; i<poster.length; i++){
            mItem = new Car(ContextCompat.getDrawable(this, poster[i]),title[i]);
            mArray.add(mItem);
        }//무비 객체 배열 초기화(ArrayList에 value으로 생성)
        mAdapter = new CarAdapter(this, mArray);
        list.setAdapter(mAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Car item = (Car) list.getItemAtPosition(i);
                customToast(item);

            }
        });
    }//onCreate
    public void customToast(Car item){
        View layout = getLayoutInflater().inflate(R.layout.car_toast, null);
        ImageView img = layout.findViewById(R.id.toast_img);
        TextView txt = layout.findViewById(R.id.toast_txt);
        img.setImageDrawable(item.getImage());
        txt.setText(item.getTitle());

        Toast t =new Toast(getApplicationContext());
        t.setView(layout);
        //위치지정
        t.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        t.setDuration(Toast.LENGTH_SHORT);
        t.show();
    }
}