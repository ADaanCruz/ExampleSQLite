package com.example.examplesqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sql extends SQLiteOpenHelper {

    private static final String database = "example_sqlite";
    private static final int VERSION = 1;
    private final String table_schedule =
            "CREATE TABLE schedule (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "title TEXT NOT NULL," +
                "grade TEXT NOT NULL," +
                "complete TEXT NOT NULL," +
                "date TEXT NOT NULL," +
                "message TEXT NOT NULL" +
            ")";

    public Sql(@Nullable Context context) {
        super(context, database, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_schedule);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion>oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS schedule");
            db.execSQL(table_schedule);
        }
    }
}
