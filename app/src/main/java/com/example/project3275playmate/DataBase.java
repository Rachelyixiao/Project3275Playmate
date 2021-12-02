package com.example.project3275playmate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "playmate.db"; //database name
    final static int DATABASE_VERSION = 3;

    final static String TABLE1_NAME = "User";
    final static String T1COL_0 = "UName";
    final static String T1COL_1 = "email";
    final static String T1COL_2 = "password";







    public DataBase(@Nullable Context context){
        super(context, DATABASE_NAME, null ,DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE "+ TABLE1_NAME + "("+
                T1COL_0 + " varchar(20) PRIMARY KEY,"+
                T1COL_1 + " varchar(20),"+
                T1COL_2 + " varchar(20))";
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
