package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreOfA = 0;
    int scoreOfB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void click3(View view){
        scoreOfA += 3;
        displayForTeamA(scoreOfA);
    }

    public void click2(View view){
        scoreOfA += 2;
        displayForTeamA(scoreOfA);
    }

    public void click1(View view){
        scoreOfA += 1;
        displayForTeamA(scoreOfA);
    }

    public void click3b(View view){
        scoreOfB += 3;
        displayForTeamB(scoreOfB);
    }

    public void click2b(View view){
        scoreOfB += 2;
        displayForTeamB(scoreOfB);
    }

    public void click1b(View view){
        scoreOfB += 1;
        displayForTeamB(scoreOfB);
    }

    public void reset(View view){
        scoreOfA = scoreOfB = 0;
        displayForTeamA(scoreOfA);
        displayForTeamB(scoreOfB);
    }
}