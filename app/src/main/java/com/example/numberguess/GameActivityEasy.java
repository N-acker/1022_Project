package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameActivityEasy extends AppCompatActivity {

    private int randomNum;
    private Button getNumber;
    private String output;
    private int pointsCounter = 0;
    private int currentPoints;
    private int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_easy);


        randomNum = getLevel.getRandomNum("easy");


        getNumber=(Button) findViewById(R.id.guessButton);
        getNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textInput= (EditText) findViewById(R.id.guessText);
                String convertTextToString=textInput.getText().toString();
                int userChoice=getLevel.toInteger(convertTextToString);


               if(getLevel.checkAnswerCorrect(randomNum, userChoice) == true)
               {
                   output = "The number you guessed is correct! Keep Going!";
                   ((TextView) findViewById(R.id.outputText)).setText(output);

                   randomNum = getLevel.getRandomNum("easy");

                   pointsCounter++;

                    currentPoints = getLevel.gethighscore(currentPoints, "easy", pointsCounter);
                    highScore = currentPoints;

               }
               else
               {
                   output = "Wrong guess again!";
                   ((TextView) findViewById(R.id.outputText)).setText(output);
                   pointsCounter = 0;
               }

                if(((CheckBox) findViewById(R.id.hintCheckBox)).isChecked() == true)
                {
                    output = getLevel.getHint(randomNum, userChoice);
                    ((TextView) findViewById(R.id.outputText)).setText(output);
                }
                else
                {
                    output = " The number you guessed is incorrect, keep on trying!";
                    ((TextView) findViewById(R.id.outputText)).setText(output);
                }

}




            }
        });




    }
}