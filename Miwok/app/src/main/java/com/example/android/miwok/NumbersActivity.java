package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> englishNumbers = new ArrayList<>();
        englishNumbers.addAll(Arrays.asList("one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten"));
        LinearLayout numbersView = findViewById(R.id.NumbersView);
        TextView numWord;
        for (int i = 0; i < 10; i++){
            numWord = new TextView(this);
            numWord.setText(englishNumbers.get(i));
            numbersView.addView(numWord);
        }
    }
}