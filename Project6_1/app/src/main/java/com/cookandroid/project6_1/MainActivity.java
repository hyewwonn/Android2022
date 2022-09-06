package com.cookandroid.project6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono; Button btnStart, btnStop; RadioButton rdCal, rdTime;
    CalendarView cal; TimePicker time; TextView txtDate;
    int selYear, selMonth, selDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("양혜원");
        chrono = findViewById(R.id.chrono);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        rdCal = findViewById(R.id.rdCal);
        rdTime = findViewById(R.id.rdTime);
        cal = findViewById(R.id.cal);
        time = findViewById(R.id.time);
        txtDate = findViewById(R.id.txtDate);

        cal.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);

        rdCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);

            }
        });
        rdTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                String str = selYear+"년"+selMonth+"월"+selDay+"일"+
                        time.getCurrentHour()+"시"+time.getCurrentMinute()+"분에 예약됨";
                txtDate.setText(str);
            }
        });
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                selYear=year; selMonth=month; selDay=day;
            }
        });
    }
}






