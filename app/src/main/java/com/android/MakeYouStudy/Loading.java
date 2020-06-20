package com.android.MakeYouStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Handler timer=new Handler();

        timer.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
                finish();

            }
        },2000);
    }
}
