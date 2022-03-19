package com.example.applicationcalculmental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    private int chosenDifficulty;
    private String chosenGameName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();

        if(intent != null) {
            if(intent.hasExtra("chosenGameName")) chosenGameName = intent.getStringExtra("chosenGameName");
            if(intent.hasExtra("chosenDifficulty")) chosenDifficulty = intent.getIntExtra("chosenDifficulty", 1);
        }

        System.out.println(chosenGameName);
        System.out.println(chosenDifficulty);
    }
}


