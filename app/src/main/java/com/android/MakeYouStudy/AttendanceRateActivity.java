package com.android.MakeYouStudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AttendanceRateActivity extends AppCompatActivity {

    //firebase data object
    private DatabaseReference mDatabaseReference; // 데이터베이스의 주소를 저장합니다.
    private FirebaseDatabase mFirebaseDatabase; // 데이터베이스에 접근할 수 있는 진입점 클래스입니다.
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    PieChart pieChart;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_rate);

        // initializing database
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        mFirebaseDatabase = FirebaseDatabase.getInstance();

        // view object
        pieChart = (PieChart)findViewById(R.id.piechart);
        barChart = (BarChart)findViewById(R.id.barchart);

        pieChart.setNoDataText("Loading...");
        barChart.setNoDataText("Loading...");

        ArrayList<BarEntry> Daycheck = new ArrayList<BarEntry>();
        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();
        final String[] weekdays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
//        final int[] weekColor = {ContextCompat.getColor(this, R.color.Mon),R.color.Mon, R.color.Tue, R.color.Wed, R.color.Thu, R.color.Fri, R.color.Sat, R.color.Sun};
        final int[] weekColor = {
                ContextCompat.getColor(this, R.color.Mon),
                ContextCompat.getColor(this, R.color.Tue),
                ContextCompat.getColor(this, R.color.Wed),
                ContextCompat.getColor(this, R.color.Thu),
                ContextCompat.getColor(this, R.color.Fri),
                ContextCompat.getColor(this, R.color.Sat),
                ContextCompat.getColor(this, R.color.Sun)
        };
        final int[] checkColor = {ContextCompat.getColor(this, R.color.Check), ContextCompat.getColor(this, R.color.Total)};



        mDatabaseReference = mFirebaseDatabase.getReference().child("timetable_checked").child(user.getUid());
        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                float AllCheck = 0;
                float AllTotal = 0;
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    if(snapshot.getKey().equals("AllCheck")){
                        AllCheck = snapshot.getValue(Float.class);
                    }else if(snapshot.getKey().equals("AllTotal")){
                        AllTotal = snapshot.getValue(Float.class) - AllCheck;
                    }else{
                        float percent = snapshot.child("DayCheck").getValue(Float.class) / snapshot.child("DayTotal").getValue(Float.class) * 100;
                        if(Float.isNaN(percent)){
                            Daycheck.add(new BarEntry(Integer.parseInt(snapshot.getKey()), 0));
                        }else{
                            Daycheck.add(new BarEntry(Integer.parseInt(snapshot.getKey()), percent));
                        }
                        Log.d("이게왜", Integer.parseInt(snapshot.getKey()) + " 는 "+snapshot.child("DayCheck").getValue(Float.class) / snapshot.child("DayTotal").getValue(Float.class) * 100+"");
                    }
                }

                XAxis xAxis = barChart.getXAxis();
                YAxis yLAxis = barChart.getAxisLeft();
                YAxis yRAxis = barChart.getAxisRight();

                // Y축 오른쪽 비활성화
                yRAxis.setDrawLabels(false);
                yRAxis.setDrawAxisLine(false);
                yRAxis.setDrawGridLines(false);

                // Y축 왼쪽 설정
                yLAxis.setDrawLabels(false);
                yLAxis.setDrawAxisLine(false);
                yLAxis.setAxisMaximum(100f);

                // X축 설정
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE); // x값 표시 위치
                xAxis.setDrawGridLines(false); // x축 GridLine
                xAxis.setDrawAxisLine(false);
                xAxis.setTextSize(15f);
                xAxis.setValueFormatter(new IndexAxisValueFormatter(weekdays));

                barChart.getDescription().setEnabled(false); // 그래프 제목 삭제
                barChart.getLegend().setDrawInside(false);
                barChart.getLegend().setEnabled(false); // 그래프 범례 삭제

                barChart.setPinchZoom(false);
                barChart.setScaleEnabled(false);
                barChart.setDoubleTapToZoomEnabled(false);
                barChart.animateY(1500, Easing.EaseOutBounce);

                BarDataSet bardataset = new BarDataSet(Daycheck, "");
                BarData barData = new BarData(bardataset);
                bardataset.setColors(weekColor);

                barChart.setData(barData);

                // PieChart
                if(AllTotal == 0){
                    Toast.makeText(AttendanceRateActivity.this, "시간표가 없어 출석률을 확인할 수 없습니다. 시간표를 추가해주세요.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), TimeTableActivity.class));
                    finish();
                }else{
                    pieChart.setUsePercentValues(true);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setExtraOffsets(5, 5, 5, 5);

                    pieChart.setDragDecelerationFrictionCoef(0.5f);

                    pieChart.setHoleColor(Color.WHITE);
                    pieChart.setTransparentCircleRadius(55f);

                    yValues.add(new PieEntry(AllCheck,"출석"));
                    yValues.add(new PieEntry(AllTotal,"미출석"));

                    // 그래프 제목 지우기
                    Description piedescription = new Description();
                    piedescription.setEnabled(false);
                    pieChart.setDescription(piedescription);
                    pieChart.getLegend().setEnabled(false);

                    pieChart.animateY(1500, Easing.EaseOutBounce); // 애니메이션

                    PieDataSet pieDataSet = new PieDataSet(yValues, "");
                    pieDataSet.setSliceSpace(3f);
                    pieDataSet.setSelectionShift(12f);
                    pieDataSet.setColors(checkColor);

                    PieData pieData = new PieData(pieDataSet);
                    pieData.setValueTextSize(10f);
                    pieData.setValueTextColor(Color.YELLOW);

                    pieChart.setData(pieData);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }
}
