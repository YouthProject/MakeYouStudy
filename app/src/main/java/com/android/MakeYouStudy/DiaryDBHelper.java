package com.android.MakeYouStudy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DiaryDBHelper extends SQLiteOpenHelper {

    //파이어베이스 코드
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mFirebaseDatabase;


    public DiaryDBHelper(Context context) {
        super(context, "Diary", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE diary (" +
                "'code' INTEGER PRIMARY KEY AUTOINCREMENT," + "`title` TEXT," + "`date` TEXT," + "`contents` TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists diary";
        db.execSQL(sql);

        onCreate(db);
    }
}
