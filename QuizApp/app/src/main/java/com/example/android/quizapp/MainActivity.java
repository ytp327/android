package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(View view){
        EditText nameInput = findViewById(R.id.name);
        String name = nameInput.getText().toString();
        RadioButton quiz1Answer = findViewById(R.id.quiz1C);
        RadioButton quiz2Answer = findViewById(R.id.quiz2A);
        CheckBox quiz3AnswerA = findViewById(R.id.quiz3A);
        CheckBox quiz3AnswerB = findViewById(R.id.quiz3B);
        CheckBox quiz3AnswerC = findViewById(R.id.quiz3C);
        CheckBox quiz3AnswerD = findViewById(R.id.quiz3D);
        CheckBox quiz3AnswerE = findViewById(R.id.quiz3E);
        CheckBox quiz3AnswerF = findViewById(R.id.quiz3F);
        EditText quiz4Answer = findViewById(R.id.quiz4Answer);
        String result = getResources().getString(R.string.result_heading)+ " " + name + "\n";
        if (quiz1Answer.isChecked()) result +=  getResources().getString(R.string.quiz1Correct);
        else result +=  getResources().getString(R.string.quiz1Wrong);
        result += "\n";
        if (quiz2Answer.isChecked()) result +=  getResources().getString(R.string.quiz2Correct);
        else result +=  getResources().getString(R.string.quiz2Wrong);
        result += "\n";
        if (quiz3AnswerA.isChecked() && !quiz3AnswerB.isChecked() && quiz3AnswerC.isChecked() &&
                quiz3AnswerD.isChecked() && quiz3AnswerE.isChecked() && !quiz3AnswerF.isChecked())
            result +=  getResources().getString(R.string.quiz3Correct);
        else result +=  getResources().getString(R.string.quiz3Wrong);
        result += "\n";
        if (quiz4Answer.getText().toString().equals("Android Debug Bridge") ||
                quiz4Answer.getText().toString().equals("Android debug bridge") ||
                quiz4Answer.getText().toString().equals("android debug bridge"))
            result +=  getResources().getString(R.string.quiz4Correct);
        else result +=  getResources().getString(R.string.quiz4Wrong);
        Toast.makeText(getApplicationContext(),
                getResources().getString(R.string.submit_toast), Toast.LENGTH_SHORT).show();
        TextView resultOutput = findViewById(R.id.result);
        resultOutput.setText(result);
    }
}