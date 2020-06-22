package com.android.MakeYouStudy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.tlaabs.timetableview.Schedule;
import com.github.tlaabs.timetableview.TimetableView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class TimeTableActivity extends AppCompatActivity implements View.OnClickListener{
    private Context context;
    public static final int REQUEST_ADD = 1;
    public static final int REQUEST_EDIT = 2;

    //firebase auth object
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    //firebase data object
    private DatabaseReference mDatabaseReference; // 데이터베이스의 주소를 저장합니다.
    private FirebaseDatabase mFirebaseDatabase; // 데이터베이스에 접근할 수 있는 진입점 클래스입니다.

    //Alarm object
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    //view objects
    private Button addBtn;
    private Button clearBtn;

    private TimetableView timetable;

    private int[] days;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        // initializing database
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("timetable").child(user.getUid());

        // AlarmManger Service
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        init();
        checkPictureCount(); // 사진이 저장되어있는지 확인
        dayCheckZero(); // TimeTable을 처음 사용할 때 dayCheck값 0으로 초기화

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // count가 null이 아닐 때 알람삭제
                if(dataSnapshot.child("count").getValue(Integer.class) != null){
                    count = dataSnapshot.child("count").getValue(Integer.class);
                    alarmOff(count);
                }
                if(dataSnapshot.child("table").getValue(String.class) != null){
                    timetable.load(dataSnapshot.child("table").getValue(String.class));
                    AddAlarm(dataSnapshot.child("table").getValue(String.class));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }

    private void init(){
        int nWeek = doDayOfWeek();

        this.context = this;
        addBtn = findViewById(R.id.add_btn);
        clearBtn = findViewById(R.id.clear_btn);

        timetable = findViewById(R.id.timetable);
        timetable.setHeaderHighlight(nWeek);
        initView();
    }

    private void initView(){
        addBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
        timetable.setOnStickerSelectEventListener(new TimetableView.OnStickerSelectedListener() {
            @Override
            public void OnStickerSelected(int idx, ArrayList<Schedule> schedules) {
                Intent i = new Intent(context, EditActivity.class);
                i.putExtra("mode",REQUEST_EDIT);
                i.putExtra("idx", idx);
                i.putExtra("schedules", schedules);
                startActivityForResult(i,REQUEST_EDIT);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
                Intent i = new Intent(this,EditActivity.class);
                i.putExtra("mode",REQUEST_ADD);
                startActivityForResult(i,REQUEST_ADD);
                break;
            case R.id.clear_btn:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("주의하세요!").setMessage("전체 삭제는 모든 시간표와 출석률을\n 초기화 합니다.");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        timetable.removeAll();
                        // save data to db
                        mDatabaseReference.child("table").setValue(timetable.createSaveData());
                        dayCheckinit();
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_ADD:
                if (resultCode == EditActivity.RESULT_OK_ADD) {
                    ArrayList<Schedule> item = (ArrayList<Schedule>) data.getSerializableExtra("schedules");
                    timetable.add(item);
                    // save data to db
                    mDatabaseReference.child("table").setValue(timetable.createSaveData());
                    Toast.makeText(this, "시간표가 추가 되었습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_EDIT:
                /** Edit -> Submit */
                if (resultCode == EditActivity.RESULT_OK_EDIT) {
                    int idx = data.getIntExtra("idx", -1);
                    ArrayList<Schedule> item = (ArrayList<Schedule>) data.getSerializableExtra("schedules");
                    timetable.edit(idx, item);
                    // save data to db
                    mDatabaseReference.child("table").setValue(timetable.createSaveData());
                    Toast.makeText(this, "시간표가 수정 되었습니다.", Toast.LENGTH_SHORT).show();
                }
                /** Edit -> Delete */
                else if (resultCode == EditActivity.RESULT_OK_DELETE) {
                    int idx = data.getIntExtra("idx", -1);
                    timetable.remove(idx);
                    // save data to db
                    mDatabaseReference.child("table").setValue(timetable.createSaveData());
                    Toast.makeText(this, "시간표가 삭제 되었습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    // timetable.setHeaderHighlight를 위한 DayOfWeek 계산
    private int doDayOfWeek(){
        Calendar cal = Calendar.getInstance();
        int nWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(nWeek==1){
            nWeek = 7;
        }else{
            nWeek -= 1;
        }
        return nWeek;
    }

    // Parse json and add Alarm
    public void AddAlarm(String json){

        int alarmCount = 0; // Alarm의 requestcode확인을 위한 변수
        // 시간 설정
        Calendar calendar = Calendar.getInstance();
        // timetable_checked의 Total값 초기화
        initDaysTotal();
        // json parse
        JsonParser parser = new JsonParser();
        JsonObject obj1 = (JsonObject)parser.parse(json);
        JsonArray arr1 = obj1.getAsJsonArray("sticker");

        for(int i = 0; i < arr1.size(); i++){
            alarmCount = i;
            JsonObject obj2 = (JsonObject)arr1.get(i);
            JsonArray arr2 = (JsonArray)obj2.get("schedule");
            for(int k = 0; k < arr2.size(); k++){
                JsonObject obj3 = (JsonObject)arr2.get(k);

                // obj3 will be used for AttendanceCheck_Activity
                obj3.get("classTitle").getAsString();
                obj3.get("classPlace").getAsString();
                obj3.get("professorName").getAsString();
                obj3.get("day").getAsInt();

                JsonObject obj4 = (JsonObject)obj3.get("startTime");
                obj4.get("hour").getAsInt();
                obj4.get("minute").getAsInt();
                Log.d("hello", obj3.get("classTitle").getAsString() +
                        obj3.get("classPlace").getAsString() +
                        obj3.get("professorName").getAsString() +
                        obj3.get("day").getAsInt() +
                        obj4.get("hour").getAsInt() +
                        obj4.get("minute").getAsInt() +
                        " i : " + i
                        );
                // database timetable_checked에 요일별로 total값을 계산해준다.
                days[obj3.get("day").getAsInt()]++;

                calendar.set(Calendar.HOUR_OF_DAY, obj4.get("hour").getAsInt());
                calendar.set(Calendar.MINUTE, obj4.get("minute").getAsInt());
                calendar.set(Calendar.SECOND, 0);
                // 현재시간보다 이전이면 다음날로 설정해 계속 알람이 울리는 오류를 해결
                if (!calendar.before(Calendar.getInstance())){
                    // Receiver 설정
                    Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                    intent.putExtra("weekday", obj3.get("day").getAsInt());
                    intent.putExtra("state", "on"); // state 값이 on 이면 알람시작, off 이면 중지, day는 Receiver에서 구분
                    intent.putExtra("reqCode", i);
                    pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), i, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                    Log.d("Alarm이 등록되었습니다.", "제발" + i);
                    // 알람 설정, API 별로 alarmManger.set 함수 구별
                    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                            // API 19이상 API 23미만
                            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                        }else{
                            // API 19미만
                            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                        }
                    }else{
                        // API 23이상
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                    }
                }

//                if (calendar.before(Calendar.getInstance())){
//                    calendar.add(Calendar.DATE, 1);
//                }
//                // Receiver 설정
//                Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
//                intent.putExtra("weekday", obj3.get("day").getAsInt());
//                intent.putExtra("state", "on"); // state 값이 on 이면 알람시작, off 이면 중지, day는 Receiver에서 구분
//                intent.putExtra("reqCode", i);
//                pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), i, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//                Log.d("Alarm이 등록되었습니다.", "제발" + i);
//                // 알람 설정, API 별로 alarmManger.set 함수 구별
//                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
//                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
//                        // API 19이상 API 23미만
//                        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//                    }else{
//                        // API 19미만
//                        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//                    }
//                }else{
//                    // API 23이상
//                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//                }
            }
        }
        mDatabaseReference.child("count").setValue(alarmCount); // AlarmCount 저장
        daysUpdate();
    }

    public void daysUpdate(){
        int sum = 0;
        for(int i = 0; i < 7; i++) {
            mFirebaseDatabase.getReference().child("timetable_checked").child(user.getUid()).child(i + "").child("DayTotal").setValue(days[i]);
            sum += days[i];
        }
        mFirebaseDatabase.getReference().child("timetable_checked").child(user.getUid()).child("AllTotal").setValue(sum);
    }
    public void initDaysTotal(){
        days = new int[]{0, 0, 0, 0, 0, 0, 0};

    }

    public void checkPictureCount(){
        mFirebaseDatabase.getReference().child("image").child(user.getUid()).child("size").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue(String.class) == null || !dataSnapshot.getValue(String.class).equals("5")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("사진 등록이 필요합니다.").setMessage("프로필에서 5장의 책상 사진을 업로드하세요.");
                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                            finish();
                        }
                    });
                    builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }

    // 강제로 출석체크확인 값을 0으로 초기화
    public void dayCheckinit(){
        for (int i = 0; i < 7; i++){
            mFirebaseDatabase.getReference().child("timetable_checked").child(user.getUid()).child(i + "").child("DayCheck").setValue(0);
        }
        mFirebaseDatabase.getReference().child("timetable_checked").child(user.getUid()).child("AllCheck").setValue(0);
    }

    // 초기 TimeTable 실행시 출석체크확인값을 0으로 초기화
    public void dayCheckZero(){
        mFirebaseDatabase.getReference().child("timetable_checked").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("0").child("DayCheck").getValue(Integer.class) == null){
                    for(int i = 0; i < 7; i++){
                        mFirebaseDatabase.getReference().child("timetable_checked").child(user.getUid()).child(i + "").child("DayCheck").setValue(0);
                    }
                    mFirebaseDatabase.getReference().child("timetable_checked").child(user.getUid()).child("AllCheck").setValue(0);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }

    public void alarmOff(int tmpcount){
        for(int i = 0; i <= tmpcount; i++){
            Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
            intent.putExtra("state","reset");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), i, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            alarmManager.cancel(pendingIntent);
            Log.d("ReqTest", i + " 의 pendingintent 알람이 해제되었습니다.");
        }
    }
}