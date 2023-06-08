package com.example.golekrs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "rumahsakit.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
//        db.execSQL("CREATE TABLE session(id integer PRIMARY KEY, login text)");
//        db.execSQL("CREATE TABLE pasien(nope text PRIMARY KEY, nama text, alamat text)");
//        db.execSQL("CREATE TABLE user(id integer PRIMARY KEY AUTOINCREMENT, username text, password text)");
//        db.execSQL("INSERT INTO session(id, login) VALUES(1, 'kosong')");
//        db.execSQL("INSERT INTO user(id, username, password) VALUES(1, 'andrean', 'andre123')");
        String sql = "create table pasien(no text primary key, nama text null, alamat text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO pasien(no, nama,  alamat) VALUES('081379092342', 'Fatmawati', 'Jl mawar no 42');";
        db.execSQL(sql);

        String sql2 = "CREATE TABLE session(id integer PRIMARY KEY, login text null);";
        Log.d("Data", "onCreate: " + sql2);
        db.execSQL(sql2);
        sql2 = "INSERT INTO session(id, login) VALUES(1, 'kosong');";
        db.execSQL(sql2);

        String sql3 = "CREATE TABLE user(id integer PRIMARY KEY, username text null, password text null);";
        Log.d("Data", "onCreate: " + sql3);
        db.execSQL(sql3);
        sql3 = "INSERT INTO user(id,username, password) VALUES(1,'andrean', 'andre123');";
        db.execSQL(sql3);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)
    {
        // TODO Auto-generated method stub
    }

    //check session
    public Boolean checkSession(String sessionValues) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM session WHERE login = ?", new String[]{sessionValues});
        if (cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    //upgrade session
    public Boolean upgradeSession(String sessionValues, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login", sessionValues);
        long update = db.update("session", contentValues, "id="+id, null);
        if (update == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    //check login
    public Boolean checkLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE username = ? AND password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long insert = db.insert("user", null, contentValues);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
