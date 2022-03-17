package com.example.applicationcalculmental;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class NewGameActivity extends AppCompatActivity {

    private EditText gameName;
    private Button easy, medium, hard, go;

    private int chosenDifficulty = 0;
    private String chosenGameName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        gameName = (EditText) findViewById(R.id.gameName);

        easy = (Button) findViewById(R.id.easy);
        medium = (Button) findViewById(R.id.medium);
        hard = (Button) findViewById(R.id.hard);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                easy.setBackground(getResources().getDrawable(R.drawable.pressed_difficulty_btn));
                medium.setBackground(getResources().getDrawable(R.drawable.unpressed_difficulty_btn));
                hard.setBackground(getResources().getDrawable(R.drawable.unpressed_difficulty_btn));

                chosenDifficulty = 1;
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                easy.setBackground(getResources().getDrawable(R.drawable.unpressed_difficulty_btn));
                medium.setBackground(getResources().getDrawable(R.drawable.pressed_difficulty_btn));
                hard.setBackground(getResources().getDrawable(R.drawable.unpressed_difficulty_btn));

                chosenDifficulty = 2;
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                easy.setBackground(getResources().getDrawable(R.drawable.unpressed_difficulty_btn));
                medium.setBackground(getResources().getDrawable(R.drawable.unpressed_difficulty_btn));
                hard.setBackground(getResources().getDrawable(R.drawable.pressed_difficulty_btn));

                chosenDifficulty = 3;
            }
        });

        go = (Button) findViewById(R.id.launch);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chosenGameName = verificationChosenGameName(gameName);
                chosenDifficulty = verificationChosenDifficulty(chosenDifficulty);

                System.out.println("Nom de la partie : " + chosenGameName);
                System.out.println("Difficulte choisie : " + chosenDifficulty);

                if(chosenDifficulty > 0 && chosenGameName.length() > 0) {
                    switchToGameActivity(view);
                }
            }
        });
    }

    public String verificationChosenGameName(EditText gameName) {

        AlertDialog alertDialog = new AlertDialog.Builder(NewGameActivity.this).create();

        String chosenGameName = gameName.getText().toString();

        if(chosenGameName.length() == 0) {
            alertDialog.setTitle("Element manquant !");
            alertDialog.setMessage("Veuillez renseigner un nom de partie.");
            alertDialog.show();
            return "";
        } else return chosenGameName;
    }

    public int verificationChosenDifficulty(int chosenDifficulty) {
        AlertDialog alertDialog = new AlertDialog.Builder(NewGameActivity.this).create();

        if(chosenDifficulty == 0) {
            alertDialog.setTitle("Element manquant !");
            alertDialog.setMessage("Veuillez sélectionner une difficulté.");
            alertDialog.show();
        }
        return chosenDifficulty;
    }

    public void switchToGameActivity(View v) {
        Intent intent = new Intent(this, GameActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("chosenGameName", chosenGameName);
        bundle.putInt("chosenDifficulty", chosenDifficulty);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}