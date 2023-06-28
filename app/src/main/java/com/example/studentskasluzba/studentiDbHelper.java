package com.example.studentskasluzba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class studentiDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "studenti.db";
    private static final int DATABASE_VERSION = 3;

    // Create parent table
    private static final String CREATE_PARENT_TABLE =
            "CREATE TABLE " + ParentTableStudenti.TABLE_NAME + " (" +
                    ParentTableStudenti.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ParentTableStudenti.COLUMN_USER + " TEXT," +
                    ParentTableStudenti.COLUMN_IME + " TEXT," +
                    ParentTableStudenti.COLUMN_PREZIME + " TEXT," +
                    ParentTableStudenti.COLUMN_JMBG + " TEXT," +
                    ParentTableStudenti.COLUMN_INDEKS + " TEXT)";

    // Create child table
    private static final String CREATE_CHILD_TABLE =
            "CREATE TABLE " + ChildTableStudenti.TABLE_NAME + " (" +
                    ChildTableStudenti.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ChildTableStudenti.COLUMN_PARENT_ID + " INTEGER," +
                    ChildTableStudenti.COLUMN_IMEPREDMETA + " TEXT," +
                    ChildTableStudenti.COLUMN_GODINA + " TEXT," +
                    ChildTableStudenti.COLUMN_OSV1 + " TEXT," +
                    ChildTableStudenti.COLUMN_OSV2 + " TEXT," +
                    ChildTableStudenti.COLUMN_OSV3 + " TEXT," +
                    ChildTableStudenti.COLUMN_OSV4 + " TEXT," +
                    ChildTableStudenti.COLUMN_OSV5 + " TEXT," +
                    "FOREIGN KEY (" + ChildTableStudenti.COLUMN_PARENT_ID + ") " +
                    "REFERENCES " + ParentTableStudenti.TABLE_NAME + "(" + ParentTableStudenti.COLUMN_ID + "))";

    public studentiDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PARENT_TABLE);
        db.execSQL(CREATE_CHILD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ParentTableStudenti.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ChildTableStudenti.TABLE_NAME);

        // Recreate tables
        onCreate(db);
    }
}

