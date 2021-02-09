package com.example.braintrainer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.braintrainer.R;
import com.example.braintrainer.ui.mainactivity.MainActivity;

import java.util.ArrayList;
import java.util.Random;

public class HardActivity extends AppCompatActivity {

    //String game ="";
    //TextView textView2;
    TextView resultTextView;
    TextView pointsTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    Button back;
    ConstraintLayout gameConstraintLayout;
    boolean gameIsActive=true;

    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;

    public void generateQuestion() {

        if (gameIsActive) {

            Random rand = new Random();

            int a = rand.nextInt(51);
            int b = rand.nextInt(51);

            sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

            locationOfCorrectAnswer = rand.nextInt(4);

            answers.clear();

            int incorrectAnswer;

            for (int i = 0; i<4; i++) {

                if (i == locationOfCorrectAnswer) {

                    answers.add(a + b);
                }else {

                    incorrectAnswer = rand.nextInt(101);

                    while (incorrectAnswer == a + b) {

                        incorrectAnswer = rand.nextInt(101);
                    }
                    if (i > 0){
                        while (incorrectAnswer == answers.get(i-1)){
                            incorrectAnswer = rand.nextInt(101);
                        }
                    }

                    answers.add(incorrectAnswer);
                }
            }

            button0.setText(Integer.toString(answers.get(0)));
            button1.setText(Integer.toString(answers.get(1)));
            button2.setText(Integer.toString(answers.get(2)));
            button3.setText(Integer.toString(answers.get(3)));

        }

        /*if (textView2.getText().equals("easy")){

            if (gameIsActive) {

                Random rand = new Random();

                int a = rand.nextInt(11);
                int b = rand.nextInt(11);

                sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

                locationOfCorrectAnswer = rand.nextInt(4);

                answers.clear();

                int incorrectAnswer;

                for (int i = 0; i<4; i++) {

                    if (i == locationOfCorrectAnswer) {

                        answers.add(a + b);
                    }else {

                        incorrectAnswer = rand.nextInt(21);

                        while (incorrectAnswer == a + b) {

                            incorrectAnswer = rand.nextInt(21);
                        }

                        answers.add(incorrectAnswer);
                    }
                }

                button0.setText(Integer.toString(answers.get(0)));
                button1.setText(Integer.toString(answers.get(1)));
                button2.setText(Integer.toString(answers.get(2)));
                button3.setText(Integer.toString(answers.get(3)));

            }

        }else if (textView2.getText().equals("medium")){

            if (gameIsActive) {

                Random rand = new Random();

                int a = rand.nextInt(21);
                int b = rand.nextInt(21);

                sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

                locationOfCorrectAnswer = rand.nextInt(4);

                answers.clear();

                int incorrectAnswer;

                for (int i = 0; i<4; i++) {

                    if (i == locationOfCorrectAnswer) {

                        answers.add(a + b);
                    }else {

                        incorrectAnswer = rand.nextInt(41);

                        while (incorrectAnswer == a + b) {

                            incorrectAnswer = rand.nextInt(41);
                        }

                        answers.add(incorrectAnswer);
                    }
                }

                button0.setText(Integer.toString(answers.get(0)));
                button1.setText(Integer.toString(answers.get(1)));
                button2.setText(Integer.toString(answers.get(2)));
                button3.setText(Integer.toString(answers.get(3)));

            }

        }else if (textView2.getText().equals("hard")){

            if (gameIsActive) {

                Random rand = new Random();

                int a = rand.nextInt(51);
                int b = rand.nextInt(51);

                sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

                locationOfCorrectAnswer = rand.nextInt(4);

                answers.clear();

                int incorrectAnswer;

                for (int i = 0; i<4; i++) {

                    if (i == locationOfCorrectAnswer) {

                        answers.add(a + b);
                    }else {

                        incorrectAnswer = rand.nextInt(101);

                        while (incorrectAnswer == a + b) {

                            incorrectAnswer = rand.nextInt(101);
                        }

                        answers.add(incorrectAnswer);
                    }
                }

                button0.setText(Integer.toString(answers.get(0)));
                button1.setText(Integer.toString(answers.get(1)));
                button2.setText(Integer.toString(answers.get(2)));
                button3.setText(Integer.toString(answers.get(3)));

            }

        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);

        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        sumTextView = (TextView) findViewById(R.id.sumTextView);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        pointsTextView = (TextView) findViewById(R.id.pointsTextView);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        back = (Button) findViewById(R.id.back);
        gameConstraintLayout = (ConstraintLayout) findViewById(R.id.gameConstraintLayout);
        playAgain(findViewById(R.id.playAgainButton));

        //textView2 = (TextView) findViewById(R.id.textView2);

        Intent i = getIntent();
        /*textView2.setText(i.getStringExtra("game"));
        if (i.getStringExtra("game")=="easy"){
            game="easy";
        }else if (i.getStringExtra("game")=="medium"){
            game="medium";
        }else if (i.getStringExtra("game")=="hard"){
            game="hard";
        }*/


        // Create the InterstitialAd and set the adUnitId (defined in values/strings.xml).

    }

    public void chooseAnswer(View view) {

        if (gameIsActive) {

            if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {

                score++;
                resultTextView.setText("Correct!");
                resultTextView.setTextColor(Color.GREEN);
            }else {

                resultTextView.setText("Wrong!");
                resultTextView.setTextColor(Color.RED);
            }

            numberOfQuestions++;
            pointsTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
            generateQuestion();
        }

    }

    public void playAgain(final View view) {

        score = 0;
        numberOfQuestions = 0;

        timerTextView.setText("10s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        //back.setVisibility(View.INVISIBLE);
        gameIsActive=true;

        generateQuestion();

        new CountDownTimer(10100, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {

                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");

            }

            @Override
            public void onFinish() {

                playAgainButton.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your score: " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
                gameIsActive=false;

                if (score <= numberOfQuestions/2) {

                    resultTextView.setTextColor(Color.RED);

                }else {

                    resultTextView.setTextColor(Color.GREEN);

                }

            }
        }.start();
    }

    public void back (View view) {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }

}