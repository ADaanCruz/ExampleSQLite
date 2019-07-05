package com.example.examplesqlite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.util.Log;

import java.util.ArrayList;

public class SQLite {
    private Sql sql;
    private SQLiteDatabase db;

    public SQLite(Context context) {
        sql = new Sql(context);
    }

    public SQLite() {
    }

    public void Open() {
        db = sql.getReadableDatabase();
        Log.i("SQLite", "Se abrió conexión a la base de datos" + sql.getDatabaseName());
    }

    public void Close() {
        db.close();
        Log.i("SQLite", "Se cerró conexión a la base de datos" + sql.getDatabaseName());
    }

    public boolean InsertSchedule(int id, String title, String grade, String complete,
                                     String date, String message) {
        ContentValues content = new ContentValues();
        content.put("id", id);
        content.put("title", title);
        content.put("grade", grade);
        content.put("complete", complete);
        content.put("date", date);
        content.put("message", message);

        return (db.insert("schedule", null, content) != (-1));
    }

    public Cursor getSchedules() {
        return db.rawQuery("SELECT * FROM schedule", null);
    }

    public ArrayList<String> getSchedule(Cursor cursor) {
        ArrayList<String> list = new ArrayList<>();
        String item;
        if (cursor.moveToFirst()) {
            do {
                item = "";
                item += "ID: " + cursor.getString(0) + "\r\n";
                item += "Titulo: " + cursor.getString(1) + "\r\n";
                item += "Grado: " + cursor.getString(2) + "\r\n";
                item += "Completo: " + cursor.getString(3) + "\r\n";
                item += "Fecha: " + cursor.getString(4) + "\r\n";
                item += "Mensaje: " + cursor.getString(5) + "\r\n";

                list.add(item);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<String> getId(Cursor cursor) {
        ArrayList<String> list = new ArrayList<>();
        String item = "";
        if (cursor.moveToFirst()) {
            do {
                item += "ID: [" + cursor.getInt(0) + "]\r\n";
                list.add(item);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public String UpdateSchedule(int id, String title, String grade, String complete,
                                  String date, String message) {
        ContentValues content = new ContentValues();
        content.put("id", id);
        content.put("title", title);
        content.put("grade", grade);
        content.put("complete", complete);
        content.put("date", date);
        content.put("message", message);
        int cant = db.update("schedule", content, "id="+id, null);
        if (cant == 1) {
            return "Agenda modificada";
        } else {
            return "Error inesperado";
        }
    }

    public Cursor getCant(int id) {
        return db.rawQuery("SELECT * FROM schedule WHERE id=" + id, null);
    }

    public int Eliminar (Editable id) {
        return db.delete("schedule", "id="+id, null);
    }
}
