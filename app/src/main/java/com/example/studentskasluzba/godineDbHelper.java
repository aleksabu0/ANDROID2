package com.example.studentskasluzba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class godineDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "godine.db";
    private static final int DATABASE_VERSION = 2;

    // Define your schema here
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE IF NOT EXISTS godine (id INTEGER PRIMARY KEY AUTOINCREMENT, godina TEXT)";

    public godineDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your tables using the defined schema
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "godine");

        // Recreate tables
        onCreate(db);
    }
}
