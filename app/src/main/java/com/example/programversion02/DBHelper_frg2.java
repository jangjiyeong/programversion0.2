package com.example.programversion02;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper_frg2 extends SQLiteOpenHelper {

    final static String DB_NAME = "data2.db";  //DB이름
    final static int DB_VERSION = 2; //DB버전



    //생성자
    public DBHelper_frg2(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //테이블의 구조는 여기서 설계
        String qry = "CREATE TABLE student(num INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",name1 TEXT NOT NULL, name2 TEXT NOT NULL, name3 TEXT NOT NULL, name4 TEXT NOT NULL" +
                ",name5 TEXT NOT NULL, name6 TEXT NOT NULL, name7 TEXT NOT NULL, name8 TEXT NOT NULL" +
                ",name9 TEXT NOT NULL, name10 TEXT NOT NULL, name11 TEXT NOT NULL, name12 TEXT NOT NULL" +
                ",name13 TEXT NOT NULL, name14 TEXT NOT NULL, name15 TEXT NOT NULL, name16 TEXT NOT NULL" +
                ",name17 TEXT NOT NULL, name18 TEXT NOT NULL, name19 TEXT NOT NULL, name20 TEXT NOT NULL" +
                ",name21 TEXT NOT NULL, name22 TEXT NOT NULL, name23 TEXT NOT NULL, name24 TEXT NOT NULL" +
                ",name25 TEXT NOT NULL)";
        sqLiteDatabase.execSQL(qry);


        //없으면 썰렁하니 아무 데이터라도 넣어주기
//        qry = "INSERT INTO student(num,name1,name2,name3,name4,name5,name6,name7,name8,name9,name10,name11,name12) " +
//                "VALUES('NO','구분1','구분2','구분3','구분4','구분5','구분6','구분7','구분8','구분9','구분10','구분11','구분12')";
//        sqLiteDatabase.execSQL(qry);
//        qry = "INSERT INTO student(name) VALUES('김영우')";
//        sqLiteDatabase.execSQL(qry);
//        qry = "INSERT INTO student(name) VALUES('이샹슈')";
//        sqLiteDatabase.execSQL(qry);

    }


    //버전 업데이트 될때마다 호출 되는데 마지막에 onCreate도 같이 실행되기 때문에 여기서 먼저 DB에 존재하는 테이블들을 지워줘야함.
    //한마디로 초기화역할
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String qry = "DROP TABLE IF EXISTS student";
        sqLiteDatabase.execSQL(qry);

        onCreate(sqLiteDatabase);

    }
}