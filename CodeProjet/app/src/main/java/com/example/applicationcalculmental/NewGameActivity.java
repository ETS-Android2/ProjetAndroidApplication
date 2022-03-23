package com.example.applicationcalculmental;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.applicationcalculmental.BDD.Helper;

public class NewGameActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private EditText gameName;
    private Button easy, medium, hard, go;
    private Spinner nbGameSpinner;

    private int chosenDifficulty = 0;
    private String chosenGameName;
    private int chosenNbCalcul = 0;

    private Helper helper = new Helper(NewGameActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new_game);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        nbGameSpinner = (Spinner) findViewById(R.id.nbCalculGameSpinner);

        go = (Button) findViewById(R.id.launch);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chosenGameName = verificationChosenGameName(gameName);
                chosenDifficulty = verificationChosenDifficulty(chosenDifficulty);

                chosenNbCalcul = Integer.parseInt(nbGameSpinner.getSelectedItem().toString());

                if(chosenDifficulty > 0 && chosenGameName.length() > 0) {
                    switchToGameActivity(view);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.default_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                //Toast.makeText(this, "Home", Toast.LENGTH_LONG).show();
                openHomeActivity(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public String verificationChosenGameName(EditText gameName) {

        AlertDialog alertDialog = new AlertDialog.Builder(NewGameActivity.this).create();

        String chosenGameName = gameName.getText().toString();

        if(chosenGameName.length() == 0) {
            alertDialog.setTitle("Element manquant !");
            alertDialog.setMessage("Veuillez renseigner un nom de partie.");
            alertDialog.show();
            return "";
        } else {
            if (helper.chosenGameNameIsAlreadyTaken(chosenGameName) == true) {
                alertDialog.setTitle("Nom de Partie déjà Pris !");
                alertDialog.setMessage("Veuillez renseigner un nouveau nom de partie.");
                alertDialog.show();
                return "";
            } else return chosenGameName;
        }
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
        bundle.putInt("chosenNbCalcul", chosenNbCalcul);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void openHomeActivity(MenuItem item) {
        startActivity(new Intent(this, MainActivity.class));
    }
}