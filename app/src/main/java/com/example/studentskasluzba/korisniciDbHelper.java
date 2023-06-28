package com.example.studentskasluzba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class korisniciDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "korisnici.db";
    private static final int DATABASE_VERSION = 1;

    // Define your schema here
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE IF NOT EXISTS korisnici (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, role TEXT)";

    public korisniciDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your tables using the defined schema
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Perform database upgrade operations here
    }
}
