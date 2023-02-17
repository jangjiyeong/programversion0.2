package com.example.programversion02;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper_frg3 extends SQLiteOpenHelper {

    final static String DB_NAME = "data3.db";  //DB이름
    final static int DB_VERSION = 1; //DB버전



    //생성자
    public DBHelper_frg3(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //테이블의 구조는 여기서 설계

        String board_qry = "CREATE TABLE board_database(num INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",menual BLOB NOT NULL, board_kind TEXT NOT NULL, board_type TEXT NOT NULL, board_version TEXT NOT NULL" +
                ",board_code TEXT NOT NULL, chipset1 TEXT NOT NULL, chipset_name1 TEXT NOT NULL, chipset2 TEXT NOT NULL" +
                ",chipset_name2 TEXT NOT NULL, registration TEXT NOT NULL, request TEXT NOT NULL, model TEXT NOT NULL" +
                ",before_version TEXT NOT NULL, after_version TEXT NOT NULL, date TEXT NOT NULL, change_point TEXT NOT NULL" +
                ",writer TEXT NOT NULL, bundle TEXT NOT NULL, name19 TEXT NOT NULL, name20 TEXT NOT NULL" +
                ",name21 TEXT NOT NULL, name22 TEXT NOT NULL, name23 TEXT NOT NULL, name24 TEXT NOT NULL" +
                ",name25 TEXT NOT NULL)";
        sqLiteDatabase.execSQL(board_qry);

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