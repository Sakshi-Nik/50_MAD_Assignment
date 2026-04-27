package com.example.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "StudentDB";
    public static final String TABLE_NAME = "students";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE students(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }

    // INSERT
    public boolean insertData(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        long result = db.insert(TABLE_NAME, null, cv);
        return result != -1;
    }

    // READ
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM students", null);
    }

    // UPDATE
    public boolean updateData(String id, String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        int result = db.update(TABLE_NAME, cv, "id=?", new String[]{id});
        return result > 0;
    }

    // DELETE
    public int deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id=?", new String[]{id});
    }
}