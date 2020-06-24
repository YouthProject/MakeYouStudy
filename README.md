# MakeYouStudy
MakeYouStudy/App Project
# 다운받기 전 필요한 부분

## OpenCV 사용 전 필수 설치 사항

### OpenCV 
: Open Source Computer Vision의 약자로 다양한 영상/동영상 처리에 사용할 수 있는 오픈소스 라이브러리
- 이 라이브러리를 통해 얼굴 감지 및 인식, 물체 식별, 움직임 추적 등에 사용할 수 있다.
- OpenCV는 C++로 작성되었고, STL과 템플릿 기반의 인터페이스를 가지고 있다.
- C++, Python, Java, MATLAB의 인터페이스를 갖추고 있고, Windows, Linux, Android 및 Mac OS를 지원한다.

OpenCV를 Android Studio에서 사용하기 위해서는 다음 2가지가 필요하다.

- NDK 
: 안드로이드에서 JAVA코드와 C/C++ 코드를 같이 사용할 수 있게 한다.
- CMake
: C/C++ 코드를 컴파일하여 네이티브 라이브러리 파일로 만들기 위해 사용된다.

1. Tools → SDK Manager를 클릭한다.
![1-1](https://user-images.githubusercontent.com/50138845/85480567-34793980-b5fb-11ea-9072-e2c85c90cb76.jpg)
2. SDK Manager에서 Android SDK → SDK Tools를 클릭 후 Show Package Details를 클릭한다.
![1-2](https://user-images.githubusercontent.com/50138845/85481335-98503200-b5fc-11ea-97f6-ffa9204d0961.jpg)
3. NDK (Side by side)에서 20.0.5594570 버전을 선택하고, 
CMake에서 3.10.2.4988404 버전을 선택하여 Apply를 클릭한다.
![1-3](https://user-images.githubusercontent.com/50138845/85481381-ac942f00-b5fc-11ea-8007-38ee50ae6b3d.jpg)
4. 해당 버전을 알맞게 선택했는지 확인 후, 맞다면 OK 버튼을 클릭한다.
![1-4](https://user-images.githubusercontent.com/50138845/85481563-04cb3100-b5fd-11ea-87b1-4ae004c0dd7f.jpg)
5. 다운로드가 완료되면 Finish를 클릭한다.
![1-5](https://user-images.githubusercontent.com/50138845/85481585-0eed2f80-b5fd-11ea-8038-6b02f24eb52a.jpg)

### 안드로이드 스튜디오 3.4.0 이상의 버전
[Download link] ([http://developer.android.com/studio/index.html](http://developer.android.com/studio/index.html))
### API: 21이상

#  목차
### 1. 소개
- 앱소개
- 주제를 선정하게 된 이유 
- 간략한 기능 소개
- 앱 사용방법

### 2. 사전 설정 및 환경 구축
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

![로로그인](https://user-images.githubusercontent.com/62635984/85486856-6e9c0880-b606-11ea-9c61-e55a34224c3f.png)

- 데이터베이스를 총괄적으로 관리, 설계하는 Profile기능
- 구글과 페이스북 연동을 통한 로그인, 이메일을 통한 회원가입, 비밀번호 찾기 기능 구현

**2. 메인화면**

![명명언](https://user-images.githubusercontent.com/62635984/85487460-9049bf80-b607-11ea-857c-45234c4a0348.png)

- 앱에 접속할 때마다 바뀌는 명언
-  캘린더, 타임테이블, 다이어리, 출석률그래프 버튼 

**3. 캘린더기능**

![캘캘린더](https://user-images.githubusercontent.com/62635984/85487541-bc654080-b607-11ea-8f1f-17347aece1fc.png)

- 날짜에 할 일 및 예정을 적을 수 있는 캘린더 기능
- 날짜에 맞게 할 일을 추가 시 DOT표시 생성

**4. 타임테이블기능**


![타타임테이블](https://user-images.githubusercontent.com/62635984/85487805-3ac1e280-b608-11ea-922c-d3fa24ae73e8.png)

- 본인이 만든 시간표를 직접 작성할 수 있는 타임테이블
-  시간표 시간을 통한 출석률 체크 연동

**5. 다이어리기능**


![다다이어리](https://user-images.githubusercontent.com/62635984/85488032-955b3e80-b608-11ea-978f-348ba05c91e6.png)


- 각자의 일과 및 오늘 하루를 적을 수 있는 다이어리
- 다이어리 작성 시 목록 보기 칸에 리스트 자동 생성

**6. 출석체크기능**

![출출석체크](https://user-images.githubusercontent.com/62635984/85488203-df442480-b608-11ea-8af9-42f7d52a20fd.png)

- 본인 책상 사진 5장 등록
- timetable과의 연동으로 설정한 시간이 될 때 출석체크 알람 발생
- 출석체크 알람을 끄기 위해서는 그 시간대에 책상 사진을 찍어서 인증 시 알람 꺼짐
- 출석체크 인정 시 
- 당일 출석률 채워짐

다음은 Make You Study의 시연영상이다.
> [Make You Study의 시연영상](링크)

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
##   Firebase 
<h1>파이어 베이스 연동 </h1>

[파이어베이스](https://console.firebase.google.com/) 사이트에 접속해서 프로젝트추가 합니다 안드로이드 앱을 추가하여 시작 합니다. 

![8](https://user-images.githubusercontent.com/62867182/85451850-40ea9b80-b5d5-11ea-82f4-5d6dc8d7083e.PNG)

<br>

우리는 Google 로그인을 사용 하므로 '디버그 서명 인증서 SHA-1'을 알아야 합니다.

<'SHA-1'은 안드로이드 스튜디오 오른쪽에 있는 Gradle -> Tasks->android->signInReport를 클릭 하면 알 수 있습니다.>
![0-1](https://user-images.githubusercontent.com/62867182/85451382-c457bd00-b5d4-11ea-88f5-379d1ab61baa.PNG)

<br>


구성 파일을 다운로드 한뒤 , 생성된 프로젝트 파일->app 폴더 에다가 저장 합니다.
![9](https://user-images.githubusercontent.com/62867182/85451759-2dd7cb80-b5d5-11ea-83be-f1d89eb02eb8.PNG)

<br>

Gralde의 moudle 부분에 작성 합니다.

![11](https://user-images.githubusercontent.com/62867182/85451780-30d2bc00-b5d5-11ea-962c-863661a6d822.PNG)
![12](https://user-images.githubusercontent.com/62867182/85451784-316b5280-b5d5-11ea-978d-f3ad0262be16.PNG)


<br>


![13](https://user-images.githubusercontent.com/62867182/85451788-3203e900-b5d5-11ea-896d-dd6d152a1896.PNG)
<h4>Android Studio에 Firebase 추가 완료하였습니다</h4>

<br>

<h1>파이어베이스 Authentication 설정하기</h1>
우리는 이메일/비밀번호 로그인과 , 구글 로그인 , 페이스북 로그인을 사용 하는데,  Authentication의 Sign-in method의  3가지 로그인 방법을 활성화 시킵니다.
이메일/비밀번호 로그인, 구글 로그인은 파이어베이스 사이트에서 해결 할 수 있지만,  페이스북 로그인은 페이스북 개발자 사이트에 접속을 해서 연결 시켜야 합니다.

<h1>페이스북 연동하기  </h1>

[페이스북 개발자 ](https://developers.facebook.com/) 사이트 접속해서 로그인을 한 뒤 '새 앱 추가'를 합니다.
 제품 추가에서 페이스북 로그인을 선택 합니다. 로그인 플랫폼 선택에서 안드로이드를 클릭 합니다.
 
 <br>
 
Android용 Facebook SDK 다운로드는 생략 하고 순서대로 진행 합니다

<br>

<h4>   builde.gralde(Module:app)</h4>

  `implementation 'com.facebook.android: facebook-android-sdk:[4,5)')`  
     컴파일문을 추가하여 최신 버전의 SDK를 컴파일합니다.

<br>


<h4>패키지 이름과 기본액티비티 클래스 이름을 등록합니다. <h4>

![3](https://user-images.githubusercontent.com/62867182/85455092-8a88b580-b5d8-11ea-8aaf-3d8ca29fcd7d.PNG)

<br>

<h4>키 해시를 생성 해야 합니다.</h4>

![4](https://user-images.githubusercontent.com/62867182/85455093-8a88b580-b5d8-11ea-9e6c-b0cc428bf0cd.PNG)

<br>

<h4>키 해시 구하는 방법입니다</h4>

![키해시 최종](https://user-images.githubusercontent.com/62867182/85453211-996e6880-b5d6-11ea-948e-ef053c161888.PNG)

<br>

<h4>리소스 및 메니페스트를 수정 합니다.</h4>

![6](https://user-images.githubusercontent.com/62867182/85455085-88bef200-b5d8-11ea-8122-06d0b634e576.PNG)

<br>

<h4>단계별 진행이  완료 되면 왼쪽 메뉴 중 기본 설정에 들어가면  앱 ID , 앱 시크릿 코드 를 알 수 있습니다.</h4>

![22](https://user-images.githubusercontent.com/62867182/85455646-139fec80-b5d9-11ea-8ad9-88c459a7c2dc.PNG)
 
 앱 ID와 앱 시크릿 코드는 파이어베이스 페이스북 로그인 활성화에 사용됩니다. 파이어베이스 페이스북 로그인method에 붙려 넣기를 진행합니다.

<br>

<h4>OAuth 리디렉션 URI를 Facebook 앱 구성에 추가 해야 합니다.  URL를 복사한 다음에 페이스북로그인 설정 에서 OAuth 리디렉션 URI에 기입 해야 합니다</h4>

![23](https://user-images.githubusercontent.com/62867182/85455649-14d11980-b5d9-11ea-9f10-eccd36bfacda.PNG)


<br>


[ 페이스북 개발자(페이스북 로그인)](https://developers.facebook.com/docs/facebook-login/android/) 에 들어가서 추가 설정을 진행 합니다.

![으니지](https://user-images.githubusercontent.com/62867182/85456245-b5bfd480-b5d9-11ea-9273-cf5a46a22cfa.PNG)

<h4>파이어베이스의 로그인 설정이 완료가 되었습니다.<h4>

---

<h1>파이어베이스 Builder.gradle  </h1>

``implementation 'com.google.firebase:firebase-auth:19.3.1'``
[FirebaseAuth](https://firebase.google.com/docs/auth/android/start)
``implementation 'com.google.firebase:firebase-database:19.1.0'``
[Firebase realtimedabase](https://firebase.google.com/docs/database/android/start)
``implementation 'com.google.firebase:firebase-firestore:21.2.1'``
[Firebase cloudestore ](https://firebase.google.com/docs/firestore/quickstart)


<h1>파이어베이스  Authentication</h1>

파이어베이스  Authentication과 관련된 선언은 ``FirebaseAuth`` 와 `` FirebaseUser`` 입니다
``FirebaseAuth``의 인스턴스를 선언하는 방법입니다
```java
private  FirebaseAuth mAuth;
```

인스턴스의 초기화는 방법입니다.
```java 
mAuth =  FirebaseAuth.getInstance();
```
현재 로그인한사용자를 가져올 때 권장하는 방법은  `getCurrentUser`  메서드를 호출하는 것입니다.
```java 
FirebaseUser currentUser = mAuth.getCurrentUser();
```

 로그인한 사용자가 없으면  `getCurrentUser`는 null을 반환합니다.
활동을 초기화할 때 사용자가 현재 로그인되어 있는지 확인합니다.


<h1>파이어베이스 realtime database</h1>

 데이터베이스에 쓰기
`getInstance()`를 사용하여 데이터베이스의 인스턴스를 검색하고, 쓰려는 위치를 참조합니다
```java
FirebaseDatabase database =  FirebaseDatabase.getInstance();  
```

데이터베이스에서 읽기

실시간으로 앱 데이터를 업데이트하려면 방금 만든 참조에 ``ValueEventListener()``를 추가 해야한다.
onDataChange() 메서드는 리스너가 연결될 때 한 번 트리거된 후 하위 항목을 포함한 데이터가 변경될 때마다 다시 트리거됩니다.
```java 
// Read from the database  
myRef.addValueEventListener(new  ValueEventListener()  {
  @Override
    public  void onDataChange(DataSnapshot dataSnapshot)  {
      // This method is called once with the initial value and again 
       // whenever data at this location is updated.  String value = dataSnapshot.getValue(String.class); 
        Log.d(TAG,  "Value is: "  + value);
          }
            @Override
              public  void onCancelled(DatabaseError error)
                {  // Failed to read value
                  Log.w(TAG,  "Failed to read value.", error.toException());
                    }  
});
 ``` 

DatabaseReference 가져오기

데이터베이스에 데이터를 쓰려면  `DatabaseReference`의 인스턴스가 필요합니다.
```java 
private  DatabaseReference mDatabase;  
mDatabase =  FirebaseDatabase.getInstance().getReference();
```
 데이터 읽기 및 쓰기
기본 쓰기 작업은  ``setValue()``  코드를 사용하여 지정된 참조에 데이터를 저장하고 해당 경로의 기존 데이터를 모두 바꿉니다
```java
@IgnoreExtraProperties  
public  class  User  { 
 public  String username;
   public  String email;  public  User()  { 
    // Default constructor required for calls to 
    DataSnapshot.getValue(User.class)  }
      public  User(String username,  String email)  {
        this.username = username;  
        this.email = email;  }  
  
}'
private  void writeNewUser(String userId,  String name,  String email)  {
  User user =  new  User(name, email); 
  mDatabase.child("users").child(userId).setValue(user);  
}
```

<br>

<H1>Firebase Storage</h1>

스토리지 버킷에 액세스하는 첫 단계는 `FirebaseStorage`의 인스턴스를 만드는 것입니다.
```java 
FirebaseStorage storage =  FirebaseStorage.getInstance();
```
<br>

파일 업로드, 다운로드, 삭제, 메타데이터 가져오기 또는 업데이트를 하려면 참조를 만듭니다. 참조는 클라우드의 파일을 가리키는 포인터라고 생각할 수 있습니다. 참조는 메모리에 부담을 주지 않으므로 얼마든지 많이 만들 수 있으며 여러 작업에서 재사용할 수도 있습니다.

참조를 만들려면  `FirebaseStorage`  싱글톤 인스턴스를 사용하고 이 인스턴스의  `getReference()`  메서드를 호출합니다.
```java
// Create a storage reference from our app  
StorageReference storageRef = storage.getReference();
```
<br>

 메모리 데이터에서 업로드
`putBytes()`  메서드는 Cloud Storage에 파일을 업로드하는 가장 간단한 방법입니다.  `putBytes()`는  `byte[]`를 취하고  `UploadTask`를 반환하며 이 반환 객체를 사용하여 업로드를 관리하고 상태를 모니터링할 수 있습니다.


```java
// Get the data from an ImageView as bytes  
imageView.setDrawingCacheEnabled(true);  
imageView.buildDrawingCache();  
Bitmap bitmap =  ((BitmapDrawable) imageView.getDrawable()).getBitmap();  
ByteArrayOutputStream baos =  new  ByteArrayOutputStream();  
bitmap.compress(Bitmap.CompressFormat.JPEG,  100, baos);  
byte[] data = baos.toByteArray();  
  
UploadTask uploadTask = mountainsRef.putBytes(data);  
uploadTask.addOnFailureListener(new  OnFailureListener()  {  @Override  public  void onFailure(@NonNull  Exception exception)  {  // Handle unsuccessful uploads  }  
}).addOnSuccessListener(new  OnSuccessListener<UploadTask.TaskSnapshot>()  {  @Override  public  void onSuccess(UploadTask.TaskSnapshot taskSnapshot)  {  // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.  // ...  }  
});
```
##  Github

#  3. 기능구현
> [3. 기능구현](https://github.com/kimsumin-creat/MakeYouStudy-Fuction-Explain/blob/master/README.md)

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
