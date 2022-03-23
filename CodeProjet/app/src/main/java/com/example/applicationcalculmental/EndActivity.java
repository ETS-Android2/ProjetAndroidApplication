package com.example.applicationcalculmental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    private Button reset;
    private Button home;
    private TextView scoreText;

    private double score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();

        if(intent != null) {
            if(intent.hasExtra("score")) score = intent.getDoubleExtra("score", 0.0);
        }

        scoreText = (TextView) findViewById(R.id.textViewScore);
        scoreText.setText("Score : " + score + "%");

        reset = (Button) findViewById(R.id.buttonReset);
        home = (Button) findViewById(R.id.buttonHome);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityNewGame();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityHome();
            }
        });
    }

    private void openActivityHome() { startActivity(new Intent(this, MainActivity.class)); }

    private void openActivityNewGame() {
        startActivity(new Intent(this, NewGameActivity.class));
    }
}