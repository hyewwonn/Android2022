package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    CheckBox chkGame, chkMusic, chkExercise;
    Button btnIn;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        chkGame = findViewById(R.id.chkGame);
        chkMusic = findViewById(R.id.chkMusic);
        chkExercise = findViewById(R.id.chkExercise);
        btnIn = findViewById(R.id.btnIn);

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());
                String hobby = "";
                if(chkGame.isChecked() == true){
                    hobby += chkGame.getText().toString()+" ";
                }
                if(chkMusic.isChecked() == true){
                    hobby += chkMusic.getText().toString()+" ";
                }
                if(chkExercise.isChecked() == true){
                    hobby += chkExercise.getText().toString()+" ";
                }
                Intent in = new Intent(getApplicationContext(), SecondActivity.class);

                //list.add(new String("Hobby", hobby));
                in.putExtra("Name", name);
                in.putExtra("Age", age);
                in.putExtra("Hobby", hobby);
                startActivity(in); //SecondActivity 화면에 열기 => 클릭했을 때 화면 넘어가는 코드!
            }
        });
    }
}