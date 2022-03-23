package com.example.applicationcalculmental;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.applicationcalculmental.BDD.Helper;
import com.example.applicationcalculmental.BDD.Score;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ScoresActivity extends AppCompatActivity {

    private ListView listScores;
    private ListView bestListScores;

    private Helper helper = new Helper(ScoresActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_scores);


        listScores = (ListView) findViewById(R.id.scoresList);
        bestListScores = (ListView) findViewById(R.id.bestScoresList);

        Cursor cursor = helper.getTenLastScore();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                ScoresActivity.this,
                R.layout.score_format,
                cursor,
                new String[]{
                        cursor.getColumnName(1),
                        cursor.getColumnName(2),
                        cursor.getColumnName(3),
                        cursor.getColumnName(4)},
                new int[]{R.id.gameName, R.id.score, R.id.difficulty, R.id.date}, 0
        );

        listScores.setAdapter(adapter);

        Cursor cursor2 = helper.getTenBestScore();

        SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(
                ScoresActivity.this,
                R.layout.score_format,
                cursor2,
                new String[]{
                        cursor.getColumnName(1),
                        cursor.getColumnName(2),
                        cursor.getColumnName(3),
                        cursor.getColumnName(4)},
                new int[]{R.id.gameName, R.id.score, R.id.difficulty, R.id.date}, 0
        );

        bestListScores.setAdapter(adapter2);
    }
}