package com.android.MakeYouStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;

    DatePicker datePicker; //날짜를 선택하는 달력
    TextView viewDatePick; //선택한 날짜를 보여주는 textview
    EditText edtDiary;// 선태한 날짜의 일정을 쓰거나 기존에 저자된 일기가 있다면 보여주고 수정하는 영역
    Button btnSave; //선택된 날짜의 파일이름

    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //initializing views
        //textViewUserEmail = (TextView)findViewById(R.id.textviewUserEmail);

        //firebaseAuth = FirebaseAuth.getInstance();
       // FirebaseUser user = firebaseAuth.getCurrentUser();

       // textViewUserEmail.setText("UserEmail : " + user.getEmail());

        //뷰에 있는 위젯들 리턴받기기
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        viewDatePick=(TextView)findViewById(R.id.viewDatePick);
        edtDiary=(EditText)findViewById(R.id.edtDairy);
        btnSave=(Button)findViewById(R.id.btnSave);

        //오늘 날짜 받게하기
        Calendar today= Calendar.getInstance();
        int todayYear=today.get(Calendar.YEAR);
        int todayMonth=today.get(Calendar.MONTH);
        int todayDay=today.get(Calendar.DAY_OF_MONTH);

        //첫시작 할 때 오늘 날짜 일정 읽어주기
        checkedDay(todayYear,todayMonth,todayDay);

        //datepick 기능 만들기
        //datePicker.init(연도,달,일)
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //이미 선택한 날짜에 일기가 있는지 없는지 체크
                checkedDay(year,monthOfYear,dayOfMonth);
            }
        });

        //저장/수정 버튼 누르면 실행되는 리스너
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fileName을 넣고 저장시키는 메소드를 호출
                saveDiary(fileName);
            }
        });
    }

    //일정 파일 읽기
    private void checkedDay(int year, int monthOfYear, int dayOfMonth) {
        //받은 날짜로 보여주기
        //viewDatePick.setText(year + "-" + monthOfYear + "-" + dayofMonth);

        //파일 이름을 만들어주기. 파일 이름.txt로 나옴.
        fileName = year + "" + monthOfYear + "" + dayOfMonth + ".txt";

        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            String str=new String(fileData, "EUC-KR");
            //읽어서 토스트 메세지로 보여줌
            Toast.makeText(getApplicationContext(), "일정 써둔 날", Toast.LENGTH_SHORT).show();
            edtDiary.setText(str);
            btnSave.setText("수정하기");
        } catch (Exception e) {
            //없어서 오류가 나면 일정가 없는 것 -> 일정을 쓰게 하기
            Toast.makeText(getApplicationContext(), "일정 없는 날", Toast.LENGTH_SHORT).show();
            edtDiary.setText("");
            btnSave.setText("새 일정 추가");
            e.printStackTrace();
        }
    }
    //일정 저장하는 메소드
    @SuppressLint("WrongConstant")
    private void saveDiary(String readDay){
        FileOutputStream fos=null;

        try{
            fos=openFileOutput(readDay,MODE_NO_LOCALIZED_COLLATORS);
            String content =edtDiary.getText().toString();

            //스트링을 배열형으로 변환?
            fos.write(content.getBytes());
            fos.close();

            Toast.makeText(getApplicationContext(),"일정 저장됨",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"오류발생",Toast.LENGTH_SHORT).show();
        }
    }
}
