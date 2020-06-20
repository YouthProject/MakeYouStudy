package com.android.MakeYouStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

public class AttendanceRateActivity extends AppCompatActivity {

    private PieChart chart;
    private SeekBar seekBarX, seekBarY;
    private TextView tvX, tvY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_rate);


    }
}
