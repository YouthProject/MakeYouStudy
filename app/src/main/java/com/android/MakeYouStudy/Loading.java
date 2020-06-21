package com.android.MakeYouStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView splashGif = (ImageView)findViewById(R.id.imageView);
        Glide.with(this).load(R.raw.loading).into(splashGif);
        Handler timer=new Handler();

        timer.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
                finish();

            }
        },3000);
    }
}
