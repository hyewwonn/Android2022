package com.cookandroid.and0728_03_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtname, txttel;
    String strname = "";
    String strtel ="";
    Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname = findViewById(R.id.txtname);
        txttel = findViewById(R.id.txttel);
        btnEnd = findViewById(R.id.btnEnd);

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.menu_option, menu); //자바로 객체화, 메뉴 영역에 내가 만든 거
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_register:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("전화 번호 등록");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final View dlgView = (View)View.inflate(MainActivity.this, R.layout.dlg, null);
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edName = dlgView.findViewById(R.id.edtName);
                        EditText edTel = dlgView.findViewById(R.id.edtTel);
                        strname += edName.getText().toString()+"\n";
                        txtname.setText(strname);
                        strtel += edTel.getText().toString()+"\n";
                        txttel.setText(strtel);
                    }
                });
                dlg.show();
                return true;
            case R.id.itemBlue:
                    txtname.setTextColor(Color.parseColor("#3F51B5"));
                    txttel.setTextColor(Color.parseColor("#3F51B5"));
                return true;
            case R.id.itemGreen:
                txtname.setTextColor(Color.parseColor("#4CAF50"));
                txttel.setTextColor(Color.parseColor("#4CAF50"));
                return true;
            case R.id.itemDefault:
                txtname.setTextColor(Color.parseColor("#000000"));
                txttel.setTextColor(Color.parseColor("#000000"));
                return true;
            default:
                return false;

        }
    }


}