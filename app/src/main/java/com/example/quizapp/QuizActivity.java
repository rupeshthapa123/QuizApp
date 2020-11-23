package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {

    private Button submit;
    private int score;
    private RadioGroup numOneRadionGroup;
    private RadioGroup numTwoRadionGroup;
    private RadioGroup numFiveRadionGroup;

    private EditText editText;
    private CheckBox adventureCheckbox;
    private CheckBox combatCheckbox;
    private CheckBox puzzleCheckbox;
    private CheckBox battleCheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submit  =  findViewById(R.id.submit_button);
        editText = findViewById(R.id.edit_text);
        adventureCheckbox = findViewById(R.id.adventure_checkbox);
        combatCheckbox = findViewById(R.id.combat_checkbox);
        puzzleCheckbox = findViewById(R.id.puzzle_checkbox);
        battleCheckbox = findViewById(R.id.battlerroyl_checkbox);
        numOneRadionGroup = findViewById(R.id.num_one_radio_group);
        numTwoRadionGroup = findViewById(R.id.num_two_radio_group);
        numFiveRadionGroup = findViewById(R.id.num_five_radio_group);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;

                if(numOneRadionGroup.getCheckedRadioButtonId() == R.id.batle_radio){
                    score += 1;
                }

                if(numTwoRadionGroup.getCheckedRadioButtonId() == R.id.dec2017_radio){
                    score += 1;
                }

                String question3Answer = editText.getText().toString();
                if(question3Answer.equalsIgnoreCase("100")){
                    score += 1;
                }

                if(battleCheckbox.isChecked() && !adventureCheckbox.isChecked() && !puzzleCheckbox.isChecked()
                        && !combatCheckbox.isChecked()){
                    score += 1;
                }

                if(numFiveRadionGroup.getCheckedRadioButtonId() == R.id.sanhok_radio){
                    score += 1;
                }
                Intent  intent = new Intent(QuizActivity.this,  ScoreActivity.class);
                intent.putExtra("SCORE",  score);
                startActivity(intent);
            }
        });
    }
}