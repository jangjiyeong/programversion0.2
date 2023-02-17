package com.example.programversion02;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper_all extends SQLiteOpenHelper {

    final static String DB_NAME = "data_all.db";  //DB이름
    final static int DB_VERSION = 1; //DB버전



    //생성자
    public DBHelper_all(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //테이블의 구조는 여기서 설계
        String sw_qry = "CREATE TABLE sw_database(num INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",model TEXT NOT NULL, camera TEXT NOT NULL, resolution TEXT NOT NULL, channel TEXT NOT NULL" +
                ",registration TEXT NOT NULL, request TEXT NOT NULL, board_type TEXT NOT NULL, country TEXT NOT NULL, bundle TEXT NOT NULL"  +
                ",before_version TEXT NOT NULL, after_version TEXT NOT NULL, date TEXT NOT NULL, file_name TEXT NOT NULL" +
                ",git_branch TEXT NOT NULL, change_point TEXT NOT NULL, writer TEXT NOT NULL" +
                ",name17 TEXT NOT NULL, name18 TEXT NOT NULL, name19 TEXT NOT NULL, name20 TEXT NOT NULL" +
                ",name21 TEXT NOT NULL, name22 TEXT NOT NULL, name23 TEXT NOT NULL, name24 TEXT NOT NULL" +
                ",name25 TEXT NOT NULL)";

        sqLiteDatabase.execSQL(sw_qry);

        String form_qry = "CREATE TABLE form_database(num INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",model TEXT NOT NULL, camera TEXT NOT NULL, resolution TEXT NOT NULL, channel TEXT NOT NULL" +
                ",registration TEXT NOT NULL, request TEXT NOT NULL, board_kind TEXT NOT NULL, board_type TEXT NOT NULL" +
                ",board_version TEXT NOT NULL, board_code TEXT NOT NULL, chipset1 TEXT NOT NULL, chipset_name1 TEXT NOT NULL, chipset2 TEXT NOT NULL" +
                ",chipset_name2 TEXT NOT NULL, file_name TEXT NOT NULL, before_version TEXT NOT NULL, after_version TEXT NOT NULL" +
                ",date TEXT NOT NULL, change_point TEXT NOT NULL, writer TEXT NOT NULL, bundle TEXT NOT NULL" +
                ",name22 TEXT NOT NULL, name23 TEXT NOT NULL, name24 TEXT NOT NULL" +
                ",name25 TEXT NOT NULL)";

        sqLiteDatabase.execSQL(form_qry);

        String board_qry = "CREATE TABLE board_database(num INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",menual BLOB NOT NULL, board_kind TEXT NOT NULL, board_type TEXT NOT NULL, board_version TEXT NOT NULL" +
                ",board_code TEXT NOT NULL, chipset1 TEXT NOT NULL, chipset_name1 TEXT NOT NULL, chipset2 TEXT NOT NULL" +
                ",chipset_name2 TEXT NOT NULL, registration TEXT NOT NULL, request TEXT NOT NULL, model TEXT NOT NULL" +
                ",before_version TEXT NOT NULL, after_version TEXT NOT NULL, date TEXT NOT NULL, change_point TEXT NOT NULL" +
                ",writer TEXT NOT NULL, bundle TEXT NOT NULL, name19 TEXT NOT NULL, name20 TEXT NOT NULL" +
                ",name21 TEXT NOT NULL, name22 TEXT NOT NULL, name23 TEXT NOT NULL, name24 TEXT NOT NULL" +
                ",name25 TEXT NOT NULL)";

        sqLiteDatabase.execSQL(board_qry);


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

//        String qry = "DROP TABLE IF EXISTS student";
//        sqLiteDatabase.execSQL(qry);

        onCreate(sqLiteDatabase);

    }
}