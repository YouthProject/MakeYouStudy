package com.android.MakeYouStudy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DiaryPassDBHelper extends SQLiteOpenHelper {
    public DiaryPassDBHelper(Context context) {
        super(context, "Password", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE passwd (" + "'pass' TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists passwd";
        db.execSQL(sql);

        onCreate(db);
    }
}
