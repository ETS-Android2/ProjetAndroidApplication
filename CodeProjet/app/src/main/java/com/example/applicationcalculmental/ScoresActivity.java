package com.example.applicationcalculmental;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.applicationcalculmental.BDD.Helper;
import com.example.applicationcalculmental.BDD.Score;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ScoresActivity extends AppCompatActivity {

    private ListView listScores;

    private Helper helper = new Helper(ScoresActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        listScores = (ListView) findViewById(R.id.scoresList);

        Cursor cursor = helper.getAllScores();

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

        System.out.println("Nb enregistrement(s)" + helper.nbScoresOnBDD());
    }
}