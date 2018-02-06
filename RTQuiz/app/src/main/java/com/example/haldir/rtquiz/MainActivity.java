package com.example.haldir.rtquiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionBank mQuestionLibrary = new QuestionBank();

    private TextView mScoreView;   // ilosc pkt
    private TextView mQuestionView;  //obecne pytanie
    private Button mButtonChoice1; // wybor 1
    private Button mButtonChoice2; // wybor 2
    private Button mButtonChoice3; // wybor 3
    private Button mButtonChoice4; // wybor 4

    private String mAnswer;  // prawidlowa odp
    private int mScore = 0;  // ilosc pkt
    private int mQuestionNumber = 0; // numer pytania

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.questionView);
        mButtonChoice1 = (Button)findViewById(R.id.answerAButton);
        mButtonChoice2 = (Button)findViewById(R.id.answerBButton);
        mButtonChoice3 = (Button)findViewById(R.id.answerCButton);
        mButtonChoice4 = (Button)findViewById(R.id.answerDButton);

        mQuestionLibrary.initQuestions(getApplicationContext());
        updateQuestion();
        updateScore(mScore);
    }

    private void updateQuestion(){
        // sprawdzanie, czy nie wyszlismy za liste pytan
        if(mQuestionNumber<mQuestionLibrary.getLength() ){
            // nastepne pytanie
            // przyciski odp.
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            Toast.makeText(MainActivity.this, "To ostatnie pytanie... zagraj ponownie!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", mScore); // pass the current score to the second screen
            startActivity(intent);
        }
    }

    // wyswietl calkowity wynik gracza
    private void updateScore(int point) {
        mScoreView.setText(""+mScore+"/"+mQuestionLibrary.getLength());
    }

    public void onClick(View view) {
        //implementacja guzika "answer"
        Button answer = (Button) view;
        // wartosc poprawna, inkrementuj punkty
        if (answer.getText().equals(mAnswer)){
            mScore = mScore + 1;
            Toast.makeText(MainActivity.this, "Prawidłowo!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(MainActivity.this, "Błąd!", Toast.LENGTH_SHORT).show();
        // wyswietl punkty gracza
        updateScore(mScore);
        // jesli odpowiedzial, idz dalej
        updateQuestion();
    }
}