package com.example.a1105_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chr;
    Button b_start, b_end;
    RadioButton rdocal, rdotime;
    CalendarView cal;
    TimePicker timePicker;
    TextView ty, tm, td, th, tmin;
    int sy, sm, sd, sh, smin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chr = findViewById(R.id.chr);
        b_start = findViewById(R.id.b_start);
        rdocal = findViewById(R.id.rdocal);
        rdotime = findViewById(R.id.rdotime);
        cal = findViewById(R.id.cal);
        timePicker = findViewById(R.id.timePicker);
        b_end = findViewById(R.id.b_end);
        ty = findViewById(R.id.ty);
        tm = findViewById(R.id.tm);
        td = findViewById(R.id.td);
        th = findViewById(R.id.th);
        tmin = findViewById(R.id.tmin);


        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chr.start();
                chr.setTextColor(Color.RED);
            }
        });
        rdocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });



        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int y, int m, int d) {
                sy = y;
                sm = m + 1;
                sd = d;
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int h, int min) {
                sh = h;
                smin = min;
            }
        });

        b_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chr.stop();
                chr.setTextColor(Color.GREEN);
                ty.setText(Integer.toString((sy)));
                tm.setText(Integer.toString((sm)));
                td.setText(Integer.toString((sd)));
                th.setText(Integer.toString(timePicker.getCurrentHour()));
                tmin.setText(Integer.toString(timePicker.setCurrentMinute()));
            }
        });

    }
}