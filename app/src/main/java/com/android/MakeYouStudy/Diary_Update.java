package com.android.MakeYouStudy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Diary_Update extends AppCompatActivity {

    private Intent intent;
    private EditText editText1, editText2;
    private int code;
    private Button btn1, btn2;
    private DiaryDBHelper dbHelper;
    private SQLiteDatabase db;
    private Diary diary = new Diary();

    //파이어베이스
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_update);
        intent = getIntent();

        dbHelper = new DiaryDBHelper(getApplicationContext());

        editText1 = (EditText)findViewById(R.id.edit_title_update);
        editText2 = (EditText)findViewById(R.id.edit_contents_update);

        code = intent.getExtras().getInt("code");

        btn1 = (Button)findViewById(R.id.save_btn_update);
        btn2 = (Button)findViewById(R.id.return_btn_update);

        searchDiary(code);
        editText1.setText(diary.getTitle().toString());
        editText2.setText(diary.getContents().toString());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDB(code);
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
    public Diary searchDiary(int code){
        db = dbHelper.getReadableDatabase();
        String sql = "select * from diary where code="+code;
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            diary.setTitle(cursor.getString(1));
            diary.setContents(cursor.getString(3));
        }
        cursor.close();
        db.close();
        return diary;
    }
    public void updateDB(int code){
        db = dbHelper.getWritableDatabase();
        String sql = "update diary set title=?, contents=? where code="+code;
        SQLiteStatement st = db.compileStatement(sql);
        st.bindString(1,editText1.getText().toString());
        st.bindString(2,editText2.getText().toString());
        st.execute();
        db.close();
    }

}