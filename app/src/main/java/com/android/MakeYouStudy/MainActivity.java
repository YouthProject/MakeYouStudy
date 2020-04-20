package com.android.MakeYouStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
    }
}