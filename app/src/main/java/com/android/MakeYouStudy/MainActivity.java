package com.android.MakeYouStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonCalendar;
    private Button buttonTimeTable;
    private Button buttonDiary;
    private Button buttonProfile;
    private Button buttonML;
    private Button buttonAttendanceRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing views
        textViewUserEmail = (TextView)findViewById(R.id.textviewUserEmail);
        buttonCalendar = (Button)findViewById(R.id.buttonCalendar);
        buttonTimeTable = (Button)findViewById(R.id.buttonTimeTable);
        buttonDiary = (Button)findViewById(R.id.buttonDiary);
        buttonProfile = (Button)findViewById(R.id.buttonProfile);
        buttonML = (Button)findViewById(R.id.buttonML);
        buttonAttendanceRate = (Button)findViewById(R.id.buttonAttendance);

        // 권한설정 부분
        // Android 10 이상부터 사용자가 직접 OverlayPermission을 설정해 줘야함
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            if(!Settings.canDrawOverlays(getApplicationContext())){
                checkOverlayPermission();
            }
        }

        // 유저가 로그인하지 않은 상태라면 LoginActivity 실행
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        else{
            FirebaseUser user = firebaseAuth.getCurrentUser();
            textViewUserEmail.setText("UserEmail : " + user.getEmail());

            //button event
            buttonCalendar.setOnClickListener(this);
            buttonTimeTable.setOnClickListener(this);
            buttonDiary.setOnClickListener(this);
            buttonProfile.setOnClickListener(this);
            buttonML.setOnClickListener(this);
            buttonAttendanceRate.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == buttonCalendar){
            startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
        }
        if(view == buttonTimeTable){
            startActivity(new Intent(getApplicationContext(), TimeTableActivity.class));
        }
        if(view == buttonDiary){
            startActivity(new Intent(getApplicationContext(), DiaryActivity.class));
        }
        if(view == buttonProfile){
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        if(view == buttonML){
            startActivity(new Intent(getApplicationContext(), AttendanceCheckActivity.class));
        }
        if(view == buttonAttendanceRate){
            startActivity(new Intent(getApplicationContext(), AttendanceRateActivity.class));
        }
    }

    // alarm overlay permission check 알람이 시작될 때 Activity를 띄워줌
    private void checkOverlayPermission(){
        try{
            Uri uri = Uri.parse("package:" + getPackageName());
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, uri);

            startActivityForResult(intent, 5469);
        }catch (Exception e){
            Log.d("MainActivity", "" + e);
        }
    }
}