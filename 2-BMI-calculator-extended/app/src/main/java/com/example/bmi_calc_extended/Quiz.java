package com.example.bmi_calc_extended;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Quiz extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;
    TextView score, question;

    private QuizQuestions HealthyQuizQuestions = new QuizQuestions();

    private String userAnswer;
    private int userScore = 0;
    private int questionsLenght = HealthyQuizQuestions.coronavirusQuestions.length;
    int startQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);

        score.setText("Score: " + userScore);
        updateQuestion(startQuestionNumber);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1.getText() == userAnswer){
                    showScoreAndNextQuestion();
                }
                else {
                    gameOver();
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText() == userAnswer){
                    showScoreAndNextQuestion();
                }
                else {
                    gameOver();
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText() == userAnswer){
                    showScoreAndNextQuestion();
                }
                else {
                    gameOver();
                }
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer4.getText() == userAnswer){
                    showScoreAndNextQuestion();
                }
                else {
                    gameOver();
                }
            }
        });
    }

    private void updateQuestion(int num){
        question.setText(HealthyQuizQuestions.getQuestion(num));
        answer1.setText(HealthyQuizQuestions.getChoice1(num));
        answer2.setText(HealthyQuizQuestions.getChoice2(num));
        answer3.setText(HealthyQuizQuestions.getChoice3(num));
        answer4.setText(HealthyQuizQuestions.getChoice4(num));

        userAnswer = HealthyQuizQuestions.getCorrectAnswer(num);
    }
    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quiz.this);
        alertDialogBuilder
                .setMessage("Game over. Your score is" + userScore)
                .setCancelable(false)
                .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), Quiz.class ));
            }
        })
        .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(getApplicationContext(), StartView.class));
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void showScoreAndNextQuestion(){
        userScore++;
        score.setText("Score: " + userScore);
        startQuestionNumber++;
        if(startQuestionNumber < questionsLenght) {
            updateQuestion(startQuestionNumber);
        } else {
            gameOver();
        }
    }
}