package com.android.MakeYouStudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AttendanceCheckActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity"; //
    final int LABEL_ACTIVITY = 1;
    final int TEXT_ACTIVITY = 2;
    private Button btnCheck;
   //public String label;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_check);



        btnCheck = (Button)findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), ImageLabelActivity.class), LABEL_ACTIVITY);
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
                else {

                    Toast.makeText(this, "출석체크 실패 : "+label, Toast.LENGTH_SHORT).show();
                    count++;

                    Log.d("count_number", ""+count);

                    if(count>=3){ // count 가 3일 때 (사물인식 출석체크 3번 실패 시) count = 0으로 셋팅후 textRecognition 메소드 실행(text 인식 출석체크 Activity 실행)
                        count = 0;
                        Log.d("count_reset", ""+count);

//                      String text = data.getStringExtra("Text");
                        textRecognition();
                    }
                }
                break;
            case TEXT_ACTIVITY :
                boolean checkValue = data.getBooleanExtra("checkValue", false);
                if(checkValue == true){
                    Toast.makeText(this, "Text 출석체크 완료", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    //메소드 하나 만들기 - Text Activity 로 보내면서, 임의의 영어 문장 or 단어 전달하고, Text 인식된 값을 불러오기기

    public void textRecognition(){
        Log.d("textRecognition_method", "start");
        Intent intent = new Intent(this, TextRecognitionActivity.class );

        intent.putExtra("English", "Yeon ah");

        startActivityForResult(intent, TEXT_ACTIVITY);
    }



//    public boolean checklabel(String label){
//        if (label == "Desk"){
//            Toast.makeText(this, "출석체크 완료 : "+label, Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        else if(label == "Table"){
//            Toast.makeText(this, "출석체크 완료 : "+label, Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        else{
//            Toast.makeText(this, "출석체크 실패 : "+label, Toast.LENGTH_SHORT).show();
//            return false;
//        }
//    }

}