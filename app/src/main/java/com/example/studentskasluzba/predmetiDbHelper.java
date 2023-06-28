package com.example.studentskasluzba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class predmetiDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "predmeti.db";
    private static final int DATABASE_VERSION = 3;

    // Create parent table
    private static final String CREATE_PARENT_TABLE =
            "CREATE TABLE " + ParentTablePredmeti.TABLE_NAME + " (" +
                    ParentTablePredmeti.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ParentTablePredmeti.COLUMN_IMEPREDMETA + " TEXT)";

    // Create child table
    private static final String CREATE_CHILD_TABLE =
            "CREATE TABLE " + ChildTablePredmeti.TABLE_NAME + " (" +
                    ChildTablePredmeti.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ChildTablePredmeti.COLUMN_PARENT_ID + " INTEGER," +
                    ChildTablePredmeti.COLUMN_GODINA + " TEXT," +
                    ChildTablePredmeti.COLUMN_K1 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MIN1 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MAX1 + " TEXT," +
                    ChildTablePredmeti.COLUMN_K2 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MIN2 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MAX2 + " TEXT," +
                    ChildTablePredmeti.COLUMN_K3 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MIN3 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MAX3 + " TEXT," +
                    ChildTablePredmeti.COLUMN_K4 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MIN4 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MAX4 + " TEXT," +
                    ChildTablePredmeti.COLUMN_K5 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MIN5 + " TEXT," +
                    ChildTablePredmeti.COLUMN_MAX5 + " TEXT," +
                    "FOREIGN KEY (" + ChildTablePredmeti.COLUMN_PARENT_ID + ") " +
                    "REFERENCES " + ParentTablePredmeti.TABLE_NAME + "(" + ParentTablePredmeti.COLUMN_ID + "))";

    public predmetiDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PARENT_TABLE);
        db.execSQL(CREATE_CHILD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*if (oldVersion < 2) {
            // Upgrade operations for version 1 to version 2
            db.execSQL(UPDATE_CHILD_TABLE);
        }*/

        // ... Add more upgrade operations as needed for other versions ...

        // Note: Be careful when performing database upgrades to avoid data loss or corruption

        // After the upgrade, you can recreate tables or modify existing data as necessary

        // Drop existing tables
        db.execSQL("DROP TABLE IF EXISTS " + ParentTablePredmeti.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ChildTablePredmeti.TABLE_NAME);

        // Recreate tables
        onCreate(db);
    }
}
