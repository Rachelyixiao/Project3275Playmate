package com.example.project3275playmate;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "playmate.db"; //database name
    private static int n = 11;
    final static int DATABASE_VERSION = n++;

    final static String TABLE1_NAME = "User";
    final static String T1COL_0 = "UName";
    final static String T1COL_1 = "email";
    final static String T1COL_2 = "password";


    final static String TABLE2_NAME = "Expert";
    final static String T2COL_0 = "EName";
    final static String T2COL_1 = "gender";
    final static String T2COL_2 = "rate";
    final static String T2COL_3 = "wage";
    final static String T2COL_4 = "balance";

    final static String TABLE3_NAME = "Customer";
    final static String T3COL_0 ="CName";
    final static String T3COL_1 ="balance";

    final static String TABLE4_NAME = "Admin";
    final static String T4COL_0 ="AID";
    final static String T4COL_1 ="AName";
    final static String T4COL_2 ="email";
    final static String T4COL_3 ="password";

    final static String TABLE5_NAME = "Game";
    final static String T5COL_0 ="GName";
    final static String T5COL_1 ="GType";

    final static String TABLE6_NAME = "GameProfile";
    final static String T6COL_0 ="GName";
    final static String T6COL_1 ="EName";
    final static String T6COL_2 ="description";

    final static String TABLE7_NAME = "TopUp";
    final static String T7COL_0 ="TTID";
    final static String T7COL_1 ="date";
    final static String T7COL_2 ="amount";
    final static String T7COL_3 ="transactionType";
    final static String T7COL_4 ="CName";
    final static String T7COL_5 ="AName";

    final static String TABLE8_NAME = "Transactions";
    final static String T8COL_0 ="TID";
    final static String T8COL_1 ="date";
    final static String T8COL_2 ="hours";
    final static String T8COL_3 ="totalAmount";
    final static String T8COL_4 ="CName";
    final static String T8COL_5 ="EName";
    final static String T7COL_6 ="AName";

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

        String query2 = "CREATE TABLE "+ TABLE2_NAME + "("+
                T2COL_0 + " varchar(20) PRIMARY KEY,"+
                T2COL_1 + " REAL,"+
                T2COL_2 + " REAL,"+
                T2COL_3 + " REAL," +
                T2COL_4 + " REAL," +
                "FOREIGN KEY (EName) REFERENCES User(UName))";
        db.execSQL(query2);

        String query3 =" CREATE TABLE "+ TABLE3_NAME + "("+
                T3COL_0 + " varchar(20) PRIMARY KEY,"+
                T3COL_1 + " REAL," +
                "FOREIGN KEY (CName) REFERENCES User(UName))";
        db.execSQL(query3);

        String query4 =" CREATE TABLE "+ TABLE4_NAME + "("+
                T4COL_0 + " INTERGER PRIMARY KEY,"+
                T4COL_1 + " TEXT," +
                T4COL_2 + " TEXT," +
                T4COL_3 + " TEXT)" ;
        db.execSQL(query4);

        String query5 =" CREATE TABLE "+ TABLE5_NAME + "("+
                T5COL_0 + " TEXT PRIMARY KEY,"+
                T5COL_1 + " TEXT)" ;
        db.execSQL(query5);

        String query6 =" CREATE TABLE "+ TABLE6_NAME + "("+
                T6COL_0 + " TEXT,"+
                T6COL_1 + " TEXT," +
                T6COL_2 + " TEXT," +
                "PRIMARY KEY ("+T6COL_0+","+T6COL_1+"),"+
                "FOREIGN KEY (GName) REFERENCES Game(GName)," +
                "FOREIGN KEY (EName) REFERENCES Expert(EName))";
        db.execSQL(query6);

        String query7 =" CREATE TABLE "+ TABLE7_NAME + "("+
                T7COL_0 + " INTERGER PRIMARY KEY,"+
                T7COL_1 + " TEXT," +
                T7COL_2 + " REAL," +
                T7COL_3 + " INTERGER," +
                T7COL_4 + " TEXT," +
                T7COL_5 + " TEXT," +
                "FOREIGN KEY (AName) REFERENCES Admin(AName)," +
                "FOREIGN KEY (CName) REFERENCES Customer(CName))";
        db.execSQL(query7);

        String query8 =" CREATE TABLE "+ TABLE8_NAME + "("+
                T8COL_0 + " INTERGER PRIMARY KEY,"+
                T8COL_1 + " TEXT," +
                T8COL_2 + " REAL," +
                T8COL_3 + " REAL," +
                T8COL_4 + " TEXT," +
                T8COL_5 + " TEXT," +
                T7COL_6 + " TEXT," +
                "FOREIGN KEY (AName) REFERENCES Admin(AName)," +
                "FOREIGN KEY (CName) REFERENCES Customer(CName)," +
                "FOREIGN KEY (EName) REFERENCES Expert(EName))";
        db.execSQL(query8);


        String query9 = "INSERT INTO "+TABLE4_NAME +" VALUES "+
                "(2001,"+"'David',"+"'david@gmail.com',"+"'12345ghjkl'"+"),"+
                "(2002,"+"'Rachel',"+"'Rachel@gmail.com',"+"'lkjhgpoiuy12'"+"),"+
                "(2003,"+"'scott',"+"'scott@gmail.com',"+"'23934sdfgs'"+")";
        db.execSQL(query9);

        String query10 = "INSERT INTO "+TABLE5_NAME +" VALUES "+"("+
                "'PUBG',"+"'STG'"+"),"+"("+
                "'Dota2',"+"'MOBA'"+"),"+"("+
                "'GTA5',"+"'RPG'"+"),"+"("+
                "'League of Legends',"+"'MOBA'"+"),"+"("+
                "'Call of Duty',"+"'FPS'"+"),"+"("+
                "'Arena of Valor',"+"'MOBA'"+"),"+"("+
                "'Minecraft',"+"'Sandbox'"+"),"+"("+
                "'CSGO',"+"'Tactical shooter'"+")";
        db.execSQL(query10);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS "+TABLE1_NAME);
        //db.execSQL("DROP TABLE IF EXISTS "+TABLE2_NAME);

    }


}
