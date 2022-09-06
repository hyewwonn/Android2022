package com.cookandroid.and0726_04_total;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtxt;
    Button btnToast, btnPage;
    RadioGroup rg;
    RadioButton nougat, oreo;
    ImageView imgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt = findViewById(R.id.edtxt);
        btnToast = findViewById(R.id.btnToast);
        btnPage = findViewById(R.id.btnPage);
        rg = findViewById(R.id.rg);
        nougat = findViewById(R.id.nougat);
        oreo = findViewById(R.id.oreo);
        imgv = findViewById(R.id.imgv);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), edtxt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.daum.net"));
                startActivity(urlOpen);
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.nougat: imgv.setImageResource(R.drawable.nougat); break;
                    case R.id.oreo: imgv.setImageResource(R.drawable.oreo); break;
                }
            }
        });
    }
}