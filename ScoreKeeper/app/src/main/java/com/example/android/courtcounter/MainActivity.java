package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreOfA = 0;
    int scoreOfB = 0;
    int redCardOfA = 0;
    int redCardOfB = 0;
    int yellowCardOfA = 0;
    int yellowCardOfB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Displays the score, yellow card or red card for Team A and B.
    public void display(int score, String type) {
        TextView scoreView = null;
        if (type == "scoreA") {
            scoreView= (TextView) findViewById(R.id.team_a_score);
        }
        else if (type == "yellowA"){
            scoreView = (TextView) findViewById(R.id.yellowcardNum);
        }
        else if (type == "redA"){
            scoreView = (TextView) findViewById(R.id.redcardNum);
        }
        else if (type == "scoreB"){
            scoreView = (TextView) findViewById(R.id.team_b_score);
        }
        else if (type == "yellowB"){
            scoreView = (TextView) findViewById(R.id.yellowcardNumB);
        }
        else if (type == "redB"){
            scoreView = (TextView) findViewById(R.id.redcardNumB);
        }
        scoreView.setText(String.valueOf(score));
    }

    public void goalA(View view){
        scoreOfA += 1;
        display(scoreOfA, "scoreA");
    }

    public void redA(View view){
        redCardOfA += 1;
        display(redCardOfA, "redA");
    }

    public void yellowA(View view){
        yellowCardOfA += 1;
        display(yellowCardOfA, "yellowA");
    }

    public void goalB(View view){
        scoreOfB += 1;
        display(scoreOfB, "scoreB");
    }

    public void redB(View view){
        redCardOfB += 1;
        display(redCardOfB, "redB");
    }

    public void yellowB(View view){
        yellowCardOfB += 1;
        display(yellowCardOfB, "yellowB");
    }

    public void reset(View view){
        scoreOfA = scoreOfB = 0;
        yellowCardOfA = yellowCardOfB = 0;
        redCardOfA = redCardOfB = 0;
        display(scoreOfA, "scoreA");
        display(scoreOfB, "scoreB");
        display(yellowCardOfA, "yellowA");
        display(yellowCardOfB, "yellowB");
        display(redCardOfA, "redA");
        display(redCardOfB, "redB");
    }
}