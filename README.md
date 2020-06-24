<br>

![MYS로고](https://user-images.githubusercontent.com/62635984/85444064-ea795f00-b5cc-11ea-817e-ebf4610dc6f9.png)


#  목차
* ### [다운받기 전 필요한 부분]()
	 ### : OpenCV를 사용하기 위한 필수 설치 사항
 
### 1. 소개
- [앱소개](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#1-%EC%86%8C%EA%B0%9C-1)
- [주제를 선정하게 된 이유](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#%EC%A3%BC%EC%A0%9C%EB%A5%BC-%EC%84%A0%EC%A0%95%ED%95%98%EA%B2%8C-%EB%90%9C-%EC%9D%B4%EC%9C%A0)
- [간략한 기능 소개](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#%EA%B0%84%EB%9E%B5%ED%95%9C-%EA%B8%B0%EB%8A%A5-%EC%84%A4%EB%AA%85)
- [앱 사용방법](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#%EC%95%B1-%EC%82%AC%EC%9A%A9-%EB%B0%A9%EB%B2%95)

### 2. 사전 설정 및 환경 구축
- [Firebase](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#%ED%8C%8C%EC%9D%B4%EC%96%B4-%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%97%B0%EB%8F%99-)


### 3. 기능 구현
- [각 액티비티기능 설명](https://github.com/kimsumin-creat/MakeYouStudy-Fuction-Explain/blob/master/README.md#%EA%B0%81-%EC%95%A1%ED%8B%B0%EB%B9%84%ED%8B%B0-%EA%B8%B0%EB%8A%A5-%EC%84%A4%EB%AA%85)
- [권한 허용 알림 및 로그인](https://github.com/kimsumin-creat/MakeYouStudy-Fuction-Explain/blob/master/README.md#%EA%B6%8C%ED%95%9C-%ED%97%88%EC%9A%A9-%EC%95%8C%EB%A6%BC-%EB%B0%8F-%EB%A1%9C%EA%B7%B8%EC%9D%B8)
- [Random wise saying](https://github.com/kimsumin-creat/MakeYouStudy-Fuction-Explain/blob/master/README.md#random-wise-saying)
- [Calendar](https://github.com/kimsumin-creat/MakeYouStudy-Fuction-Explain/blob/master/README.md#calendar)
- [Timetable](https://github.com/kimsumin-creat/MakeYouStudy-Fuction-Explain/blob/master/README.md#timetable)
- [Diary](https://github.com/kimsumin-creat/MakeYouStudy-Fuction-Explain/blob/master/README.md#diary)
- [Attendance Check]
- [Attendance Rate]
 
 
###  4. 차별성
>[차별성](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#%EC%B0%A8%EB%B3%84%EC%84%B1)

### 5. 실용성
>[실용성](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#%EC%8B%A4%EC%9A%A9%EC%84%B1)  

### 6. 시장성

> [시장성](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#%EC%8B%9C%EC%9E%A5%EC%84%B1)

###  7. 수익화 방안  
> [수익화방안](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#5-%EC%88%98%EC%9D%B5%ED%99%94-%EB%B0%A9%EC%95%88-1)
### 8. 기대효과
> [기대효과](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#6-%EA%B8%B0%EB%8C%80%ED%9A%A8%EA%B3%BC-1)
### 9. 결론
> [결론](https://github.com/JJinTae/MakeYouStudy/blob/master/README.md#7-%EA%B2%B0%EB%A1%A0-1
)






# 다운받기 전 필요한 부분

- 안드로이드 스튜디오 3.4.0 이상의 버전
>[Android Studio Download] ([http://developer.android.com/studio/index.html](http://developer.android.com/studio/index.html))
- API: 21이상
- **openCV의 사용을 위한 NDK, CMake 설치**


## 필수 설치 사항

**해당 설치 사항에 맞추어 설정해주지 않으면 어플리케이션이 실행되지 않는다.**

### OpenCV 
: Open Source Computer Vision의 약자로 다양한 영상/동영상 처리에 사용할 수 있는 오픈소스 라이브러리
- 이 라이브러리를 통해 얼굴 감지 및 인식, 물체 식별, 움직임 추적 등에 사용할 수 있다.
- OpenCV는 C++로 작성되었고, STL과 템플릿 기반의 인터페이스를 가지고 있다.
- C++, Python, Java, MATLAB의 인터페이스를 갖추고 있고, Windows, Linux, Android 및 Mac OS를 지원한다.

OpenCV를 Android Studio에서 사용하기 위해서는 다음 2가지가 필요하다.

- **NDK** 
: 안드로이드에서 JAVA코드와 C/C++ 코드를 같이 사용할 수 있게 한다.
- **CMake**
: C/C++ 코드를 컴파일하여 네이티브 라이브러리 파일로 만들기 위해 사용된다.

<br>

1. Tools → SDK Manager를 클릭한다. <br>
![1-1](https://user-images.githubusercontent.com/50138845/85480567-34793980-b5fb-11ea-9072-e2c85c90cb76.jpg)

<br>

2. SDK Manager에서 Android SDK → SDK Tools를 클릭 후 Show Package Details를 클릭한다.
![1-2](https://user-images.githubusercontent.com/50138845/85481335-98503200-b5fc-11ea-97f6-ffa9204d0961.jpg)

<br>

3. NDK (Side by side)에서 20.0.5594570 버전을 선택하고, 
CMake에서 3.10.2.4988404 버전을 선택하여 Apply를 클릭한다.
![1-3](https://user-images.githubusercontent.com/50138845/85481381-ac942f00-b5fc-11ea-8007-38ee50ae6b3d.jpg)

<br>

4. 해당 버전을 알맞게 선택했는지 확인 후, 맞다면 OK 버튼을 클릭한다.
![1-4](https://user-images.githubusercontent.com/50138845/85481563-04cb3100-b5fd-11ea-87b1-4ae004c0dd7f.jpg)

<br>

5. 다운로드가 완료되면 Finish를 클릭한다.
![1-5](https://user-images.githubusercontent.com/50138845/85481585-0eed2f80-b5fd-11ea-8038-6b02f24eb52a.jpg)


<br>

#  1. 소개
![로롤로로로로로](https://user-images.githubusercontent.com/50138845/85513047-95256800-b635-11ea-902d-5b033d74e425.jpg)


공부를 하고자 하는 의지는 있지만 다른 유혹에 의해 시작하는 것부터 어려움을 겪은 적이 많을 것이다.<br>
Make you study는 학생, 성인 모두 나이 불문하고 공부에 대한 의지가 있는 사람이라면 이 어플리케이션이 도움을 줄 수 있을 것이다. <br>
또한, 의지는 충분하지만 열정이 부족한 사람들에게도 역시 도움이 될 것이다.<br>
이 어플리케이션은 총 5가지의 기능을 제공한다.
- 계획을 적을 수 있는 Calendar 
- 하루의 일과를 적을 수 있는 Diary
-  시간 계획을 작성할 수 있는 TimeTable 
- 명언을 통한 동기유발
-  딥러닝을 통한 출석체크

 출석체크의 기능은 본인이 타임테이블에 맞춰 놓은 시간을 통해 알람이 울리게 되면 바로 의자에 앉아서 책상사진을 찍어야만 오늘의 출석이 인정이 된다. 출석체크의 방식은 사물인식, Image Matching, Text 인식이 있다. <br>
일주일동안의 출석률을 그래프로 쉽게 확인하여 관리할 수 있으며, 다양한 방법의 출석체크 기능을 통해 공부를 시작하는 것이 더욱 즐거워질 것이다. 

##  주제를 선정하게 된 이유
 평소에 공부를 할 때 책상에 앉는 것부터 시작된다. 하지만 공부를 시작하기 전부터 책상에 앉기까지 쉽지가 않을 때가 있다. 
 또한, 공부에 관련된 어플리케이션을 깔아보아도 크게 도움이 되지않고 삭제하는 경우가 많다. <br>
이러한 이유로 공부를 할 수 있도록 유도해주면서, 직접 자신의 공부 참여율을 체크할 수 있는 어플리케이션을 생각하게 되었다.<br> 
Make You Study는 출석체크를 통해 책상에 앉아 공부를 시작할 수 있도록 도와주고,  다이어리와 출석률 체크로 마무리까지 언제나 함께 하는 친구같은 어플리케이션을 목표로 제작하였다.



##  간략한 기능 설명

**1. 로그인 / 회원가입 / 비밀번호 찾기**

![로로그인](https://user-images.githubusercontent.com/62635984/85486856-6e9c0880-b606-11ea-9c61-e55a34224c3f.png)
 
- 구글과 페이스북 연동을 통한 로그인
-  이메일을 통한 회원가입
- 비밀번호 찾기

**2. 메인화면**

![명명언](https://user-images.githubusercontent.com/62635984/85487460-9049bf80-b607-11ea-857c-45234c4a0348.png)

- 앱에 접속할 때마다 바뀌는 명언
- 캘린더, 타임테이블, 다이어리, 출석률그래프, 설정으로 이동할 수 있는 버튼 

**3. 설정**

![프로필 책상](https://user-images.githubusercontent.com/50138845/85507825-f1848980-b62d-11ea-9be1-c76f6050eba0.jpg)

- 자신의 책상 Image를 5장 등록가능 - 미등록 경우 **빨간불** / 5장 모두 등록 완료 시, **초록불**
- 로그아웃
- 회원 탈퇴


**4. Calendar**

![캘캘린더](https://user-images.githubusercontent.com/62635984/85487541-bc654080-b607-11ea-8f1f-17347aece1fc.png)

- 날짜에 할 일 및 예정을 적을 수 있는 캘린더 기능
- 날짜에 맞게 할 일을 추가 시 DOT표시 생성

**5. TimeTable**


![타타임테이블](https://user-images.githubusercontent.com/62635984/85487805-3ac1e280-b608-11ea-922c-d3fa24ae73e8.png)

- 본인이 만든 시간표를 직접 작성할 수 있는 TimeTable
- 시간표를 등록하면 해당 시간에 알람이 울리고 출석체크 화면으로 이동
-  시간표와 출석체크를 연결하여 출석률을 체크

**6. Diary**


![다다이어리](https://user-images.githubusercontent.com/62635984/85488032-955b3e80-b608-11ea-978f-348ba05c91e6.png)


- 각자의 일과 및 오늘 하루를 적을 수 있는 다이어리
- 다이어리 작성 시 목록 보기 칸에 리스트 자동 생성
- 저장버튼 누를 시 일기를 적었던 시간 기록

**7. 출석체크**

![출출석체크](https://user-images.githubusercontent.com/62635984/85488203-df442480-b608-11ea-8af9-42f7d52a20fd.png)

- timetable과의 연동으로 시간표에 설정한 시간이 되면, 알람과 함께 출석체크 실행
- 알람을 끄기 위해서는 출석체크 완료를 해야함 - 출석 / 결석
- Image Matching 출석체크 : 등록해놓은 책상 사진 5장과 촬영한 책상 사진을 비교하여 일치할 시 출석 완료 
- 사물인식 출석체크 : 책상을 촬영하여 촬영한 사진이 책상이 맞을 경우 출석 완료
-  Text 인식 출석체크 : 제시된 영어단어를 노트에 따라적어 촬영 후, 인식된 Text가 제시된 영어단어와 일치할 시 출석 완료
-  출석인정시, 당일 출석률 채워짐
- 원형 그래프와 막대그래프로 자신의 출석률을 한 눈에 보기 쉬움
<br>



다음은 Make You Study의 시연영상이다.
> [Make You Study의 시연영상](링크)

<br>

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

<br>

>세 가지 방법의 출석체크 기능을 각각 활용하는 방법  
>* Image Matching 출석체크 : 자신이 가장 자주 사용하는 책상을 등록해놓는 것이 편하고 좋다. 가장 편리하고 빠른 출석체크가 가능하게 될 것이다. 
>* 사물인식 출석체크 : 어떤 책상을 촬영해도 된다는 점을 활용하여 등록해놓은 책상 이 외의 카페의 Table, 도서관 등 다른 장소에서도 사용할 수 있다. (대부분의 사람들은 한 공간에서만 공부를 하지 않고 종종 장소를 바꾸기도 한다.)
>* Text 인식 출석체크 : 제시된 영어단어를 보고 직접 노트에 따라적어 촬영해야 하므로 책상에 앉아 노트를 펴고 펜을 잡아 공부를 시작할 수 있도록 도와줄 수 있을 것이다. 

<br>
 
#  2. 사전 설정 및 환경 구축 
##  Firebase 

#### Firebase 연동 

[Firebase](https://console.firebase.google.com/) 사이트에 접속해서 프로젝트 추가한다. 안드로이드 앱을 추가하여 시작한다. 

![8](https://user-images.githubusercontent.com/62867182/85451850-40ea9b80-b5d5-11ea-82f4-5d6dc8d7083e.PNG)

<br>

 Google 로그인을 사용 하므로 '디버그 서명 인증서 SHA-1'을 알아야 한다.

<'SHA-1'은 안드로이드 스튜디오 오른쪽에 있는 Gradle -> Tasks->android->signInReport를 클릭 하면 알 수 있다.>
![0-1](https://user-images.githubusercontent.com/62867182/85451382-c457bd00-b5d4-11ea-88f5-379d1ab61baa.PNG)

<br>


구성 파일을 다운로드 한 뒤 , 생성된 프로젝트 파일->app 폴더 에다가 저장한다.
![9](https://user-images.githubusercontent.com/62867182/85451759-2dd7cb80-b5d5-11ea-83be-f1d89eb02eb8.PNG)

<br>

**build.gradle (moudle : project)** 부분에 작성한다.

![11](https://user-images.githubusercontent.com/62867182/85451780-30d2bc00-b5d5-11ea-962c-863661a6d822.PNG)
![12](https://user-images.githubusercontent.com/62867182/85451784-316b5280-b5d5-11ea-978d-f3ad0262be16.PNG)


<br>


![13](https://user-images.githubusercontent.com/62867182/85451788-3203e900-b5d5-11ea-896d-dd6d152a1896.PNG)
#### Android Studio에 Firebase 추가 완료

<br>

## Firebase Authentication 설정하기
이메일/비밀번호 로그인과 , 구글 로그인 , 페이스북 로그인을 사용 하는데,  Authentication의 Sign-in method의  3가지 로그인 방법을 활성화 시킨다.
이메일/비밀번호 로그인, 구글 로그인은 파이어베이스 사이트에서 해결 할 수 있지만,  페이스북 로그인은 페이스북 개발자 사이트에 접속을 해서 연결시켜야 한다.

### 페이스북 연동하기 

[페이스북 개발자 ](https://developers.facebook.com/) 사이트 접속해서 로그인을 한 뒤 '새 앱 추가'를 한다.
 제품 추가에서 페이스북 로그인을 선택한다. 로그인 플랫폼 선택에서 안드로이드를 클릭한다.
 
 <br>
 
Android용 Facebook SDK 다운로드는 생략 하고 순서대로 진행한다.

<br>

####   builde.gralde(Module:app)

  `implementation 'com.facebook.android: facebook-android-sdk:[4,5)')`  
     컴파일문을 추가하여 최신 버전의 SDK를 컴파일한다.

<br>


<h4>패키지 이름과 기본액티비티 클래스 이름을 등록한다. <h4>

![3](https://user-images.githubusercontent.com/62867182/85455092-8a88b580-b5d8-11ea-8aaf-3d8ca29fcd7d.PNG)

<br>

<h4>키 해시를 생성 해야한다.</h4>

![4](https://user-images.githubusercontent.com/62867182/85455093-8a88b580-b5d8-11ea-9e6c-b0cc428bf0cd.PNG)

<br>

<h4>키 해시 구하는 방법이다.</h4>

![키해시 최종](https://user-images.githubusercontent.com/62867182/85453211-996e6880-b5d6-11ea-948e-ef053c161888.PNG)

<br>

<h4>리소스 및 메니페스트를 수정한다.</h4>

![6](https://user-images.githubusercontent.com/62867182/85455085-88bef200-b5d8-11ea-8122-06d0b634e576.PNG)

<br>

<h4>단계별 진행이  완료 되면 왼쪽 메뉴 중 기본 설정에 들어가면  앱 ID , 앱 시크릿 코드 를 알 수 있다.</h4>

![22](https://user-images.githubusercontent.com/62867182/85455646-139fec80-b5d9-11ea-8ad9-88c459a7c2dc.PNG)
 
 앱 ID와 앱 시크릿 코드는 파이어베이스 페이스북 로그인 활성화에 사용된다. 파이어베이스 페이스북 로그인method에 붙려 넣기를 진행한다.

<br>

<h4>OAuth 리디렉션 URI를 Facebook 앱 구성에 추가 해야한다.  URL를 복사한 다음에 페이스북로그인 설정 에서 OAuth 리디렉션 URI에 기입 해야한다.</h4>

![23](https://user-images.githubusercontent.com/62867182/85455649-14d11980-b5d9-11ea-9f10-eccd36bfacda.PNG)


<br>


[ 페이스북 개발자(페이스북 로그인)](https://developers.facebook.com/docs/facebook-login/android/) 에 들어가서 추가 설정을 진행한다.

![으니지](https://user-images.githubusercontent.com/62867182/85456245-b5bfd480-b5d9-11ea-9273-cf5a46a22cfa.PNG)

<h4>파이어베이스의 로그인 설정이 완료<h4>



## 파이어베이스 공통으로 사용하는  Builder.gradle 
 
``implementation 'com.google.firebase:firebase-auth:19.3.1'``
>[FirebaseAuth](https://firebase.google.com/docs/auth/android/start)

``implementation 'com.google.firebase:firebase-database:19.1.0'``
>[Firebase realtimedabase](https://firebase.google.com/docs/database/android/start)

``implementation 'com.google.firebase:firebase-firestore:21.2.1'``
>[Firebase cloudestore ](https://firebase.google.com/docs/firestore/quickstart)



## 파이어베이스  Authentication

파이어베이스  Authentication과 관련된 선언은 ``FirebaseAuth`` 와 `` FirebaseUser`` 이다.
``FirebaseAuth``의 인스턴스를 선언하는 방법이다.
```java
private  FirebaseAuth mAuth;
```

인스턴스를 초기화하는 방법이다.
```java 
mAuth =  FirebaseAuth.getInstance();
```
현재 로그인한 사용자를 가져올 때 권장하는 방법은  `getCurrentUser`  메서드를 호출하는 것이다.
```java 
FirebaseUser currentUser = mAuth.getCurrentUser();
```

 로그인한 사용자가 없으면  `getCurrentUser`는 null을 반환한다.
활동을 초기화할 때 사용자가 현재 로그인되어 있는지 확인한다.


## 파이어베이스 realtime database


#### 데이터베이스 권한 설정

데이터를 읽고 ,쓰기 위해서 권한을 설정 해야 한다.

![realtime 규칙](https://user-images.githubusercontent.com/62867182/85529224-cdce3d00-b647-11ea-8c57-702a5b766ab0.PNG)




#### 데이터베이스에 쓰기
`getInstance()`를 사용하여 데이터베이스의 인스턴스를 검색하고, 쓰려는 위치를 참조한다.
```java
FirebaseDatabase database =  FirebaseDatabase.getInstance();  
```

#### 데이터베이스에서 읽기

실시간으로 앱 데이터를 업데이트하려면 방금 만든 참조에 ``ValueEventListener()``를 추가 해야한다.
`onDataChange()` 메서드는 리스너가 연결될 때 한 번 트리거된 후 하위 항목을 포함한 데이터가 변경될 때마다 다시 트리거된다.
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

#### DatabaseReference 가져오기

데이터베이스에 데이터를 쓰려면  `DatabaseReference`의 인스턴스가 필요하다.
```java 
private  DatabaseReference mDatabase;  
mDatabase =  FirebaseDatabase.getInstance().getReference();
```
#### 데이터 읽기 및 쓰기

기본 쓰기 작업은  ``setValue()``  코드를 사용하여 지정된 참조에 데이터를 저장하고 해당 경로의 기존 데이터를 모두 바꾼다.
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

## Firebase Storage


##Storage 권한 설정

 데이터를 Storage에 읽고, 쓰기 위해서 권한은 설정
 
![storage 규칙](https://user-images.githubusercontent.com/62867182/85529766-5d73eb80-b648-11ea-8d3d-2dfb1fd38c81.PNG)



스토리지 버킷에 액세스하는 첫 단계는 `FirebaseStorage`의 인스턴스를 만드는 것이다.
```java 
FirebaseStorage storage =  FirebaseStorage.getInstance();
```
<br>

파일 업로드, 다운로드, 삭제, 메타데이터 가져오기 또는 업데이트를 하려면 참조를 만든다. 참조는 클라우드의 파일을 가리키는 포인터라고 생각할 수 있다. 참조는 메모리에 부담을 주지 않으므로 얼마든지 많이 만들 수 있으며 여러 작업에서 재사용할 수도 있다.

참조를 만들려면  `FirebaseStorage`  싱글톤 인스턴스를 사용하고 이 인스턴스의  `getReference()`  메서드를 호출한다.
```java
// Create a storage reference from our app  
StorageReference storageRef = storage.getReference();
```
<br>

 #### 메모리 데이터에서 업로드
`putBytes()`  메서드는 Cloud Storage에 파일을 업로드하는 가장 간단한 방법이다. <br>
`putBytes()`는  `byte[]`를 취하고  `UploadTask`를 반환하며 이 반환 객체를 사용하여 업로드를 관리하고 상태를 모니터링할 수 있다.


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
<br>

#  3. 기능구현

기능 구현 설명 부분을 별도로 첨부하였다.

> [3. 기능구현](https://github.com/kimsumin-creat/MakeYouStudy-Fuction-Explain/blob/master/README.md)



# 4. 차별성

- 설정한 시간에 맞춰 출석체크를 하면서 사용자가 흥미를 느끼고 나태하지 않게 공부할 수 있다. (출석체크 방법이 다양하다.)

- 이번 주의 열정 그래프(Attendance Rate)를 통해서 금주 출석체크 기록을 확인할 수 있으며 자신의 부족함을 채워 다음주 공부계획을 체계적으로 세울 수 있다.

- TimeTable로 공부 시간표를 직접 설정하여 시간을 관리하며 공부가 가능하다.

- 랜덤 공부명언을 통해 어플리케이션에 들어올 때마다 공부 동기가 부여된다.

- 한달 일정을 추가하면서 한달 일정을 확인 할 수 있고 일정에 따라 공부계획 수정이 가능하다.

- 다이어리를 적으면서 하루를 마무리 할 수 있다.


# 5. 실용성 

사람들은 초등학생부터 성인이 되고 난 후에도 자신의 미래 혹은 자기계발을 하기 위해 끊임없이 공부한다. 하지만 사람들은 스스로 다짐하고 실천으로 옮길려고 해도 공부하는 습관을 기르기는 생각보다 어렵다.

이 어플리케이션은 출석체크, 공부 명언, Calendar, Timetable, Diary 등 다양한 기능들을 통해서 습관을 기르고 계획적으로 공부를 할 수 있어 공부를 하는 사람들에게 유용하게 자주 쓰일 것이다.

# 6. 시장성

- Make You Study 어플은 이름을 영문으로 제작하여 글로벌화 된 어플로써 한국시장을 넘어서 전 세계 사람들이 우리의 앱을 구독할 수 있다.

- 사람들은 나이에 상관없이 공부하는 사람들이 많기 때문에 넓은 수요층을 가질 수 있다.

- 공부에 관한 어플이기 때문에 공부에 관한 여러 기능들을 지속적으로 추가개발이 가능하다.

- 공부를 하기위해서는 시간관리가 중요하기 때문에 체계적으로 시간을 관리하고 싶어하는 사람이 많다.

- 다른 공부어플과 다르게 출석체크라는 차별화 둔 기능이 있기에 사람들의 호기심을 불러일으켜 사람들에 관심을 끌 수 있다.

#  7. 수익화 방안 
### " 광고 "
<br>

수익화는 어플을 유지하고 보수하기위해 필수적이다. 그래서 우리 Make You Study는 앱 제품 내부에 광고를 게재하여 수익을 얻을 것이다.


우선, 앱마켓에 등록을 하고 무료로 배포한다. 그 후, 캘린더 하단에 배너광고를 넣을 것이다.

내부광고는 보급 수량이 광고수익모델의 성패를 좌우하므로 대량보급이 되어야 한다.

우리 Make You Study는 공부어플로써 공부를 하는 넓은 수요층을 가질 수 있기 때문에 앱마켓에서 무료로 대량 배포한다. 초기진입장벽을 제거하여 보다 많은 사용자들에게 사용할 기회를 주고 많은 보급 수량으로 내부광고수익을 갖는다.

아래 그림은 수익화 예시 그림이다.

![캘린더 광고](https://user-images.githubusercontent.com/62635984/85474563-d430ca80-b5ef-11ea-8b8e-ba9733b2a022.JPG)



#  8. 기대효과 
- 공부출석을 기록하면서 공부를 의무적으로 하는 것이 아닌 재미를 느끼며 공부할 수 있다.

- 공부의 시작은 책상을 앉는 것부터 비롯되는데 책상사진을 찍으며 공부의 시작을 도와준다.

- 자신의 금주 공부출석을 보면서 뿌듯함을 느낄 수 있다.

- 사용자가 공부에 대한 다짐으로 부터 실천까지 할 수 있도록 이끌어준다.

- 공부하는 습관을 기를 수 있고 성실하게 공부할 수 있다.

- 공부계획을 체계적으로 세울 수 있고 시간을 효율적으로 관리할 수 있다.

- 일정을 보다 편리하게 관리 할 수 있다.

- 자기관리를 위한 하루의 반성 또는 발전을 할 수 있다.

- 자기계발의 효과를 극대화 할 수 있다.

# 9. 결론 
