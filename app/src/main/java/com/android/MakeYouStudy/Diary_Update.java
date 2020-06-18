package com.android.MakeYouStudy;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Diary_Update extends AppCompatActivity {

    private Intent intent;
    private EditText editText1, editText2;
    private String title, contents, date;
    private Button btn1, btn2;
    private Diary diary = new Diary();

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //firebase data object
    private DatabaseReference mDatabaseReference; // 데이터베이스의 주소를 저장합니다.
    private FirebaseDatabase mFirebaseDatabase; // 데이터베이스에 접근할 수 있는 진입점 클래스입니다.
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_update);

        // initializing database
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        mFirebaseDatabase = FirebaseDatabase.getInstance();

        // View object
        editText1 = (EditText)findViewById(R.id.edit_title_update);
        editText2 = (EditText)findViewById(R.id.edit_contents_update);
        btn1 = (Button)findViewById(R.id.save_btn_update);
        btn2 = (Button)findViewById(R.id.return_btn_update);

        // set intent object
        intent = getIntent();
        date = intent.getStringExtra("date");
        title = intent.getStringExtra("title");
        contents = intent.getStringExtra("contents");

        // setText
        searchDiary();
        editText1.setText(diary.getTitle().toString());
        editText2.setText(diary.getContents().toString());

        // button listener
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
    }

    public Diary searchDiary(){
        diary.setTitle(title);
        diary.setContents(contents);
        return diary;
    }
    public void updateDB(String date){
        mDatabaseReference = mFirebaseDatabase.getReference().child("diary").child(user.getUid()).child(date);
        mDatabaseReference.setValue(editText1.getText() + "/" + editText2.getText());
    }
}