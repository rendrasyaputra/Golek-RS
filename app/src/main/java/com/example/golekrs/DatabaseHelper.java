package com.example.golekrs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "rensponsi.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
    // TODO Auto-generated method stub
       // db.execSQL("CREATE TABLE session(id integer PRIMARY KEY, login text)");
//        db.execSQL("CREATE TABLE user(id integer PRIMARY KEY, username text, password text)");
//        db.execSQL("INSERT INTO user(id,username, password) VALUES(1,'andrean', 'andre123')");
//        db.execSQL("INSERT INTO session(id, login) VALUES(1, 'kosong')");


        String sql = "create table datars(no integer primary key, nama text null, jambuka text null, jamtutup text null, alamat text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO datars (no, nama, jambuka, jamtutup, alamat) VALUES ('1001', 'RS Fatmawati', '07.00', '22.00','Jakarta Selatan');";
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

        String sql4 = "CREATE TABLE galon(nomor integer PRIMARY KEY, jenisgalon text null, harga integer, stok integer, alamat text null, kurir text null);";
        Log.d("Data", "onCreate: " + sql4);
        db.execSQL(sql4);
        sql4 = "INSERT INTO galon(nomor, jenisgalon, harga, stok, alamat, kurir) VALUES('001','galon gede toolol', '12.000','10','jl hang jebat', 'antok');";
        db.execSQL(sql4);

        String sql5 = "CREATE TABLE transaksi(id_transaksi integer PRIMARY KEY AUTOINCREMENT, nama text null, alamatpembeli text, jenisgalon text null, hargagalon integer, total integer, kodeadmin text null, namakurir textnull);";
        Log.d("Data", "onCreate: " + sql5);
        db.execSQL(sql5);
        sql5 = "INSERT INTO transaksi(id_transaksi, nama, alamatpembeli, jenisgalon, hargagalon, total, kodeadmin, namakurir) VALUES('101','Ali', 'jl mawar 23','Galon Mineral','13000', '13000', 'ADM01', 'Antok');";
        db.execSQL(sql5);


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
}
