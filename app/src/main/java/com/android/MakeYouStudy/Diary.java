package com.android.MakeYouStudy;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Diary {
    private int code;
    private String title;
    private String date;
    private String contents;
    //경민이형이 알려준 파이어베이스
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseDatabase;




    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
