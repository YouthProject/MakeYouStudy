package com.android.MakeYouStudy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //firebase data object
    private DatabaseReference mDatabaseReference; // 데이터베이스의 주소를 저장합니다.
    private FirebaseDatabase mFirebaseDatabase; // 데이터베이스에 접근할 수 있는 진입점 클래스입니다.
    private FirebaseUser user;

    EditText edtDiary;// 선태한 날짜의 일정을 쓰거나 기존에 저자된 일기가 있다면 보여주고 수정하는 영역
    Button btnSave; //선택된 날짜의 파일이름

    // 선택한 날짜
    int checkYear;
    int checkMonth;
    int checkDay;
    private int widget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // initializing database
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        mFirebaseDatabase = FirebaseDatabase.getInstance();

        //뷰에 있는 위젯들 리턴받기기
        edtDiary=(EditText)findViewById(R.id.edtDairy);
        btnSave=(Button)findViewById(R.id.btnSave);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        List<EventDay> events = new ArrayList<> ();

        // 오늘 날짜 받게하기
        Calendar today= Calendar.getInstance();
        int todayYear=today.get(Calendar.YEAR);
        int todayMonth=today.get(Calendar.MONTH);
        int todayDay=today.get(Calendar.DAY_OF_MONTH);

        // 현재 선택한 날짜
        checkYear = todayYear;
        checkMonth = todayMonth;
        checkDay = todayDay;

        // 첫시작 할 때 일정이 있으면 캘린더에 dot(강아지발자국)으로 표시해주기
        mFirebaseDatabase.getReference().child("calendar").child(user.getUid()).addValueEventListener(new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) { //일정데이터가 변경될 때 onDataChange함수 발생
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String key = snapshot.getKey();
                    int[] date = splitDate(key);
                    Calendar event_calendar = Calendar.getInstance();
                    event_calendar.set(date[0], date[1], date[2]);
                    EventDay event = new EventDay(event_calendar, R.drawable.ic_sprout);
                    events.add(event);
                }
                calendarView.setEvents(events);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });


        // 첫시작 할 때 오늘 날짜 일정 읽어주기
        checkedDay(todayYear, todayMonth, todayDay);

        // 선택 날짜가 변경될 때 호출되는 리스너
        calendarView.setOnDayClickListener(new OnDayClickListener () {
            @Override
            public void onDayClick(EventDay eventDay) {
                Calendar clickedDayCalendar = eventDay.getCalendar();
                //이미 선택한 날짜에 일기가 있는지 없는지 체크
                checkedDay(clickedDayCalendar.get(Calendar.YEAR),
                        clickedDayCalendar.get(Calendar.MONTH),
                        clickedDayCalendar.get(Calendar.DATE));
                //체크한 날짜 변경
                checkYear = clickedDayCalendar.get(Calendar.YEAR);
                checkMonth = clickedDayCalendar.get(Calendar.MONTH);
                checkDay = clickedDayCalendar.get(Calendar.DATE);
            }
        });

        //저장/수정 버튼 누르면 실행되는 리스너
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fileName을 넣고 저장시키는 메소드를 호출
                saveDiary(checkYear + "-" + checkMonth + "-" + checkDay);
            }
        });
    }

    //일정 Database 읽기
    private void checkedDay(int year, int monthOfYear, int dayOfMonth) {
        // mDatabaseReference의 경로를 filebase/diary/userUid/date 로 설정
        mDatabaseReference = mFirebaseDatabase.getReference().child("calendar").child(user.getUid()).child(year + "-" + monthOfYear + "-" + dayOfMonth);
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String str = dataSnapshot.getValue(String.class);
                if(str==null){
                    // 데이터가 없으면 일정이 없는 것 -> 일정을 쓰게 하기
                    edtDiary.setText("");
                    //btnSave.setText("새 일정 추가");
                    btnSave.setBackgroundResource(R.drawable.ic_newsave);
                }else{
                    // mDatabaseReference 경로에 저장된 str을 받아온다.
                    edtDiary.setText(str);
                    //btnSave.setText("수정하기");
                    btnSave.setBackgroundResource(R.drawable.ic_fix);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {  }
        });
    }

    //일정 저장하는 메소드
    @SuppressLint("WrongConstant")
    private void saveDiary(String readDay){
        try{ //일정이 저장될때 try문 발생.
            mDatabaseReference = mFirebaseDatabase.getReference().child("calendar").child(user.getUid()).child(readDay);
            String content =edtDiary.getText().toString();
            // filebase/calendar/userUid/date save
            mDatabaseReference.setValue(content);
            //일정이 저장되면 토스메세지로 "일정 저장 됨"
            Toast.makeText(getApplicationContext(),"일정 저장 완료",Toast.LENGTH_SHORT).show();
        } catch (Exception e){             //예외처리.
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"오류발생",Toast.LENGTH_SHORT).show();
        }
    }
    //문자열을 int로 변환한다.
    private int[] splitDate(String date){
        String[] splitText = date.split("-");
        int[] result_date = {Integer.parseInt(splitText[0]), Integer.parseInt(splitText[1]), Integer.parseInt(splitText[2])};
        return result_date;
    }
}