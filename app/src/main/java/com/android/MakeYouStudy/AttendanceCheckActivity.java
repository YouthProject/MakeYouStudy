package com.android.MakeYouStudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class AttendanceCheckActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity"; //
    // 출석체크시 Activity 구분을 위한 숫자
    final int LABEL_ACTIVITY = 1;
    final int TEXT_ACTIVITY = 2;
    // Button
    private Button btnCheck;
    private Button btnTextCheck;
    private Button btnSkip;
    // ImageLabel 인식불가 count num
    private int count;
    // Text Recognition 랜덤 문자
    private Random rnd;
    private String[] randomText;
    // Skip dialog
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_check);

        randomText = getResources().getStringArray(R.array.random_text);
        rnd = new Random();

        btnCheck = (Button)findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), ImageLabelActivity.class), LABEL_ACTIVITY);
            }
        });

        btnTextCheck = (Button)findViewById(R.id.btnTextCheck);
        btnTextCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textRecognition();
            }
        });

        btnSkip = (Button)findViewById(R.id.btnSkip);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogSkip();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case LABEL_ACTIVITY:

                String label = data.getStringExtra("labeling");

                if(label.equals("Desk") || label.equals("Table") ){
                    Toast.makeText(this, "Label 출석체크 완료 : "+label, Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "실행");
                    finish();
                }
                else if(label.equals("BackPressed")){
                    Toast.makeText(this, "Label 출석체크 취소", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(this, "출석체크 실패 : "+label, Toast.LENGTH_SHORT).show();
                    count++;

                    Log.d("count_number", ""+count);

                    if(count>=3){ // count 가 3일 때 (사물인식 출석체크 3번 실패 시) count = 0으로 셋팅후 textRecognition 메소드 실행(text 인식 출석체크 Activity 실행)
                        count = 0;
                        Log.d("count_reset", ""+count);

                        textRecognition();
                    }
                }
                break;
            case TEXT_ACTIVITY :
                boolean checkValue = data.getBooleanExtra("checkValue", false);
                if(checkValue == true){
                    Toast.makeText(this, "Text 출석체크 완료", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(this, "Text 출석체크 취소", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    public void textRecognition(){
        Log.d("textRecognition_method", "start");
        Intent intent = new Intent(this, TextRecognitionActivity.class );

        int num = rnd.nextInt(9);

        intent.putExtra("English", randomText[num]);

        startActivityForResult(intent, TEXT_ACTIVITY);
    }

    public void dialogSkip(){
        activity = this;


        AlertDialog.Builder alertdialog = new AlertDialog.Builder(activity);
        alertdialog.setMessage("Skip 하면 결석처리가 됩니다.");

        // 확인버튼 - 결석
        alertdialog.setPositiveButton("확인", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "결석처리 되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        // 취소버튼
        alertdialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "'취소'버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert = alertdialog.create();
        alert.setTitle("Skip");

        alert.show();

    }
}