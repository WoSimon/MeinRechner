package com.example.meinrechner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "berechnungen";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_OP1 = "operand1";
    private static final String COLUMN_OPERATOR = "operator";
    private static final String COLUMN_OP2 = "operand2";
    private static final String COLUMN_RESULT = "result";
    private static final String COLUMN_TIMESTAMP = "timestamp";



    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_OP1 + " DOUBLE, " + COLUMN_OPERATOR + " TEXT, " + COLUMN_OP2 + " DOUBLE, " + COLUMN_RESULT + " DOUBLE, " + COLUMN_TIMESTAMP + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addCalculation(double op1, String operator, double op2, double res, String timestamp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_OP1, op1);
        cv.put(COLUMN_OPERATOR, operator);
        cv.put(COLUMN_OP2, op2);
        cv.put(COLUMN_RESULT, res);
        cv.put(COLUMN_TIMESTAMP, timestamp);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Konnte den Eintrag nicht der Datanbank hinzufügen", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAlldata(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void deleteOneRow(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Konnte Reihe nicht löschen", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Löschen erfolgreich", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
