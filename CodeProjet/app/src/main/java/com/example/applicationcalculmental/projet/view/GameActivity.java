package com.example.applicationcalculmental.projet.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationcalculmental.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private Long Reponse =0L;
    private Long Point = 0L;
    private Long nbVies = 3L;
    private TextView textViewCalcul, textViewResultat, textViewScore;
    private Long BORNE_SUPERIEUR = 9999L;
    private Long BORNE_INFERIEUR = -9999L;
<<<<<<< Updated upstream:CodeProjet/app/src/main/java/com/example/applicationcalculmental/projet/view/GameActivity.java
=======
    private int chosenDifficulty;
    private String chosenDifficultyString;
    private String chosenGameName;
    private int chosenNbCalcul = 5;
    private android.support.v7.widget.Toolbar toolbar;
    private boolean negatif = false;
    private Long resultat;
    private int compteur = 1;
    private boolean validiteValider = false;
    private double score;
>>>>>>> Stashed changes:CodeProjet/app/src/main/java/com/example/applicationcalculmental/GameActivity.java


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textViewCalcul = findViewById(R.id.textviewCalcul);
        textViewResultat = findViewById(R.id.textViewResultat);
        textViewScore = findViewById(R.id.textViewScore);
        long resultat = calcul(2);
        Button bouton1 = findViewById(R.id.button_1);
        bouton1.setOnClickListener(view -> ajouterNombre(1));
        Button bouton2 = findViewById(R.id.button_2);
        bouton2.setOnClickListener(view -> ajouterNombre(2));
        Button bouton3 = findViewById(R.id.button_3);
        bouton3.setOnClickListener(view -> ajouterNombre(3));
        Button bouton4 = findViewById(R.id.button_4);
        bouton4.setOnClickListener(view -> ajouterNombre(4));
        Button bouton5 = findViewById(R.id.button_5);
        bouton5.setOnClickListener(view -> ajouterNombre(5));
        Button bouton6 = findViewById(R.id.button_6);
        bouton6.setOnClickListener(view -> ajouterNombre(6));
        Button bouton7 = findViewById(R.id.button_7);
        bouton7.setOnClickListener(view -> ajouterNombre(7));
        Button bouton8 = findViewById(R.id.button_8);
        bouton8.setOnClickListener(view -> ajouterNombre(8));
        Button bouton9 = findViewById(R.id.button_9);
        bouton9.setOnClickListener(view -> ajouterNombre(9));
        Button bouton0 = findViewById(R.id.button_0);
        bouton0.setOnClickListener(view -> ajouterNombre(0));
        Button boutonMoins = findViewById(R.id.buttonMoins);
        boutonMoins.setOnClickListener(view -> nombreNegatif());
        Button boutonValider = findViewById(R.id.buttonValider);
<<<<<<< Updated upstream:CodeProjet/app/src/main/java/com/example/applicationcalculmental/projet/view/GameActivity.java
        boutonValider.setOnClickListener(view -> verifCalcul(resultat));
=======

        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (compteur < 5 && nbVies > 0){
                    if(!validiteValider){
                        verifCalcul();
                        boutonValider.setText("Suivant");
                        validiteValider = true;
                    }else{
                        videTextViewResultat();
                        textViewResultat.setTextColor(Color.DKGRAY);
                        resultat = calcul(chosenDifficulty);
                        compteur++;
                        boutonValider.setText("Valider");
                        validiteValider = false;
                    }
                }else{
                    verifCalcul();
                    switchToEndActivity();
                }
            }
        });
>>>>>>> Stashed changes:CodeProjet/app/src/main/java/com/example/applicationcalculmental/GameActivity.java
        Button boutonEffacer = findViewById(R.id.buttonEffacer);
        boutonEffacer.setOnClickListener(view -> videTextViewResultat());

<<<<<<< Updated upstream:CodeProjet/app/src/main/java/com/example/applicationcalculmental/projet/view/GameActivity.java
=======
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                openHomeActivity(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void switchToEndActivity() {
        Intent intent = new Intent(this, EndActivity.class);

        Bundle bundle = new Bundle();
        bundle.putDouble("score", Point * 100 / chosenNbCalcul);

        intent.putExtras(bundle);

        startActivity(intent);

        /*
        Bundle bundle = new Bundle();
        bundle.putString("chosenName", chosenGameName);

        switch(chosenDifficulty){
            case 1:
                chosenDifficultyString = "facile";
                break;
            case 2:
                chosenDifficultyString = "moyen";
                break;
            case 3:
                chosenDifficultyString = "difficile";
                break;
        }

        bundle.putString("chosenDifficulty", chosenDifficultyString);
        bundle.putInt()
         */
>>>>>>> Stashed changes:CodeProjet/app/src/main/java/com/example/applicationcalculmental/GameActivity.java
    }

    private void ajouterNombre(Integer valeur){
            if(10*Reponse+valeur > BORNE_SUPERIEUR){
                Toast.makeText(this,getString(R.string.message_valeur_trop_grande),Toast.LENGTH_LONG).show();
            }
            else if(10*Reponse-valeur < BORNE_INFERIEUR){
                Toast.makeText(this,getString(R.string.message_valeur_trop_petite),Toast.LENGTH_LONG).show();
            }
            else if(Reponse < 0) {
                Reponse = 10 * Reponse-valeur;
            }else {
                Reponse = 10 * Reponse+valeur;
            }
        majTextViewResultat();
    }

    private void nombreNegatif(){
        Reponse = - Reponse;
        majTextViewResultat();
    }

    private void majTextViewResultat() {
        String valeurAAfficher = "";

            valeurAAfficher = Reponse.toString();

        textViewResultat.setText(valeurAAfficher);
    }

    private void majTextViewScore() {
        String valeurAAfficher = "";


        valeurAAfficher = "Score : " + Point;

        textViewScore.setText(valeurAAfficher);

    }

    private List<Long> genereNombreAlea(int difficulte){
        List<Long> nombre = new ArrayList<Long>();
        Random random = new Random();
        switch (difficulte){
            case 1:
                nombre.add((long) random.nextInt(10) + 1);
                nombre.add((long) random.nextInt(10) + 1);
                break;

            case 2:
                nombre.add((long) random.nextInt(15) + 11);
                nombre.add((long) random.nextInt(15) + 11);
                break;

            case 3:
                nombre.add((long) random.nextInt(25) + 26);
                nombre.add((long) random.nextInt(25) + 26);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + difficulte);
        }
        return nombre;
    }

    private Long calcul(int difficulte)  {
        List<Long> nombre;
        List<String> Elements = new ArrayList<String>();
        int operateur;
        Long resultat = 0L;
        String texte;

        nombre = genereNombreAlea(difficulte);

        for(Long nb : nombre){
            Elements.add(Long.toString(nb));
        }

        Random random = new Random();
        operateur =  random.nextInt(4) + 1;
        switch (operateur){
            case 1:
                resultat = nombre.get(0) + nombre.get(1);
                texte = Elements.get(0) + "+" + Elements.get(1);
                textViewCalcul.setText(texte);
                break;

            case 2:
                resultat = nombre.get(0) - nombre.get(1);
                texte = Elements.get(0) + "-" + Elements.get(1);
                textViewCalcul.setText(texte);
                break;

            case 3:
                resultat = nombre.get(0) * nombre.get(1);
                texte = Elements.get(0) + "x" + Elements.get(1);
                textViewCalcul.setText(texte);
                break;

            case 4:
                resultat = nombre.get(0) / nombre.get(1);
                texte = Elements.get(0) + "/" + Elements.get(1);
                textViewCalcul.setText(texte);
                break;
        }
        return resultat;
    }

    private boolean divisionException(long resultat){

        return  true;
    }

    private void verifCalcul(long resultat){
        //String res = Long.toString(resultat);
        //String texte = textViewCalcul + "=" + res;
        //textViewCalcul.setText(texte);
        if (resultat == Reponse){
            Point++;
            textViewResultat.setTextColor(Color.GREEN);
            majTextViewScore();
        }
        else{
            nbVies--;
            textViewResultat.setTextColor(Color.RED);
        }
    }

    private boolean videTextViewResultat() {
        textViewResultat.setText("");
        Reponse = 0L;
        return true;
    }
}