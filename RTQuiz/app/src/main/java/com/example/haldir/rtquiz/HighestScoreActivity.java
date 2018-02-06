package com.example.haldir.rtquiz;

/**
 * Created by Haldir on 25.01.2018.
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        TextView txtScore = (TextView) findViewById(R.id.textScore);
        TextView txtHighScore = (TextView) findViewById(R.id.textHighScore);
        // Wynik z ostatniego activity (Intent)
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        // wyswietl wynik
        txtScore.setText("Twój wynik: " + score);

        // Shared Preference do zapisania najlepszego wyniku
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore",0);
        if(highscore>= score)
            txtHighScore.setText("Najwyższy wynik: "+highscore);
        else
        {
            txtHighScore.setText("Nowy wynik: "+score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }
    }

    public void onRepeatClick(View view) {
        Intent intent = new Intent(HighestScoreActivity.this, MainActivity.class);
        startActivity(intent);
    }
}