package com.example.applicationcalculmental;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    public Helper(@Nullable Context context) {
        super(context, "BDDAppli", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE scores " +
                "(_id INTEGER PRIMARY KEY, " +
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
}
