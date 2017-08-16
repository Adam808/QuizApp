package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswers(View view) {
        int score = 0;

        //Create RadioButton answer variables
        RadioButton answer1 = (RadioButton) findViewById(R.id.answer_1);
        RadioButton answer3 = (RadioButton) findViewById(R.id.answer_3);
        RadioButton answer5 = (RadioButton) findViewById(R.id.answer_5);
        RadioButton answer7 = (RadioButton) findViewById(R.id.answer_7);

        //Create text answer variables
        EditText question2 = (EditText) findViewById(R.id.answer_2);
        String answer2 = question2.getText().toString();
        EditText question4 = (EditText) findViewById(R.id.answer_4);
        String answer4 = question4.getText().toString();
        EditText question8 = (EditText) findViewById(R.id.answer_8);
        String answer8 = question8.getText().toString();

        CheckBox answer6Rorschach = (CheckBox) findViewById(R.id.a6_rorschach);
        CheckBox answer6Havok = (CheckBox) findViewById(R.id.a6_havok);
        CheckBox answer6Manhattan = (CheckBox) findViewById(R.id.a6_manhattan);
        CheckBox answer6NiteOwl = (CheckBox) findViewById(R.id.a6_nite_owl);
        CheckBox answer6Hawkeye = (CheckBox) findViewById(R.id.a6_hawkeye);

        //Create Button and String arrays
        boolean[] correctButtons = {answer1.isChecked(), answer3.isChecked(), answer5.isChecked(), answer7.isChecked()};
        String[] correctStrings = {"Tatooine", "The Dude", "Trinity"};
        String[] answerStrings = {answer2, answer4, answer8};

        //Check for correct RadioButton answers and update score
        for (int i=0; i<correctButtons.length; i++) {
            if (correctButtons[i]) {
                score += 1;
            }
        }

        //Check for correct EditText answers and update score
        for (int i=0; i<correctStrings.length; i++) {
            if (answerStrings[i].equals(correctStrings[i])){
                score += 1;
            }
        }

        //Check CheckBox answer and update score
        if ((answer6Rorschach.isChecked() && answer6Manhattan.isChecked()) && (answer6NiteOwl.isChecked()) &&
                (!answer6Havok.isChecked() && !answer6Hawkeye.isChecked())) {
            score += 1;
        }

        //Toasts
        String totalScore = Integer.toString(score);
        if (score < 4) {
            String scoreMessage = getResources().getString(R.string.try_again);
            totalScore += scoreMessage;
            Toast toast = Toast.makeText(getApplicationContext(), totalScore, Toast.LENGTH_SHORT);
            toast.show();
        } else if (score < 8) {
            String scoreMessage = getResources().getString(R.string.good);
            totalScore += scoreMessage;
            Toast toast = Toast.makeText(getApplicationContext(), totalScore, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            String scoreMessage = getResources().getString(R.string.perfect);
            totalScore += scoreMessage;
            Toast toast = Toast.makeText(getApplicationContext(), totalScore, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
