package com.example.applicationcalculmental.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Helper extends SQLiteOpenHelper {

    public Helper(@Nullable Context context) {
        super(context, "BDDAppli", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE scores " +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(20) NOT NULL, " +
                "difficulty VARCHAR(8) NOT NULL," +
                "score REAL NOT NULL," +
                "date DATE NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS scores");
        onCreate(db);
    }

    public void insertScore(Score score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", score.getName());
        cv.put("difficulty", score.getDifficulty());
        cv.put("score", score.getScore());
        cv.put("date", String.valueOf(score.getDate()));

        db.insert("scores", null, cv);
        db.close();
    }

    public void deleteScore(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("scores", "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public int nbScoresOnBDD() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT COUNT(_id) FROM scores", null);

        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public Cursor getAllScores() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM scores", null);
        return cursor;
    }

    public Score getOneScore(int id) throws ParseException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("scores", new String[]{"_id", "name", "difficulty", "score", "date"},
                "_id=?", new String[]{String.valueOf(id)}, null, null, null);

        cursor.moveToFirst();

        String strDate = cursor.getString(4);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        Date date = sdf.parse(strDate);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        Score score = new Score(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getDouble(3),
                sqlDate);

        return score;
    }

    public Cursor getTenLastScore() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM scores ORDER BY _id DESC LIMIT 10", null);
        return cursor;
    }

    public Cursor getTenBestScore() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM scores ORDER BY score DESC LIMIT 10", null);
        return cursor;
    }

    public boolean chosenGameNameIsAlreadyTaken(String chosenGameName) {
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor cursor = db.query("scores", new String[]{"_id", "name", "difficulty", "score", "date"},
                    "name=?", new String[]{String.valueOf(chosenGameName)}, null, null, null);

            return (cursor.getCount() != 0) ? true : false;
        } catch (Exception e) {
            return false;
        }
    }
}
