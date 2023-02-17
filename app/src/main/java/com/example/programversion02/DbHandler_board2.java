package com.example.programversion02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHandler_board2 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "board_spinner2";
    private static final String TABLE_NAME = "labels";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name1";

    public DbHandler_board2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Category table create query
        String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT)";
        db.execSQL(CREATE_ITEM_TABLE);


        CREATE_ITEM_TABLE = "INSERT INTO labels(name1) VALUES('전체')";
        db.execSQL(CREATE_ITEM_TABLE);
        CREATE_ITEM_TABLE = "INSERT INTO labels(name1) VALUES('AVR')";
        db.execSQL(CREATE_ITEM_TABLE);
        CREATE_ITEM_TABLE = "INSERT INTO labels(name1) VALUES('PSOC')";
        db.execSQL(CREATE_ITEM_TABLE);
        CREATE_ITEM_TABLE = "INSERT INTO labels(name1) VALUES('항목추가')";
        db.execSQL(CREATE_ITEM_TABLE);


    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    /**
     * Inserting new lable into lables table
     */
    public void insertLabel(String label) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, label);//column name, column value
        // Inserting Row
        db.insert(TABLE_NAME, null, values);//tableName, nullColumnHack, CotentValues
        db.close(); // Closing database connection
    }

    public void updateLabel(String label, String label1) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, label);//column name, column value


        db.execSQL("UPDATE labels SET name1='"+label1+"' WHERE name1='"+label+"'");
        db.close(); // Closing database connection
    }

    public void deleteLabel(String label){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, label);//column name, column value

        db.execSQL("DELETE FROM labels WHERE name1='"+label+"'");
        db.close(); // Closing database connection
    }

    /**
     * Getting all labels
     * returns list of labels
     */
    public List<String> getAllLabels() {
        List<String> list = new ArrayList<String>();

            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_NAME;

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    list.add(cursor.getString(1));//adding 2nd column data
                } while (cursor.moveToNext());
            }
            // closing connection
            cursor.close();
            db.close();
            // returning lables


        return list;
    }
}