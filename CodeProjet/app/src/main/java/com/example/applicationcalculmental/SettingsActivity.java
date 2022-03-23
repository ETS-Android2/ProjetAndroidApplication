package com.example.applicationcalculmental;

import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    private Button langueFr;
    private Button langueEn;
    private  android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);

        langueFr = (Button) findViewById(R.id.drap_fr);
        langueEn = (Button) findViewById(R.id.drap_gb);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        langueFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("fr");
                System.out.println("french");
                //openHomeActivity();
            }
        });

        langueEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("en");
                System.out.println("english");
                //openHomeActivity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                openHomeActivity(item);
                return true;
                case R.id.about:
                    openAboutActivity();
                    return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openHomeActivity(MenuItem item) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void openHomeActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void openAboutActivity() { startActivity(new Intent(this, AboutActivity.class)); }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
