package com.example.applicationcalculmental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.applicationcalculmental.BDD.Helper;
import com.example.applicationcalculmental.BDD.Score;

public class GameActivity extends AppCompatActivity {

    private int chosenDifficulty;
    private String chosenGameName;

    private Button insert, show, delete;

    private Helper helper = new Helper(GameActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();

        if(intent != null) {
            if(intent.hasExtra("chosenGameName")) chosenGameName = intent.getStringExtra("chosenGameName");
            if(intent.hasExtra("chosenDifficulty")) chosenDifficulty = intent.getIntExtra("chosenDifficulty", 1);
        }

        insert = (Button) findViewById(R.id.insert);
        show = (Button) findViewById(R.id.show);
        delete = (Button) findViewById(R.id.delete);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Score score = new Score("TEST", 25.79, 2);

                helper.insertScore(score);

                startActivity(new Intent(GameActivity.this, ScoresActivity.class));
            }
        });
    }
}


