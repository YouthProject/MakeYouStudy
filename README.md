# MakeYouStudy
MakeYouStudy/App Project
# 다운받기 전 필요한 부분
- openCV(NDK 다운?)
- 안드로이드 스튜디오 3.4.0 이상의 버전
[Download link] ([http://developer.android.com/studio/index.html](http://developer.android.com/studio/index.html))
- API: 21이상


#  목차
### 1. 소개
- 앱소개
- 주제를 선정하게 된 이유 
- 간략한 기능 소개
- 앱 사용방법

### 2. 사전 설정 및 환경 구축
- 라이브러리 설정
- Firebase 
- Github

### 3. 기능 구현
- 각 액티비티기능 설명
- 권한 허용 알림 및 로그인
- Random wise saying
- Calendar
- Timetable
- Diary
- Attendance Check & Attendance Rate
- Profile & Setting
 
###  4. 평가요소
- 차별성
- 실용성
- 시장성

###  5. 수익화 방안
### 6. 기대효과
### 7. 결론
### 8. 참고자료

#  1. 소개
![MYS로고](https://user-images.githubusercontent.com/62635984/85444064-ea795f00-b5cc-11ea-817e-ebf4610dc6f9.png)

make you study는 새 학기가 시작되어서 공부를 하고 싶다는 학생들에게 큰 도움을 줄 수 있는 훌륭한 앱이다. 자기 시간관리는 물론 본인의지 출석체크를 통해 학습시간을 기록 할 수 있다. 이 어플은 다이어리, 캘린더, 시간표 기능을 통한 일과 기록과 딥러닝 기술을 이용한 출석체크의 기능을 가지고 있다. 로그인 후 출석체크를 위해서는 본인이 등록한 책상이미지를 등록해야 출석체크가 인정된다. 

##  주제를 선정하게 된 이유
- 우리는 평소에 공부를 할 때 책상에 앉는 것부터 시작된다. 하지만 책상에 앉기까지 오래 걸리고 공부를 할 동기              와 마음가짐이 중요하다.  Make You Study는 책상에 앉는 습관을 기르고 공부의 시작부터 마무리까지, 다짐에서 실천까지 이끌어주기 위해 제작을 시작하였다.



##  간략한 기능 설명
**1. 로그인기능**
- 데이터베이스를 총괄적으로 관리, 설계하는 Profile기능
- 구글과 페이스북 연동을 통한 로그인, 이메일을 통한 회원가입, 비밀번호 찾기 기능 구현

**2. 메인화면**
- 앱에 접속할 때마다 바뀌는 명언
-  캘린더, 타임테이블, 다이어리, 출석률그래프 버튼 

**3. 캘린더기능**
- 날짜에 할 일 및 예정을 적을 수 있는 캘린더 기능
- 날짜에 맞게 할 일을 추가 시 DOT표시 생성

**4. 타임테이블기능**
- 본인이 만든 시간표를 직접 작성할 수 있는 타임테이블
-  시간표 시간을 통한 출석률 체크 연동

**5. 다이어리기능**
- 각자의 일과 및 오늘 하루를 적을 수 있는 다이어리
- 다이어리 작성 시 목록 보기 칸에 리스트 자동 생성

**6. 출석체크기능**
- 본인 책상 사진 5장 등록
- timetable과의 연동으로 설정한 시간이 될 때 출석체크 알람 발생
- 출석체크 알람을 끄기 위해서는 그 시간대에 책상 사진을 찍어서 인증 시 알람 꺼짐
- 출석체크 인정 시 
- 당일 출석률 채워짐

##  앱 사용 방법
1. 회원가입 및 로그인을 합니다.
2. 출석체크 
   - 설정 혹은 타임테이블에 들어가서 책상 이미지 5장을 등록합니다.
   - 사용자에 맞게 시간표(시간 설정)를 설정합니다.
   - 시간에 맞게 알림이 울리고 3가지 출석체크 방법 중 한 가지를 선택하여 출석체크를 완료합니다.
(등록해놓은 책상 사진과 비교하기, 등록해놓지 않은 책상을 촬영하기, 텍스트 인식하기) 
    - AttendanceRate를 통해서 출석률 그래프를 확인합니다.
3. 사용자에 맞게 캘린더에 일정을 추가하고 확인합니다.
4. 사용자에 맞게 다이어리를 작성하고, 저장 된 다이어리들을 목록 보기에서 확인할 수 있습니다. 
5. 설정에서 계정을 관리 할 수 있습니다.
 
#  2. 사전 설정 및 환경 구축 
##   라이브러리 설정
##   Firebase 
##  Github

#  3. 기능구현
##   각 액티비티 기능 설명
|  클래스              | 기능                     |layout                         |
|----------------|-------------------------------|-----------------------------|
|Login           |  로그인                        |login.xml                       |
|                | 비밀번호 찾기                   | activity_find.xml              |
|                |회원가입                         |activity_signup.xml            |
|Logout          |책상이미지등록, 로그아웃, 회원탈퇴  |acticity_profile.xml           |
|Timetable       |시간표 생성                    |activity_timetable.xml|
|                |시간표 추가                      |activity_edit.xml              |
| Diary          |다이어리 작성                    |tab_write                     |
|                |다이어리 목록 보기               |list_layout.xml              |
|                |업데이트된 다이어리 글 보기         |activity_diary_update.xml   |
|Calendar        |캘린더 생성 및 작성               |acticity_calendar.xml |
|Attendance       | 출석률 그래프로 보기          |activity_attendance_rate.xml           |
|               |사물인식통한 출석체크                |activity_image_label.xml|
|                |글씨를 통한 출석체크 +추가해             |  activity_machine_learning.xml      |
 
<br>

 ##  권한 허용 알림 및 로그인
## Random wise saying

##   Calendar
Calendar기능은 자신의 한달 일정을 확인 할 수 있고 일정에 따라 공부계획 수정이 가능하도록 도와준다.

-  달력의 커스텀
  -상단에 현재 달이 표시되고 생 오늘날짜는 숫자가 베이지 색, 선택날짜는 원으로 보여준다.
- 자신의 일정 추가하거나 수정한다.
- 일정이 저장이 되면 Calendar에 새싹모양(dot)으로 표시된다.

![calendar custom](https://user-images.githubusercontent.com/62635984/85451749-2c0e0800-b5d5-11ea-8ccb-5ce39652ea10.JPG)

#### activity_Calendar.xml 
 Custom Calendar를 만들기위해 materialcalendarview를  가져온다.

~~~java
<com.applandeo.materialcalendarview.CalendarView  
  android:id="@+id/calendarView"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent"  
  app:type="one_day_picker"  
  app:headerColor="@color/mainColor"  
  app:selectionColor="@color/colorPrimaryDark"  
  app:todayLabelColor="@color/colorPrimaryDark"  
  app:eventsEnabled="true"/>
~~~
<br>

 build.gradle에 meterialCalendar를  추가한다.
~~~java
android {
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
~~~
~~~java
dependencies {
    implementation 'com.applandeo:material-calendar-view:1.7.0'
}    
~~~
###  
<br>

#### CalendarActivity.java

 변수를 선언한다. 

~~~java
// 선태한 날짜의 일정을 쓰거나 기존에 저자된 일기가 있다면 보여주고 수정하는 영역  
EditText edtDiary;// 선태한 날짜의 일정을 쓰거나 기존에 저자된 일기가 있다면 보여주고 수정하는 영역
Button btnSave; //선택된 날짜의 파일이름  
  
// 선택한 날짜  
int checkYear;  
int checkMonth;  
int checkDay;
~~~
<br>

  뷰에 있는  위젯들을 리턴 받는다.
~~~java
edtDiary=(EditText)findViewById(R.id.edtDairy);  
btnSave=(Button)findViewById(R.id.btnSave);  
CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);  
List<EventDay> events = new ArrayList<>();  
  ~~~
  <br>
  
  오늘 날짜와 현재 선택한 날짜를 받는다.
  ~~~java
// 오늘 날짜 받게하기  
Calendar today= Calendar.getInstance();  
int todayYear=today.get(Calendar.YEAR);  
int todayMonth=today.get(Calendar.MONTH);  
int todayDay=today.get(Calendar.DAY_OF_MONTH);  
  
// 현재 선택한 날짜  
checkYear = todayYear;  
checkMonth = todayMonth;  
checkDay = todayDay;
~~~
<br>

Calendar를 처음 시작할 때 일정이 있으면 ic_sprout(새싹모양)으로 표시해준다.
~~~java
 // 첫시작 할 때 오늘 날짜 일정 읽어주기
checkedDay(todayYear, todayMonth, todayDay);

// 일정데이터가 변경될 때 onDataChange함수 발생 한다.
mFirebaseDatabase.getReference().child("calendar").child(user.getUid()).addValueEventListener(new ValueEventListener () {

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) { 
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
~~~
<br>

선택 날짜가 변경될 때 set OnDayClickListenr가 호출된다.

~~~java
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
~~~
<br>

새 일정 추가하거나 수정하는 버튼을 누르면 setOnClickListener가 호출된다.
~~~java
btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //fileName을 넣고 저장시키는 메소드를 호출
        saveDiary(checkYear + "-" + checkMonth + "-" + checkDay);
    }
});
~~~
<br>

날짜를 선택하면 checkedDay 함수가 호출되고 일정 Database를 읽는다.
~~~java
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
~~~
<br>

일정을 저장할때 saveDiary 메소드가 호출된다.
~~~java
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
~~~
<br>

문자열을 int로 변환한다.
~~~java
//문자열을 int로 변환한다.
private int[] splitDate(String date){
    String[] splitText = date.split("-");
    int[] result_date = {Integer.parseInt(splitText[0]), Integer.parseInt(splitText[1]), Integer.parseInt(splitText[2])};
    return result_date;
}
~~~
## Timetable
사용자가 시간표를 추가하여 설정된 시간에 진동과 벨소리가 작동되며 알람이 울리도록하는 기능이다.
- 시간표를 추가하여 새로운 알람을 등록한다.
- 알람이 설정된 시간이되면 AlarmReceiver가 호출되고 AlarmService를 실행한다.
- 알람을 종료하기 위해 다시 AlarmReceiver를 호출하여 AlarmService를 정지시킨다.

TimeTable은 (링크)TimeTableView, TimeTableActivity, EditActivity, AlarmReceiver, AlarmService 로 나눠서 설명할 것이다.

## TimeTableView
TimeTableView를 사용하기에 앞서 build.gradle(Module:**project**) 파일에 다음을 추가한다.
~~~java
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io'}
    }
}
~~~
> github에서 프로젝트를 Clon or Download 했을 때는 직접 ProjectView를 Project로 변경하면 수정할 수 있습니다.
> ![Projectmodule2](https://user-images.githubusercontent.com/46085058/85412389-7cb93d00-b5a4-11ea-95f1-0d0cf25c5061.png) 

build.gradle(Module:**app**) dependency에 다음을 추가한다.
~~~java
dependencies {
    implementation 'com.github.tlaabs:TimetableView:1.0.3-fx1'
}
~~~
**TimeTableView in Layout.xml**
~~~java
<com.github.tlaabs.timetableview.TimetableView  
    android:id="@+id/timetable"  
    android:layout_width="match_parent"  
    android:layout_height="wrap_content"  
    app:column_count="8"  // 일주일을 표시 
    app:row_count="25"  // 24시를 표시
    app:start_time="0"  // 시작시간을 0으로 표시
    app:header_title="@array/my_header_title"  // header title(요일)을 values/strings.xml에서 받아온다.
    app:header_highlight_color="@color/mainColor"  // 사용자가 별도로 지정한 header색상 변경(ex : 오늘의 요일)
    app:header_highlight_type="color"  // color 또는 image를 지정
  />
~~~
> 더 많은 [TimeTable layout 설정](https://github.com/tlaabs/TimetableView#attribute-descriptions)

 app:header_title 변경
TimeTableView의 header속성을 변경할 수 있습니다.
~~~java
<string-array name="my_header_title">  
   <item></item> <item>Mon</item>  
   <item>Tue</item>  
   <item>Wed</item>  
   <item>Thu</item>  
   <item>Fri</item>  
   <item>Sat</item>  
   <item>Sun</item>  
</string-array>
~~~
> TimeTableViewLayout.xml 
> ~~~java
> app:row_count = "8" // row_count가 item 갯수 보다 1 더 커야 합니다. 
> ~~~

**TimeTableActivity.Java**
TimeTableActivity의 주요 기능은 시간표를 표시하고 알람을 등록해주는 역할을 수행한다.
기존 AlarmManger에 등록된 알람과의 충돌을 방지하기 위해서 기존의 알람을 모두 삭제한 후 재등록 한다.
~~~java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timetable);
    // init firebase
    ...
    // AlarmManger Service
    alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    
    init(); // TimeTableView의 view 객체 및 listener 선언
    checkPictureCount(); // 이미지매칭용 사진이 저장되어있는지 확인
    dayCheckZero(); // TimeTable을 처음 사용할 때 출석 값 0으로 초기화
    
    // addValueEventListener를 선언하여 시간표가 수정될 때마다 Alarm을 갱신 해줍니다.
    mDatabaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
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
~~~
알람을 등록, 수정, 삭제 기능을 수행하기 위해서 EditActivity에서 받아온 data를 활용한다.
받아온 data는 timetable.createSaveData() 를 활용하여 Json형식으로 저장할 수 있습니다.
- Json형식으로 바뀐 data를 Database에 저장한다.
~~~java
@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
        case REQUEST_ADD:
            if (resultCode == EditActivity.RESULT_OK_ADD) {
                ArrayList<Schedule> item = (ArrayList<Schedule>) data.getSerializableExtra("schedules");
                timetable.add(item); // 받아온 Schedule List을 Json 형식으로 저장합니다.
                mDatabaseReference.child("table").setValue(timetable.createSaveData()); // Database에 Json형식으로 저장합니다.
                Toast.makeText(this, "시간표가 추가 되었습니다.", Toast.LENGTH_SHORT).show();
            }
            break;
        case REQUEST_EDIT:
            /** Edit -> Submit */
            if (resultCode == EditActivity.RESULT_OK_EDIT) {
                int idx = data.getIntExtra("idx", -1);
                ArrayList<Schedule> item = (ArrayList<Schedule>) data.getSerializableExtra("schedules");
                timetable.edit(idx, item); // 받아온 data로 idx의 Schedule을 수정합니다.
                mDatabaseReference.child("table").setValue(timetable.createSaveData()); // Database에 Json형식으로 저장합니다.
                Toast.makeText(this, "시간표가 수정 되었습니다.", Toast.LENGTH_SHORT).show();
            }
            /** Edit -> Delete */
            else if (resultCode == EditActivity.RESULT_OK_DELETE) {
                int idx = data.getIntExtra("idx", -1);
                timetable.remove(idx); // 특정 idx의 Schedule을 삭제합니다.
                mDatabaseReference.child("table").setValue(timetable.createSaveData()); // Database에 Json형식으로 저장합니다.
                Toast.makeText(this, "시간표가 삭제 되었습니다.", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }
~~~
> Json형식
> 
> ![Json형식](https://user-images.githubusercontent.com/46085058/85429692-12ab9280-b5ba-11ea-882b-b958e299604f.PNG)

#### Method
출석률을 초기화해주는 메서드(링크)
~~~java
public void dayCheckZero(){...}
~~~
출석체크의 이미지매칭을 위한 등록된 사진갯수를 확인하는 메서드(링크)

~~~java
public void checkPictureCount(){...}
~~~
JsonParsing 후 알람을 등록하는 메서드 ( 알람의 등록과 삭제는 따로 다루도록 한다.) (링크)
~~~java
public void AddAlarm(String json){...}
~~~
> JsonParse 참고 : [https://jang8584.tistory.com/185](https://jang8584.tistory.com/185)
> 

알람을 삭제하는 메서드 ( 알람의 등록과 삭제는 따로 다루도록 한다.) (링크)
~~~java
public void alarmOff(int tmpcount){...}
~~~
#### Alarm등록 및 삭제 
Alarm의 등록 및 삭제는 중요한 몇 가지가 기능을 좌우하기 때문에 별도로 설명하도록 한다.
> AlarmReceiver.class가 있다는 가정하에 설명하겠다.

알람의 object 선언
~~~java
//Alarm object  
private AlarmManager alarmManager;  
private PendingIntent pendingIntent;
~~~
> PendingIntent은 별도의 컴포넌트에게 내가 보내고자하는 intent를 대신 전달하고자 할 때 선언한다.
> 주로 외부에서 Activity, Broadcast, Service를 사용해야 할 때 선언한다.
> 여기에서는 Broadcast 컴포넌트로 다뤄보도록 하겠다.
> 
Pendingintent 설정
~~~java
Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);  
intent.putExtra("weekday", obj3.get("day").getAsInt());  
intent.putExtra("state", "on"); // state 값이 on 이면 알람시작, off 이면 중지, day는 Receiver에서 구분  
intent.putExtra("reqCode", i);  
pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), i, intent, PendingIntent.FLAG_CANCEL_CURRENT);
~~~
> intent에 담아야할 정보들을 Intent.putExtra() 로 담아주고, Broadcast 컴포넌트를 받아온다.
> 이 때 **FLAG**에 주목해야 하는데 FLAG는 Pendingintent의 충돌을 막아주는 아주 중요한 역할을 수행한다.
> - FLAG_CANCEL_UPDATE : 이전에 생성된 pendingintent가 있으면 삭제하고 새롭게 생성한다.
> - FLAG_UPDATE_CURRENT : 이전에 생성된 pedingintent의 내용을 갱신 한다.
> - FLAG_ONE_SHOT : 일회용으로 생성 pendingintent를 단 1회만 사용한다. ( 등록한 위젯이 있다면 1회 클릭 후에는 반응하지 않는다. )
> - FLAG_NO_CREATE : 이미 생성된 것이 있다면 삭제한다.
> 
> Make You Study에서는 알람시간 변경 및 추가가 계속 이루어져야 함으로 FLAG_CANCEL_UPDATE 또는 FLAG_UPDATE_CURRENT를 사용한다.

PendingIntent를 구분하는 **RequestCode** 알람을 판단하는 가장 중요한 부분이라고 할 수 있다.
출석체크를 완료할 때 어떤 알람이 실행되었는지를 판단하고 해당 RequestCode번호의 알람을 삭제하는 역할을 수행하기 때문에 **중복을 피한다**.
~~~java
pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), requestcode, intent, PendingIntent.FLAG_CANCEL_CURRENT);
~~~

AlarmManger 설정
AlarmManger는 Pendingintent를 어느 시점에 실행할지 결정해주는 역할을 수행한다.
~~~java
Calendar calendar = Calendar.getInstance(); // Calendar 객체 생성
calendar.set(Calendar.HOUR_OF_DAY, obj4.get("hour").getAsInt()); // 시간 설정
calendar.set(Calendar.MINUTE, obj4.get("minute").getAsInt());  // 분 설정
calendar.set(Calendar.SECOND, 0); // 초 설정(되도록이면 Default로 0을 둔다.)
~~~
> obj4.get("...").getAsInt() 는 MakeYouStudy의 시간을 불러오는 예제이다. 원하는 시간대로 설정해주면 된다.
> 
시간을 설정했으면 알람을 등록 해주어야 한다.  이때 **API**마다 실행 방식이 다르기 때문에 꼭 아래와 같이 작성해 주어야 한다.
~~~java
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
~~~

**EditActivity.Java**
EditActivity의 주요기능은 시간표를 생성, 수정 및 삭제하는 역할을 수행한다.

EditActivity는 시간표 생성과 수정을 구분하여야 한다. 특히 수정시에는 이미 등록되어있는 시간표의 정보를 불러오는 기능을 수행한다.
~~~java
private void checkMode(){
        Intent i = getIntent();
        mode = i.getIntExtra("mode",TimeTableActivity.REQUEST_ADD);

        if(mode == TimeTableActivity.REQUEST_EDIT){
            loadScheduleData(RESULT_OK_EDIT);
            deleteBtn.setVisibility(View.VISIBLE);
        }else if(mode == TimeTableActivity.REQUEST_ADD){
            loadScheduleData(0);
        }
    }
~~~
EDIT 모드일 때는 받아온 시간표로 View들을 업데이트 시켜주고, ADD모드에서는 현재시간을 등록하여 사용자가 쉽게 시간을 선택할 수 있도록 도와준다.
~~~java
private void loadScheduleData(int mode){
    if(mode == RESULT_OK_EDIT){
        Intent i = getIntent();
        editIdx = i.getIntExtra("idx",-1);
        ArrayList<Schedule> schedules = (ArrayList<Schedule>)i.getSerializableExtra("schedules");
        schedule = schedules.get(0);
        subjectEdit.setText(schedule.getClassTitle());
        classroomEdit.setText(schedule.getClassPlace());
        professorEdit.setText(schedule.getProfessorName());
    }
    daySpinner.setSelection(schedule.getDay());
    startTv.setText(schedule.getStartTime().getHour()+":"+schedule.getStartTime().getMinute());
    endTv.setText(schedule.getEndTime().getHour()+":"+schedule.getEndTime().getMinute());
}
~~~
설정한 시간을 schedule에 담아준다.
~~~java
private void inputDataProcessing(){
    schedule.setClassTitle(subjectEdit.getText().toString());
    schedule.setClassPlace(classroomEdit.getText().toString());
    schedule.setProfessorName(professorEdit.getText().toString());
}
~~~
>  [Schedule.set...()](https://github.com/tlaabs/TimetableView#add-schdule)
#### Method
EditActivity View object 초기화
~~~java
public void init(){...}
~~~
EditActivity View Listener 초기화
~~~java
private void initView(){...}
~~~
TimeTableActivity로 생성, 수정 및 삭제를 구별하여 intent를 전송하는 onClick listener()
~~~java
@Override public void onClick(View v) {...}
~~~

**AlarmReceiver.Java**
AlarmReceiver는 Alarm Broadcast Message를 수신하는 역할을 수행한다.

**AlarmReceiver.Java 생성**
AlarmReceiver는 Broadcast를 수신하기 위해서 새로운 Java파일을 생성할 때 BroadcastReceiver를 extends해야 한다.
![Creat_AlarmReceiver](https://user-images.githubusercontent.com/46085058/85443237-fb75a080-b5cb-11ea-8766-094b58e3bd87.png)
![extends_AlarmReceiver](https://user-images.githubusercontent.com/46085058/85443431-38da2e00-b5cc-11ea-98a4-b99fe66d631a.png)
BroadcastReceiver를 extends하였기 때문에 onReceive() 를 선언 해주어야한다.
![onReceiver_AlarmReceiver](https://user-images.githubusercontent.com/46085058/85444017-dcc3d980-b5cc-11ea-8a02-d19132dd9307.png)
intent의 state값을 받아오고 "off", "on"은 알람을 끄거나 켤 때 사용하는 state이고  "reset"은  media를 조절하기 위해 별도로 만든 state이다.
weeks는 해당 요일을 구별하여 오늘의 요일이 맞지않으면 알람을 실행하지 않는다.
각 state를 구별한 후에 Service를 호출한다. (Android Oreo 이상 부터는 foreground로 실행하여야 한다.)
~~~java
public class AlarmReceiver extends BroadcastReceiver {
    static String TAG="AlarmReceiver";

    ...PowerManger

    @Override
    public void onReceive(Context context, Intent intent) {
        ...
        // intent에 담겨져있는 값들을 받아온다.
        int weeks = intent.getIntExtra("weekday", -1);
        int reqCode = intent.getIntExtra("reqCode", -1);
        String state = intent.getStringExtra("state");
        
        Intent sIntent = new Intent(context, AlarmService.class); // Service로 보낼 intent

        if(state.equals("off")){ // 알람을 종료하는 state
            sIntent.putExtra("state", "off");
            sIntent.putExtra("reqCode", reqCode);
            // Oreo(26) 버전 이후부터는 Background 에서 실행을 금지하기 때문에 Foreground 에서 실행해야 함
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(sIntent);
            } else {
                context.startService(sIntent);
            }
            return;
        }
        else if(state.equals("reset")){ // Service의 Media컨트롤을 위한 state
            Log.d(TAG, "reset " + reqCode + " 가 해제 되었습니다.");
        }
        else if(weeks != nweeks){ // 오늘이 설정한 요일이 아닐 때 아무것도 수행하지 않음
            return;
        }
        else if(weeks == nweeks) { // 오늘이 설정한 요일 일 때 알람이 울림
            sIntent.putExtra("state", "on");
            sIntent.putExtra("weekday", weeks);
            // Oreo(26) 버전 이후부터는 Background 에서 실행을 금지하기 때문에 Foreground 에서 실행해야 함
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(sIntent);
            } else {
                context.startService(sIntent);
            }
            
            ...PowerManger
            
            try { // 오늘이 설정한 요일일 때 출석체크 액티비티를 실행해준다.
                Intent intent2 = new Intent(context, AttendanceCheckActivity.class);
                intent2.putExtra("reqCode", reqCode);
                intent2.putExtra("weekday", weeks);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent2, PendingIntent.FLAG_CANCEL_CURRENT);
                pendingIntent.send();

            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
            
            ...PowerManger
            
            }
        }
    }
}
~~~
알람이 해당하는 요일과 일치하여 알람이 울려야할 때 사용자의 화면을 깨워준다.
이는 절전모드 상태에서 CPU자원을 획득하기 때문에 필히 Release 해주어야한다.

~~~java
// PowerManger.WakeLock object
private static PowerManager.WakeLock sCpuWakeLock;  
private static ConnectivityManager manger;

@Override
public void onReceive(Context context, Intent intent) {
        ...Alarm
        // 절전모드에서도 액티비티를 띄울 수 있도록 함
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        sCpuWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE, "app:alarm");
        // acquire 함수를 실행하여 앱을 깨운다. (CPU를 획득함)
        sCpuWakeLock.acquire();
        manger = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        ...Alarm
        // acquire 함수를 사용하였으면 꼭 release를 해주어야 한다.
        // cpu를 점유하게 되어 배터리 소모나 메모리 소모에 영향을 미칠 수 있다.
        if (sCpuWakeLock != null) {
            sCpuWakeLock.release();
            sCpuWakeLock = null;
        }
    }
}
~~~
##  AlarmService.Java
정해진 시간에 알람이 울렸을 때 Service를 통하여 Vibrator와 Media를 재생할 수 있도록 해준다.

**AlarmService.java 생성**
AlarmService는 새로운 Java파일을 생성할 때 Service를 extends해야 한다.
![Create_Service](https://user-images.githubusercontent.com/46085058/85454120-8d36db00-b5d7-11ea-80e9-3dc31e2bb292.png)

처음 Service를 extends한 Java파일을 생성하게되면 오류가 뜨는데 아래와 같이 `onBind()`와 `onStartCommand()` 를 선언해주어야 한다.
~~~java
public class AlarmService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {return null;}
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
~~~

`onStartCommand()`는 Service가 호출되었을 때 실행된다.
AlarmService에서는 주로 `MediaPlayer()`의 재생, 중지 및 정지와, `Vibrate()`의 재생 및 정지를 수행하고 추가로 Android Oreo버전 이상부터는 foreground실행을 위해 notificationchannel을 띄워주는 역할을 수행한다.
~~~java
public class AlarmService extends Service {

    private MediaPlayer mediaPlayer;
    private Vibrator vibrator;
    private boolean isRunning;
    private int pausePosition; // mediaPlayer pause 시점 저장

    @Nullable
    @Override
    public IBinder onBind(Intent intent) { return null; }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE); // System에서 Vibrater Service를 받아온다.
      // intent값을 받아온다.
        String state = intent.getStringExtra("state");
        int reqCode = intent.getIntExtra("reqCode", -1);
        int weeks = intent.getIntExtra("weekday", -1);

        if (state.equals("on")) {
            // 알람음 재생 OFF, 알람음 시작 상태
            this.mediaPlayer = MediaPlayer.create(this, R.raw.alarm); // 재생할 음악을 정한다.
            this.mediaPlayer.start(); // 음악을 재생
            this.vibrator.vibrate(new long[]{500, 1000, 500, 1000}, 0); // 진동 재생

            this.isRunning = true;

            // notification 클릭시에도 출석체크를 할 수 있도록 액티비티를 실행
            Intent intent1 = new Intent(getApplicationContext(), AttendanceCheckActivity.class);
            intent1.putExtra("reqCode", reqCode);
            intent1.putExtra("weekday", weeks);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent1, PendingIntent.FLAG_CANCEL_CURRENT);

            // Oreo(26) 버전 이후 버전부터는 notificationchannel 이 필요함
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                
                String channelId =  createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
                Notification notification = builder.setOngoing(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pendingIntent) 
                        .build();
                startForeground(1, notification);
            }
        } else if (this.isRunning && state.equals("off")) {
            // 알람음 재생 ON, 알람음 중지 상태
            this.mediaPlayer.stop(); // 음악을 정지
            this.mediaPlayer.reset(); // mediaPlayer를 리셋
            this.mediaPlayer.release(); // mediaPlayer 해제
            this.vibrator.cancel(); // 진동 정지

            this.isRunning = false;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                stopForeground(true); // 실행중인 foreground 정지
            }
        } else if (state.equals("pause")){
            // AttendanceCheck시에 음악 일시 정지
            if(mediaPlayer!=null){
                this.mediaPlayer.pause(); // 음악을 일시정지
                pausePosition = mediaPlayer.getCurrentPosition(); // 음악의 일시정지 타이밍을 저장
                this.vibrator.cancel();
            }
        } else if (state.equals("restart")){
            if(!mediaPlayer.isPlaying()){
                mediaPlayer.seekTo(pausePosition); // 음악이 일시정지된 타이밍을 찾음
                mediaPlayer.start();
                this.vibrator.vibrate(new long[]{500, 1000, 500, 1000}, 0);
            }
        }
        return START_NOT_STICKY;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private String createNotificationChannel() {
        String channelId = "Alarm";
        String channelName = getString(R.string.app_name);

        NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_NONE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        channel.setSound(null, null);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        manager.createNotificationChannel(channel);

        return channelId;
    }
}
~~~
> 참고자료 : [`MediaPlayer()`]([https://developer.android.com/guide/topics/media/mediaplayer?hl=ko](https://developer.android.com/guide/topics/media/mediaplayer?hl=ko)), [`Vibrator()`]([https://developer88.tistory.com/103](https://developer88.tistory.com/103)), [`NotificationChannel`]([https://developer.android.com/training/notify-user/channels?hl=ko](https://developer.android.com/training/notify-user/channels?hl=ko))
## Diary
## 다이어리

 다이어리 기능은 자신의 하루 일과를 적으면서 마무리 할 수 있게 도와주는 기능이다.
 목록보기 칸에서는 자신의 작성한 일기의 수정 및 삭제를 할 수 있다.
 연필 모양 버튼을 클릭 시, 다이어리를 작성할 수 있는 화면이 나오고 제목과 내용을 작성하면 저장버튼이 실행될 수 있게 변한다. 내용을 입력하고 저장버튼을 누르면 눈 모양의 버튼을 클릭하면 자신이 적었던 목록들을 확인할 수 있다.
  - 다이어리 작성칸에서 글을 작성하고 저장하면 목록보기 창에서 본인이 적었던 날짜와 시간과 함께 확인할 수 있다.
  -  아래 사진은 다이어리 실행 화면이다.
 ![image](https://user-images.githubusercontent.com/62636101/85469611-db080f00-b5e8-11ea-9728-943e5b9d7a5b.png)

##  다이어리 작성 , 저장, 목록보기

### DiaryActivity.java
 다이어리에 글을 작성하고 저장버튼을 누르면 파이어베이스에 저장되면서, 내용을 수정 및 삭제할 수 있는 Activity이다. 
작성 칸에는 제목을 적을 수 있는 칸, 내용을 적을 수 있는 칸 그리고 저장 버튼이 있다.


#### save_btn 설정
- 저장버튼에는 파이어베이스에 같은 시간 동시 저장을 막기 위한 save_btn 1초의 딜레이가 걸려져 있다.
- edit_title과 edit_content가 비었을시 저장버튼이 실행되지 않는다.
 ~~~java
 //save 버튼 클릭 시 1초 동안 딜레이 발생
    save_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save_btn.setEnabled(false);
            // btn disabled 1sec
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    save_btn.setEnabled(true);
                }
            }, 1000);

            //edit_title과 edit_contents가 비었을시 DB에 삽입 불가
            if(edit_title.getText().toString().getBytes().length<=0 && edit_contents.getText().toString().getBytes().length<=0)
            {

            }else {
                InsertDB();
            }
        }
    }
~~~


#### 작성한 일기내용 파이어베이스에 저장

- 데이터베이스에 저장을 위한 InsertDB 메소드이다.
- 파이어베이스에 edit_title과 edit_contents, writeTime을 저장한다.
~~~java
-  public static void InsertDB() {
    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
    String writeTime = sdf.format(date);
    // Firebase에 edit_title, edit_contents, writeTime 저장
    mDatabaseReference = mFirebaseDatabase.getReference().child("diary").child(user.getUid()).child(writeTime);
    mDatabaseReference.setValue(edit_title.getText()+ " / " +  edit_contents.getText());
    edit_title.setText("");
    edit_contents.setText("");
        }
~~~

<br>


#### 목록보기 칸에는 작성한 다이어리를 볼 수 있다. 저장된 다이어리를 얼만큼 클릭하는지에 따라서 다른 이벤트가 발생한다.
#### 버튼을 짧게 클릭 시
- setOnItemClickLinstener를 사용해 다이어리 리스트 중 한개를 클릭시 Intent를 이용해 Diary_update로 화면을 전환된다.
~~~java
list_diary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getContext(), Diary_Update.class);
        intent.putExtra("date", data.get(position).getDate());
        intent.putExtra("title", data.get(position).getTitle());
        intent.putExtra("contents", data.get(position).getContents());
        startActivity(intent);
    }
}
~~~

#### 버튼을 길게 누를 시
- setOnItemLongClickListener를 사용해 다이어리 리스트 중 한개를 ***길게*** 클릭 시 AlertDialog를 띄운다.
~~~java
list_diary.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setMessage(data.get(position).getTitle() + "을(를) 삭제하시겠습니까?");
        alertDialog.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String code = data.get(position).getDate();
                deleteDB(code);
                showDB();
            }
        });
        alertDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
        return true;
    }
}
~~~
<Br>
<Br>

#### 다이어리 목록에는 작성한 순번, 제목, 내용, 작성시간 추가가 필요하다 

#### 일기  목록 보기 메소드
-  data에 본인의 일기(순번, 제목, 내용, 작성날짜) 추가 
~~~java
public static ArrayList<Diary> showDB() {
    mDatabaseReference = mFirebaseDatabase.getReference().child("diary").child(user.getUid());
    if (mDatabaseReference != null) {
        mFirebaseDatabase.getReference().child("diary").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                data.clear();
                list_diary.setAdapter(listAdapter);
                int code = 1;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String[] fbData = splitData(snapshot.getValue().toString());
                    Diary diary = new Diary();
                    diary.setCode(code);
                    diary.setTitle(fbData[0]);
                    diary.setContents(fbData[1]);
                    diary.setDate(snapshot.getKey());
                    data.add(diary);
                    code += 1;
                }
                list_diary.setAdapter(listAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        return data;
    } else {
        return null;
    }
}
~~~

#### 목록창에서 다이어리를 길게 클릭 시 삭제할 수 있는 기능이 있다.
 - deleteDB 메소드이다.
~~~java
public static void deleteDB(String date) {
    mFirebaseDatabase.getReference().child("diary").child(user.getUid()).child(date).setValue(null);
}
~~~
<br>

## 목록보기에서의 다이어리 수정 
***Diary_Update.java***
본인이 작성했던 일기들을 확인할 수 있는 목록창이 있다. 작성했던 리스트 중 한개를 클릭하면 내용을 수정할 수 있는 창이 나온다. 여기에서는 저장, 돌아가기 두 가지의 버튼이 있다.

- findViewById 선언
~~~java
editText1 = (EditText)findViewById(R.id.edit_title_update);
editText2 = (EditText)findViewById(R.id.edit_contents_update);
btn1 = (Button)findViewById(R.id.save_btn_update);
btn2 = (Button)findViewById(R.id.return_btn_update);
~~~
- 아래는 btn1과 btn2의 onClickListener이다.
~~~java
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        updateDB(date);
        finish();
    }
});
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
~~~
## 다이어리 페이지 변환
***Tab_pager_Adapter.java***

작성창과 목록보기창을 페이지변환을 통해서 볼 수 있다.
~~~java
public Fragment getItem(int position) {
   switch (position) {
       case 0:
           DiaryActivity.Diary_Write diaryWrite = new DiaryActivity.Diary_Write();
           return diaryWrite;
       case 1:
           DiaryActivity.Diary_List diaryList = new DiaryActivity.Diary_List();
           return diaryList;
       default:
           return null;
   }
}
~~~
## 디자인 구성을 위한 build.gradle 추가
~~~java
// Diary  
implementation 'com.android.support:design:29.0.0'
~~~
## Attendance Check & Attendance Rate

## Attendance Check

출석체크 기능은 공부를 하기 위해 책상에 앉을 수 있도록 도와주는 기능이다. <br>
Time Table에서 시간표를 설정한 후 지정한 시간에 알람이 울리면 출석체크를 실행한다.<br>
출석체크 방법에는 세 가지가 있다.
- firebase ML Kit를 이용한 사물(책상)인식
- firebase ML Kit를 이용한 Text 인식 
- OpenCV를 이용한 Color Histogram Image Matching

우선, firebase ML Kit와 openCV를 사용하기 위해 (2번)내용을 수행해야 한다.


## 출석체크 방법 선택 

**AttendanceCheckActivity.java**

알람이 울릴 때, 어떤 방식으로 출석체크를 할지 선택하면서, 선택한 방식으로 출석체크 후 출석과 결석을 판단해주는 Activity이다.<br>
총 네 가지의 button이 존재한다.

- button을 클릭하면 해당 Activity로 이동하여 출석체크 하는 동안 알람이 일시정지된다. 

아래는 각 button들의 `onClickListener()`이다.
~~~java
btnCheck = (Button)findViewById(R.id.btnCheck);
btnCheck.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mediaPause();
        startActivityForResult(new Intent(getApplicationContext(), ImageLabelActivity.class), LABEL_ACTIVITY);
    }
});

btnTextCheck = (Button)findViewById(R.id.btnTextCheck);
btnTextCheck.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mediaPause();
        textRecognition();
    }
});

btnSkip = (Button)findViewById(R.id.btnSkip);
btnSkip.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mediaPause();
        dialogSkip();
    }
});

btnOpencv = (Button)findViewById(R.id.btnOpencv);
btnOpencv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mediaPause();
        startActivityForResult(new Intent(getApplicationContext(), ImageMatchingActivity.class), IMAGE_MATCHING_ACTIVITY);
    }
});
}
~~~

랜덤으로 하나의 영어단어를 함께 넘겨주기위해 `String.xml` 에 영어단어 10가지를 추가하여 배열에 넣어주었다.
~~~java
randomText = getResources().getStringArray(R.array.random_text);  
rnd = new Random();
~~~

>String.xml
>~~~java
><string-array name="random_text">  
> <item>passion</item>  
> <item>wish</item>  
> <item>aspiration</item>  
> <item>peace</item>  
> <item>blossom</item>  
> <item>sunshine</item>  
> <item>cherish</item>  
> <item>smile</item>  
> <item>family</item>  
> <item>rainbow</item>  
></string-array>
>~~~

Text 인식을 이용한 출석체크 버튼을 눌렀을 경우 실행되는 `textRecognition()` method 이다.<br>
랜덤으로 randomText배열에 들어가 있는 영어단어 하나를 함께 **TextRecognitionActivity**로 보내준다. 
~~~java
public void textRecognition(){  
   Intent intent = new Intent(this, TextRecognitionActivity.class );  
   int num = rnd.nextInt(9);  
   intent.putExtra("English", randomText[num]);  
  
   startActivityForResult(intent, TEXT_ACTIVITY);  
}
~~~

Skip button을 제외한 각 버튼들을 클릭하면, `startActivityForResult()`를 통해 Activity마다 다른 requestCode와 함께 해당 Activity로 넘겨준다. 아래는 각 Activity의 requestCode를 정의해준 것이다.
~~~java
// 출석체크시 Activity 구분을 위한 requestCode  
final int LABEL_ACTIVITY = 1;  //사물 인식 Activity
final int TEXT_ACTIVITY = 2;  //Text 인식 Activity
final int IMAGE_MATCHING_ACTIVITY = 3; // Image Matching Activity
~~~


`startActivityForResult()`를 사용하여 다른 Activity를 실행해줬을 경우, `onActivityResult()`를 통해 Activity의 결과를 가져와 출석체크 출결여부를 결정한다.<br>
Activity의 구분은 위에서 함께 넘겨준 requestCode로 구분할 수 있다.

- 출석체크 완료 시, 출석 count를 증가시키고 알람과 Activity를 꺼준다.
- 출석체크 실패 시, 출석체크를 다시 수행할 수 있게 일시정지 되었던 알람이 다시 울린다. 
~~~java
@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    switch (requestCode) {
        case LABEL_ACTIVITY:

        String label = data.getStringExtra("labeling");

        if(label.equals("Desk") || label.equals("Table") ){
            Toast.makeText(this, "Label 출석체크 완료 : "+label, Toast.LENGTH_SHORT).show();
            alarmOff();
            checkDaysTotal(weeks);
            Log.d(TAG, "실행");
            finish();
        }
        else if(label.equals("BackPressed")){
            Toast.makeText(this, "Label 출석체크 취소", Toast.LENGTH_SHORT).show();
            mediaRestart();
        }
        else {
            Toast.makeText(this, "출석체크 실패 : "+label, Toast.LENGTH_SHORT).show();
            count++;
            mediaRestart();
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
            alarmOff();
            checkDaysTotal(weeks);
            finish();
        } else {
            Toast.makeText(this, "Text 출석체크 취소", Toast.LENGTH_SHORT).show();
            mediaRestart();
        }
        break;
    case IMAGE_MATCHING_ACTIVITY :
        boolean checkMatching = data.getBooleanExtra("checkMatching", false);
        if(checkMatching == true){
            Toast.makeText(this, "ImageMatching 출석체크 완료", Toast.LENGTH_SHORT).show();
            alarmOff();
            checkDaysTotal(weeks);
            finish();
        }else {
            Toast.makeText(this, "ImageMatching 출석체크 취소", Toast.LENGTH_SHORT).show();
            mediaRestart();
        }
    }
}
~~~
Skip button을 클릭시 수행되는 `dialogSkip()` method이다.<br>
AlertDialog를 띄워 출석 여부를 고를 수 있다.
~~~java
public void dialogSkip(){
    activity = this;
    AlertDialog.Builder alertdialog = new AlertDialog.Builder(activity);
    alertdialog.setMessage("출석여부를 고르세요.");

    // 확인버튼 - 결석
    alertdialog.setPositiveButton("결석", new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int which) {
       Toast.makeText(activity, "결석처리 되었습니다.", Toast.LENGTH_SHORT).show();
       alarmOff();
       finish();
        }
    });
    // 취소버튼
    alertdialog.setNegativeButton("출석", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
       Toast.makeText(activity, "출석처리 되었습니다.", Toast.LENGTH_SHORT).show();
       alarmOff();
       checkDaysTotal(weeks);
       finish();
        }
    });
    alertdialog.setNeutralButton("취소", new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int id)
        {
       Toast.makeText(activity, "'취소'버튼을 누르셨습니다.", Toast.LENGTH_SHORT).show();
       mediaRestart();
        }
    });
    AlertDialog alert = alertdialog.create();
    alert.setTitle("Skip");
    alert.show();
}
~~~
>[AttendanceCheckActivity.java 전체 코드](https://github.com/JJinTae/MakeYouStudy/blob/master/app/src/main/java/com/android/MakeYouStudy/AttendanceCheckActivity.java)

## Firebase ML Kit를 이용한 출석체크 

Firebase ML Kit를 이용한 출석체크 기능으로는 **사물인식 (Image Labeling)**, **Text 인식 (Text Recognition)** 이 있다. 
- Firebase ML Kit를 사용하기 위해서는 아래와 같이 `build.gradle`에 정의해주어야 한다.

**build.gradle (:app)**
~~~java
implementation 'com.google.firebase:firebase-core:17.4.2'  
implementation 'com.google.firebase:firebase-ml-vision:24.0.0'  
~~~



**InternetCheck.java**<br>
인터넷 여부를 체크하기 위해 인터넷을 체크하는 Activity를 추가한다.
~~~java
public class InternetCheck extends AsyncTask<Void,Void,Boolean> {

    Consumer consumer;

    public InternetCheck(Consumer consumer){
        this.consumer = consumer;
        execute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try{
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("google.com",80),1500);
            socket.close();
            return true;
        }catch (Exception e){
            return false;
        }


    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        consumer.accept(aBoolean);
    }

    public interface Consumer {
        void accept(boolean internet);
    }
}
~~~
***
### 사물 인식 (Image Labeling)
- 카메라로 책상을 촬영하여, 책상이 인식되면 출석체크가 완료된다.
- 사물인식 (Image Labeling) 기능을 사용할 때, 보다 안정적이고 빠르게 촬영 후 Detect하기 위해 CameraKit를 사용하였다.
- 촬영한 사진의 Label 값을 AttendanceCheckActivity로 전달한다.

>사물 인식을 통한 출석체크가 수행되는 과정
>1. **AttendanceCheckActivity**에서 사물 인식 기능 button을 클릭하여 **ImageLabelActivity**로 이동한다.
>2. **ImageLabelActivity**에서 cameraView를 통해 책상을 촬영한다.
>3. 촬영된 image에서 설정한 ConfidenceThreshold 값 이상인 Label중 가장 높은 Confidence를 가진 Label을 반환한다.
>4. **ImageLabelActivity**가 종료되면서 반환된 Label을 **AttendanceCheckActivity**로 넘겨준다.
>5. **AttendanceCheckActivity**에서 Label 값이 책상이 맞는지 확인한다. 
 
 Firebase ML Kit의 Image Labeling를 사용하기 위해 아래와 같이 `build.gradle`에 정의해주어야 한다.

**build.gradle (:app)**
~~~java
implementation 'com.google.firebase:firebase-ml-vision-image-label-model:19.0.0' 
~~~
>[Firebase MK Kit Image Labeling 설명 바로가기](https://firebase.google.com/docs/ml-kit/android/label-images)

CameraKit를 사용하기 위해 아래와 같이 `build.gradle`에  정의해주어야 한다.

**build.gradle (:app)**
~~~java
implementation 'com.wonderkiln:camerakit:0.13.1'
~~~
>[CameraKit github 바로가기](https://github.com/CameraKit/camerakit-android)


**ImageLabelActivity.java**
- ImageLabelActivity.java는 cameraKit의 cameraView와 Detect를 수행하는 Button을 사용한다.

>activity_image_label.xml
cameraKit의 cameraView를 사용하기 위하여 아래와 같이 layout에 추가한다.
>~~~java
><com.wonderkiln.camerakit.CameraView  
>  android:id="@+id/camera_view"  
>  android:layout_width="match_parent"  
>  android:layout_height="match_parent"  
>  android:layout_above="@+id/btn_detect">
></com.wonderkiln.camerakit.CameraView>
>~~~
아래 코드는 Detect button의 `onClickListener`이다. button을 클릭하면 cameraView가 실행되고 촬영된다.
~~~java
btnDetect.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
   cameraView.start();
   cameraView.captureImage();
    }
});
~~~

`CameraKitListener()` 부분이다. cameraView에 바로 camera를 띄워 촬영한다.
~~~java
cameraView.addCameraKitListener(new CameraKitEventListener() {
    @Override
    public void onEvent(CameraKitEvent cameraKitEvent) { }

    @Override
    public void onError(CameraKitError cameraKitError) { }

    @Override
    public void onImage(CameraKitImage cameraKitImage) {
   waitingDialog.show();
   Bitmap bitmap = cameraKitImage.getBitmap();
   bitmap = Bitmap.createScaledBitmap(bitmap,cameraView.getWidth(),cameraView.getHeight(), false);
   cameraView.stop();

   runDetector(bitmap);
    }

    @Override
    public void onVideo(CameraKitVideo cameraKitVideo) { }
});
~~~
위의 `CameraKitListener()`에서 사용한 `runDetector()` method이다.<br>
아까 만들어준 InternetCheck.java 를 통해 인터넷을 체크한 후 , image에서 사물 인식 confidenceThreshold를 설정해준다.<br>
설정한 confidenceThreshold의 값보다 높은 값을 가지는 Label이 반환한다.
~~~java
private void runDetector(Bitmap bitmap) {
    final FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);

    new InternetCheck(new InternetCheck.Consumer() {
        @Override
        public void accept(boolean internet) {
       if(internet)
       {
      //인터넷이 있을 때 클라우드 사용
      FirebaseVisionCloudImageLabelerOptions options =
         new FirebaseVisionCloudImageLabelerOptions.Builder()
            .setConfidenceThreshold(0.7f) // 감지된 Label의 신뢰도 설정. 이 값보다 높은 신뢰도의 label만 반환됨
            .build();
      FirebaseVisionImageLabeler detector =
         FirebaseVision.getInstance().getCloudImageLabeler(options);

      detector.processImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionImageLabel>>() {
               @Override
               public void onSuccess(List<FirebaseVisionImageLabel> firebaseVisionCloudLabels) {
                   processDataResultCloud(firebaseVisionCloudLabels);
               }
                })
                .addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception e) { Log.d("EDMTERROR", e.getMessage()); }
      });

       }
       else
       {
           Toast.makeText(ImageLabelActivity.this, "인터넷을 체크하고 다시 촬영해주세요.", Toast.LENGTH_LONG).show();
           ...
       }
        }
    });
}

~~~
위의 `runDetector()` 에서 사용한 `processDataResultCloud()` method 이다.<br>
`runDetector()`에서 인식한 Label을 넘겨받아 Label 값이 존재할 경우 AttendanceCheckActivity로 Label 값을 넘겨주면서 ImageLabelActivity를 종료한다.
~~~java
private void processDataResultCloud(List<FirebaseVisionImageLabel> firebaseVisionCloudLabels) {
    if(firebaseVisionCloudLabels.size()!=0){
        for(FirebaseVisionImageLabel label : firebaseVisionCloudLabels)
        {
            String labeling = label.getText();

            Intent intent = new Intent();
            intent.putExtra("labeling", labeling);

            setResult(RESULT_OK, intent);
            finish();
        }
    }
    else{
        Intent intent = new Intent();
        intent.putExtra("labeling", "NULL");

        setResult(RESULT_OK, intent);
        finish();
    }
    ...
}
~~~
>[ImageLabelActivity.java 전체 코드](https://github.com/JJinTae/MakeYouStudy/blob/master/app/src/main/java/com/android/MakeYouStudy/ImageLabelActivity.java)
***

### Text 인식 (Text Recognition)

- 제시된 영어단어를 노트에 따라 적고 촬영하여 두 개의 단어가 일치하면 출석체크가 완료된다.
- 출석체크 완료 시, true 값을 AttendanceCheckActivity에 전달한다.
- 출석체크 실패 시, 재촬영을 요구하는 text를 띄워준다.

>Text 인식을 통한 출석체크가 수행되는 과정
>1. **AttendanceCheckActivity**에서 하나의 영어단어를 랜덤으로 **TextRecognitionActivity**로 이동하면서 넘겨준다.
>2. **TextRecognitionActivity**에서 제시된 영어단어를 노트에 따라 적고 촬영한다.
>3. 촬영된 image에서 단어를 인식하고, 인식된 단어와 제시된 영어단어를 비교하여 같을 시에 true값을 반환한다.
>4. **TextRecognitionActivity**가 종료되면서 반환된 true 값을 **AttendanceCheckActivity**에 전달한다. 
   ( 제시된 영어단어와 같지 않을 시에는 Activity가 종료되지 않으며, 재촬영을 요구하는 text를 띄워준다.)
>5. **AttendanceCheckActivity**에서 ture 값을 받았을 경우 출석체크가 완료된다.

AttendanceCheckActivity에서 전달받은 영어 단어를 textView에 표시해준다.
~~~java
Intent intent = getIntent();  
data = intent.getStringExtra("English");  
textView.setText("똑같이 작성해주세요 : "+ data + "\n");
~~~
사진 촬영 button의 `onClickListener`이다. 
~~~java
captureImageBtn.setOnClickListener(new View.OnClickListener() {  
    @Override  
    public void onClick(View v) {  
        dispatchTakePictureIntent();  
    }  
});
~~~
사진 촬영 button을 눌렀을 경우 실행되는 method이다. 카메라를 실행시켜준다.
~~~java
private void dispatchTakePictureIntent() {  
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {  
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);  
    }  
}
~~~
카메라로 촬영한 후에 실행되는 method이다.<br>
image를 Bitmap으로 저장하고 imageView에 촬영된 사진을 보여준 후, `detectTextFromImage()` method를 실행한다.
~~~java
@Override  
protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
    super.onActivityResult(requestCode, resultCode, data);  
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {  
        Bundle extras = data.getExtras();  
        imageBitmap = (Bitmap) extras.get("data");  
        imageView.setImageBitmap(imageBitmap);  
        detectTextFromImage();  
    }  
}
~~~
>Firebase ML Kit에 대한 method 설명은 아래 링크를 참고하면서 보면 도움이 될 것이다. <br>
>[Firebase ML Kit Text Recognition 설명 바로가기](https://firebase.google.com/docs/ml-kit/android/recognize-text)

위의 카메라로 촬영한 후에 실행되는 method에서의 `detectTextFromImage()` method이다.<br>
인터넷이 연결되어 있을 때, 촬영된 image에서 Text를 인식하고 성공했을 시에  [`FirebaseVisionText`](https://firebase.google.com/docs/reference/android/com/google/firebase/ml/vision/text/FirebaseVisionText) 객체가 성공 리스너에 전달된다.<br>
 
`displayTextFromImage()` method에 `FirebaseVisionText` 객체를 파라미터로 전달하여 실행한다.
> `FirebaseVisionText` 객체는 이미지에서 인식된 전체 텍스트 및 0개 이상의 [`TextBlock`](https://firebase.google.com/docs/reference/android/com/google/firebase/ml/vision/text/FirebaseVisionText.TextBlock) 객체를 포함한다.
~~~java
private void detectTextFromImage()
{
    new InternetCheck(new InternetCheck.Consumer() {
        @Override
        public void accept(boolean internet) {
            if(internet){
                FirebaseVisionImage firebaseVisionImage = FirebaseVisionImage.fromBitmap(imageBitmap);
                FirebaseVisionTextRecognizer firebaseVisionTextDetector = FirebaseVision.getInstance().getOnDeviceTextRecognizer();
                firebaseVisionTextDetector.processImage(firebaseVisionImage).addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                    @Override
                    public void onSuccess(FirebaseVisionText firebaseVisionText) {
                        displayTextFromImage(firebaseVisionText);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(TextRecognitionActivity.this, "Error: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                Toast.makeText(TextRecognitionActivity.this, "인터넷을 체크하고 다시 촬영해주세요.", Toast.LENGTH_LONG).show();
            }
        }
    });
}
~~~
`TextBlock` 를 List에 넣어주고, List의 size가 0일 때는 image에서 Text가 인식되지 않은 것이기 때문에 textView에 재촬영을 요구하는 글을 표시한다.<br>
Text가 인식된 경우에는 Text와 AttendanceCheckActivity에서 전달받은 단어를 `check()` method의 파라미터로 전달하여 실행한다. 
~~~java
private void displayTextFromImage(FirebaseVisionText firebaseVisionText) {
    List<FirebaseVisionText.TextBlock> blockList = firebaseVisionText.getTextBlocks();
    if(blockList.size() == 0){
        textView2.setText("사진에서 단어가 인식되지 않았습니다. 다시 촬영해주세요.");
    }
    else {
        String text = "";
        for(FirebaseVisionText.TextBlock block : firebaseVisionText.getTextBlocks())
        {
            text = block.getText().toLowerCase();
            check(text, data);
        }
    }
}
~~~
제시된 단어와 촬영하여 인식된 단어가 같은지 확인하는 `check()` method이다.<br>
두 단어가 일치할 시, 현재 Activity가 종료되면서 **AttendanceCheckActivity**로 true값을 전달한다.
~~~java
public void check(String text, String data){  
    if(text.equals(data)){  
        checkValue = true;  
   Intent intent = new Intent();  
   intent.putExtra("checkValue", checkValue);  
   setResult(RESULT_OK, intent);  
   finish();  
    }  
    else {  
        checkValue = false;  
   textView2.setText("인식된 단어는 " + text);  
    }  
}
~~~
>[TextRecognitionActivity.java 전체 코드](https://github.com/JJinTae/MakeYouStudy/blob/master/app/src/main/java/com/android/MakeYouStudy/TextRecognitionActivity.java)

## OpenCV를 이용한 출석체크

OpenCV를 이용한 출석체크를 하기위해서는, 미리 등록된 5장의 책상 사진이 존재해야한다.<br>
Profile에서 5장의 책상사진을 업로드하면 이 기능을 사용할 수 있다.
- OpenCV의 Color Histogram을 이용하여 두 장의 Image를 비교하는 기능을 구현하였다. 
- Color Histogram은 조명에 영향을 받을 수 있기 때문에 여러 장의 사진을 등록하여 비교한다.
- 등록한 사진과 같은 책상 사진을 찍었지만 출석체크가 되지 않은 경우에는 빛에 의해 사진의 밝기가 변화가 생겼기 때문일 수있다.
- 이러한 문제를 개선하기 위해, 출석체크에 실패했을 경우 해당 사진을 등록하는 책상 사진으로 추가할 수 있다.

>[OpenCV Histogram Compare 설명](https://docs.opencv.org/master/d8/dc8/tutorial_histogram_comparison.html)

>Color Histogram를 통한 출석체크가 수행되는 과정
>1. Profile (설정)에서 5장의 책상 사진을 미리 등록한다.
>2. 등록해놓은 책상 사진과 최대한 같은 각도로 책상을 촬영한다.
>3. 등록돼있는 사진들과 출석체크를 위해 촬영한 사진과 비교하여 일치율을 설정해놓은 Threshold와 비교하여 한 장이라도 만족할 시, **AttendanceCheckActivity**로  true 값을 전달한다.
>4. 등록한 사진 5장 모두 만족하지 않았을 경우, 촬영한 해당 사진을 등록할 것인지 Dialog를 통해 선택할 수 있다.    

### Color Histogram Image Matching 출석체크

**ImageMatchingActivity.java**

Camera를 실행시켜주는 button `onClickListener`이다.
~~~java
btnCamera = (Button)findViewById(R.id.btnCamera);  
btnCamera.setOnClickListener(new View.OnClickListener() {  
    @Override  
    public void onClick(View v) {    
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  
    startActivityForResult(intent, 0);  
    }  
});  

~~~
Camera로 촬영한 후에 실행되는 method이다. 일치 여부를 나타내는 boolean변수를 false로, 비교를 성공한 image의 개수를 나타내는 count 값을 0으로 초기화해주고 `imageDownload()` method를 실행한다.
~~~java
@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 0 && resultCode == RESULT_OK) {
        Bundle extras = data.getExtras();
        capturebmp = (Bitmap) extras.get("data");
        CheckSuccess = false;
        count = 0;
            
        imageDownload();
    }
}
~~~
등록되어 있는 image를 불러와서 방금 촬영한 image와 비교하는 `matching()` method를 실행한다.<br>
등록되어 있는 image는 bitmap 변수에 저장하고 방금촬영한 image는 `matching()`에 파라미터로 전달한다.<br>
한 장의 사진과 비교할 때마다 count값이 증가하며 총 5 장의 사진을 다 비교하고 true값을 반환하였다면, **ImageMatchingActivity**를 종료하고 true 값을 **AttendanceCheckActivity**로 전달한다.
~~~java
public void imageDownload(){
    storageRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
        @Override
        public void onSuccess(ListResult listResult) {
            for (StorageReference item : listResult.getItems()) {
            
                final long ONE_MEGABYTE = 1024 * 1024;
                item.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                   ...
                        bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

                        matching(capturebmp);
                        count++;

                        if(count== 5){
                            if(CheckSuccess == true){
                           ...
                                Intent intent = new Intent();
                                intent.putExtra("checkMatching", CheckSuccess);
                                setResult(RESULT_OK, intent);
                                finish();
                            }else {
                                ...
                                dialogUpload();
                            }
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) { }
                });
            }
        }
    })
    .addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) { }
    });
}
~~~
>[Firebase Storage File Download 사용법](https://firebase.google.com/docs/storage/android/download-files)
>[Firebase Storage File List 가져오기](https://firebase.google.com/docs/storage/android/list-files)

등록된 사진과 촬영한 사진을 비교하는 method이다. 촬영한 사진을 파라미터로 받아와서 등록되어 있는 사진과 비교한다.<br>
이 mathod를 위의 `imageDownload()` 에서 총 5번 수행하여 5장의 사진 모두 비교한다. <br>
각각의 이미지를 bitmap에서 Mat으로 변환을 해주고, [`Imgproc.cvtColor()`](https://docs.opencv.org/master/d8/d01/group__imgproc__color__conversions.html#ga397ae87e1288a81d2363b61574eb8cab)를 통해 HSV로 변환한다.<br>
[`Imgproc.calcHist()`](https://docs.opencv.org/master/d6/dc7/group__imgproc__hist.html#ga4b2b5fd75503ff9e6844cc4dcdaed35d)를 통해 color Histogram을 계산한 후, [`Core.normalize()`](https://docs.opencv.org/master/dc/d84/group__core__basic.html#ga1b6a396a456c8b6c6e4afd8591560d80)로 정규화해준다.<br>
각각 정규화까지 끝난 image를 [`Imgproc.compareHist()`](https://docs.opencv.org/master/d6/dc7/group__imgproc__hist.html#gaf4190090efa5c47cb367cf97a9a519bd)로 color Histogram을 비교하여 일치율을 `metric_val`변수에 넣어준다.<br>
metric_val값이 0에 가까울수록 일치율이 높은 결과이다.<br>
같은 책상사진을 촬영하였을 때, 다른 책상 혹은 다른 곳을 촬영하였을 때 등 여러 테스트를 거쳐 0.2값보다 작은 경우를 일치하는 것으로 판단하도록 구현하였다.<br>
0.2값보다 작은 image가 하나라도 존재한다면 true 값을 반환하여 출석체크가 가능하다.
~~~java
public void matching( Bitmap bitmap2){

    if(!OpenCVLoader.initDebug()){
        Log.d("start error : ", "OpenCV not loaded");
    } else {
        Log.d("start : ", "OpenCV loaded");
        try {
            Mat hist_1 = new Mat();
            Mat hist_2 = new Mat();

            MatOfFloat ranges = new MatOfFloat(0f, 256f);
            MatOfInt histSize = new MatOfInt(25);
       
       //등록된 사진
            img1 = new Mat();
            Utils.bitmapToMat(bitmap, img1);
            Imgproc.cvtColor(img1, img1, COLOR_BGR2HSV);
            Imgproc.calcHist(Arrays.asList(img1), new MatOfInt(0), new Mat(), hist_1, histSize, ranges);
            Core.normalize(hist_1, hist_1, 0, 1, Core.NORM_MINMAX);
       
       //촬영한 사진
            img2 = new Mat();
            Utils.bitmapToMat(bitmap2, img2);
            Imgproc.cvtColor(img2, img2, COLOR_BGR2HSV);
            Imgproc.calcHist(Arrays.asList(img2), new MatOfInt(0), new Mat(), hist_2, histSize, ranges);
            Core.normalize(hist_2, hist_2, 0, 1, Core.NORM_MINMAX);
       
       //두 사진 비교 후 결과
            metric_val = Imgproc.compareHist(hist_1, hist_2, Imgproc.HISTCMP_BHATTACHARYYA);// 0이 일치
            if(metric_val < 0.2) {
                CheckSuccess = true;
            }
            
        } catch (Exception e) { }
    }
}
~~~
출석체크에 실패했을 시 띄워주는 dialog이다. 
- 등록 버튼을 누를 시, 가장 오래된 사진을 하나 삭제하고 촬영한 해당 사진을 등록한다.
- 취소 버튼을 누를 시, 등록을 하지않고 다시 출석체크를 진행해야 한다.

여기서 사용되는 [`checksize()`](https://github.com/JJinTae/MakeYouStudy/blob/c3e8c9d4b3280c0fae93a51494ed29fe4fca873c/app/src/main/java/com/android/MakeYouStudy/ImageMatchingActivity.java#L285)와 [`imageUpload()`](https://github.com/JJinTae/MakeYouStudy/blob/c3e8c9d4b3280c0fae93a51494ed29fe4fca873c/app/src/main/java/com/android/MakeYouStudy/ImageMatchingActivity.java#L256)는 ProfileActivity에 있는 method와 동일하여 Link로 남겨두었다.
~~~java
public void dialogUpload(){
    activity = this;

    AlertDialog.Builder alertdialog = new AlertDialog.Builder(activity);
    alertdialog.setMessage("해당 사진을 등록하시겠습니까?");

    // 등록 버튼
    alertdialog.setPositiveButton("등록", new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int which) {
            checksize();
            imageUpload(capturebmp);
        }
    });

    // 취소 버튼
    alertdialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(activity, "취소 되었습니다.", Toast.LENGTH_SHORT).show();
        }
    });


    AlertDialog alert = alertdialog.create();
    alert.setTitle("출석체크 실패");

    alert.show();

}
~~~
>[ImageMatchingActivity.java 전체 코드](https://github.com/JJinTae/MakeYouStudy/blob/c3e8c9d4b3280c0fae93a51494ed29fe4fca873c/app/src/main/java/com/android/MakeYouStudy/ImageMatchingActivity.java)

## Attendance Rate
MakeYouStudy에서 출석률을 저장하는 역할을 수행한다.
MakeYouStudy에서는 데이터를 Database에서 불러오기 때문에 데이터를 불러오는 Code를 생략하고 Android의 좋은 OpenSource Chart인 [MPAndroidChart]([https://github.com/PhilJay/MPAndroidChart](https://github.com/PhilJay/MPAndroidChart))위주로 알아보도록 하겠다.
> MakeYouStudy에서는 Barchart와 PieChart를 사용하였다.

build.gradle(Module:**app**) dependency에 다음을 추가한다.
~~~java
dependencies {
    implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
}
~~~
**AttendanceRateActivity in Layout.xml**
~~~java
<com.github.mikephil.charting.charts.PieChart
android:id="@+id/piechart"
android:layout_width="match_parent"
android:layout_height="250dp">
</com.github.mikephil.charting.charts.PieChart>

<com.github.mikephil.charting.charts.BarChart
android:id="@+id/barchart"
android:layout_width="match_parent"
android:layout_height="350dp">
</com.github.mikephil.charting.charts.BarChart>
~~~
**AttendanceRateActivity.Java**
차트의 객체를 선언한다.
~~~java
public class AttendanceRateActivity extends AppCompatActivity {
    // chart 참조 객체 선언
    PieChart pieChart;
    BarChart barChart;
    ...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_rate);
        
        pieChart = (PieChart)findViewById(R.id.piechart);
        barChart = (BarChart)findViewById(R.id.barchart);
~~~
- 데이터를 담을 list또는 변수를 선언
- Barchart의 Y값을 바꾸기 위한 list 선언
- Color를 지정해주기 위한 list 선언
~~~java
ArrayList<BarEntry> Daycheck = new ArrayList<>();  // Barchart에 담을 BarEntry list
ArrayList<PieEntry> yValues = new ArrayList<>();  // Piechart에 담을 PieEntry list
final String[] weekdays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}; // Barchart의 Y값을 바꾸기 위한 list

// Color를 지정해주기 위한 list
final int[] checkColor = {ContextCompat.getColor(this, R.color.Check), ContextCompat.getColor(this, R.color.Total)};
final int[] weekColor = {  
   ContextCompat.getColor(this, R.color.Mon),  
   ContextCompat.getColor(this, R.color.Tue),  
   ContextCompat.getColor(this, R.color.Wed),  
   ContextCompat.getColor(this, R.color.Thu),  
   ContextCompat.getColor(this, R.color.Fri),  
   ContextCompat.getColor(this, R.color.Sat),  
   ContextCompat.getColor(this, R.color.Sun)  
};  
~~~
임시 데이터 값
~~~java
int AllCheck = 3;
int AllTotal = 5;
Daycheck.add(new BarEntry(30f, 0));
Daycheck.add(new BarEntry(40f, 1));
Daycheck.add(new BarEntry(30f, 2));
Daycheck.add(new BarEntry(20f, 3));
Daycheck.add(new BarEntry(15f, 4));
Daycheck.add(new BarEntry(50f, 5));
Daycheck.add(new BarEntry(31f, 6));
~~~

~~~java
// PieChart
pieChart.setUsePercentValues(true);  // pieChart를 Percent로 표시할지 설정
pieChart.getDescription().setEnabled(false);  // 
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
~~~
Barchart는 Y축이 Left와 Right가 있기 때문에 잘 고려해서 사용하여야 한다.
~~~java
// BarChart
XAxis xAxis = barChart.getXAxis();  // barChart의 X축
YAxis yLAxis = barChart.getAxisLeft();  // barChart의 Left_Y축
YAxis yRAxis = barChart.getAxisRight();  // barChart의 Right_Y축
  
// Y축 오른쪽 비활성화  
yRAxis.setDrawLabels(false);  
yRAxis.setDrawAxisLine(false);  
yRAxis.setDrawGridLines(false);  
  
// Y축 왼쪽 설정  
yLAxis.setDrawLabels(false);  
yLAxis.setDrawAxisLine(false);  
yLAxis.setAxisMaximum(100f);  // Y축의 최댓값을 정해준다.
  
// X축 설정  
xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE); // x값 표시 위치  
xAxis.setDrawGridLines(false); // x축 GridLinexAxis.setDrawAxisLine(false);  
xAxis.setTextSize(15f);  
xAxis.setValueFormatter(new IndexAxisValueFormatter(weekdays)); // 그래프 Y축 포맷 변경
  
barChart.getDescription().setEnabled(false); // 그래프 제목 삭제  
barChart.getLegend().setDrawInside(false);  // 범례 삭제
barChart.getLegend().setEnabled(false); // 그래프 범례 삭제  
// 그래프 zoom 애니메이션  
barChart.setPinchZoom(false);  
barChart.setScaleEnabled(false);  
barChart.setDoubleTapToZoomEnabled(false);  

barChart.animateY(1500, Easing.EaseOutBounce); // 그래프 애니메이션  
  
BarDataSet bardataset = new BarDataSet(Daycheck, "");  
BarData barData = new BarData(bardataset);  
bardataset.setColors(weekColor);  
  
barChart.setData(barData);
~~~
## Profile & Setting


# 4. 평가 요소 

## 차별성

- 설정한 시간에 맞춰 출석체크를 하면서 사용자가 흥미를 느끼고 나태하지 않게 공부할 수 있다. (출석체크방법이 다양하다.)

- 이번주의 열정 그래프(Attendance Rate)를 통해서 금주 출석체크기록을 확인할 수 있으며 자신의 부족함을 채워 다음주 공부계획을 체계적으로 세울 수 있다.

- 타임테이블로 공부시간표를 직접 설정하여 시간을 관리하며 공부가 가능하다.

- 랜덤공부명언을 통해 어플리케이션에 들어올 때마다 공부 동기가 부여된다.

- 한달 일정을 추가하면서 한달 일정을 확인 할 수 있고 일정에 따라 공부계획 수정이 가능하다.

- 다이어리를 적으면서 하루를 마무리 할 수 있다.



## 실용성 

사람들은 초등학생부터 성인이 되고 난 후에도 자신의 미래 혹은 자기계발을 하기 위해 끊임없이 공부한다. 하지만 사람들은 스스로 다짐하고 실천으로 옮길려고 해도 공부하는 습관을 기르기는 생각보다 어렵다.

이 어플리케이션은 출석체크, 공부 명언, Calendar, Timetable, Diary 등 다양한 기능들을 통해서 습관을 기르고 계획적으로 공부를 할 수 있어 공부를 하는 사람들에게 유용하게 자주 쓰일 것이다.

## 시장성

- Make You Study 어플은 이름을 영문으로 제작하여 글로벌화 된 어플로써 한국시장을 넘어서 전 세계 사람들이 우리의 앱을 구독할 수 있다.

- 사람들은 나이에 상관없이 공부하는 사람들이 많기 때문에 넓은 수요층을 가질 수 있다.

- 공부에 관한 어플이기 때문에 공부에 관한 여러 기능들을 지속적으로 추가개발이 가능하다.

- 공부를 하기위해서는 시간관리가 중요하기 때문에 체계적으로 시간을 관리하고 싶은 사람이 많다.

- 다른 공부어플과 다르게 공부 출석체크라는 차별화 둔 기능이 있기에 사람들의 호기심을 불러일으켜 사람들에 관심을 끌 수 있다.

#  5. 수익화 방안 

수익화는 어플을 유지하고 보수하기위해 필수적이다. 그래서 우리 Make YOU Study는 앱 제품 내부에 광고를 게재하여 수익을 얻을 것이다.


우선, 앱마켓에 등록을 하고 무료로 배포한다. 그 후, 캘린더 하단에 배너광고를 넣을 것이다.

내부광고는 보급 수량이 광고수익모델의 성패를 좌우하므로 대량보급이 되어야 한다.

우리 Make YOU Study는 공부어플로써 공부를 하는 넓은 수요층을 가질 수 있기 때문에 앱마켓에서 무료로 대량 배포한다. 초기진입장벽을 제거하여 보다 많은 사용자들에게 사용할 기회를 주고 많은 보급 수량으로 내부광고수익을 갖는다.

아래 그림은 수익화 예시 그림이다.

![캘린더 광고](https://user-images.githubusercontent.com/62635984/85474563-d430ca80-b5ef-11ea-8b8e-ba9733b2a022.JPG)



#  6. 기대효과 
- 공부출석을 기록하면서 공부를 의무적으로 하는 것이 아닌 재미를 느끼며 공부할 수 있다.

- 공부의 시작은 책상을 앉는 것부터 비롯되는데 책상사진을 찍으며 공부의 시작을 도와준다.

- 자신의 금주 공부출석을 보면서 뿌듯함을 느낄 수 있다.

- 공부 다짐부터 공부 실천까지를 도와준다.

- 공부하는 습관을 기를 수 있고 성실하게 공부할 수 있다.

- 공부계획을 체계적으로 세울 수 있고 시간을 효율적으로 관리할 수 있다.

- 일정을 보다 편리하게 관리 할 수 있다.

- 자기관리를 위한 하루의 반성 또는 발전을 할 수 있다

- 자기계발의 효과를 극대화 할 수 있다.

# 7. 결론 

# 8. 참고자료
- Calendar: [Material Calendar](https://github.com/Applandeo/Material-Calendar-View)

-
