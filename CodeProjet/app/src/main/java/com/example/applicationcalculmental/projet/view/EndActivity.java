package com.example.applicationcalculmental.projet.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.applicationcalculmental.R;

public class EndActivity extends AppCompatActivity {

    private double score;
    private TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Intent i = getIntent();

        if(i != null) {
            if(i.hasExtra("score")) score = i.getDoubleExtra("score", 0);
        }

        textViewScore = findViewById(R.id.textViewScore);
        majScore();

        Button boutonRecommencer = findViewById(R.id.buttonReset);
        boutonRecommencer.setOnClickListener(view -> recommencerPartie());
        Button boutonAccueil = findViewById(R.id.buttonHome);
        boutonAccueil.setOnClickListener(view -> retourAccueil());
    }

    private void majScore(){
        String valeurAAfficher = Double.toString(score) + "%";
        textViewScore.setText(valeurAAfficher);
    }

    private void recommencerPartie(){
        Intent intent = new Intent(this, GameActivity.class);


        startActivity(intent);
    }

    private void retourAccueil(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}