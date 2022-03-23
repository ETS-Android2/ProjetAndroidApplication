package com.example.applicationcalculmental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about);

        home = (Button) findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityHome();
            }
        });

    }

    public void openActivityHome() {
        startActivity(new Intent(this, MainActivity.class));
    }
}