package com.example.project3275playmate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "playmate.db"; //database name
    final static int DATABASE_VERSION = 4;

    final static String TABLE1_NAME = "User";
    final static String T1COL_0 = "UName";
    final static String T1COL_1 = "email";
    final static String T1COL_2 = "password";


    final static String TABLE2_NAME = "Expert";
    final static String T2COL_0 = "EName";
    final static String T2COL_1 = "gender";
    final static String T2COL_2 = "rate";
    final static String T2COL_3 = "wage";

    final static String TABLE3_NAME = "Customer";
    final static String T3COL_0 ="CName";
    final static String T3COL_1 ="balance";





    public DataBase(@Nullable Context context){
        super(context, DATABASE_NAME, null ,DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE "+ TABLE1_NAME + "("+
                T1COL_0 + " varchar(20) PRIMARY KEY,"+
                T1COL_1 + " varchar(20),"+
                T1COL_2 + " varchar(20))";
        db.execSQL(query1);

        String query2 = "CREATE TABLE "+ TABLE2_NAME + "("+
                T2COL_0 + " varchar(20) PRIMARY KEY,"+
                T2COL_1 + " REAL,"+
                T2COL_2 + " REAL,"+
                T2COL_3 + " REAL," +
                "FOREIGN KEY (EName) REFERENCES User(UName))";
        db.execSQL(query2);

        String query3 =" CREATE TABLE "+ TABLE3_NAME + "("+
                T3COL_0 + " varchar(20) PRIMARY KEY,"+
                T3COL_1 + " REAL," +
                "FOREIGN KEY (CName) REFERENCES User(UName))";
        db.execSQL(query3);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
