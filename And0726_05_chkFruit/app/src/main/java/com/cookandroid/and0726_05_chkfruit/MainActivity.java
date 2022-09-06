package com.cookandroid.and0726_05_chkfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox fruit[] = new CheckBox[4];
    Integer chkTest[] = {R.id.strawberry, R.id.grape, R.id.kiwi, R.id.grapefruit};
    Button btn_Ok;
    TextView txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i<fruit.length; i++){
            fruit[i] = findViewById(chkTest[i]);
        }
        btn_Ok = findViewById(R.id.btn_Ok);
        txtv = findViewById(R.id.txtv);

        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str ="";
                for(int i = 0; i<fruit.length; i++){
                    if(fruit[i].isChecked() == true){
                        str = str + (fruit[i].getText().toString()+" ");
                    }
                }
                txtv.setText("선택결과 : "+str);
            }
        });

        for(int i = 0; i<fruit.length; i++){
            final int k = i;
            fruit[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    btn_Ok.performClick();// == btnOnClick
                }
            });
        }
    }
}