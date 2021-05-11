package com.example.behealthykotlinapp

//import android.R
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class Quiz : AppCompatActivity() {
    var answer1: Button? = null
    var answer2:Button? = null
    var answer3:Button? = null
    var answer4: Button? = null
    var score: TextView? = null
    var question:TextView? = null

    private val HealthyQuizQuestions = QuizQuestions()

    private var userAnswer: String? = null
    private var userScore = 0
    private val questionsLenght: Int = HealthyQuizQuestions.coronavirusQuestions.size
    var startQuestionNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        answer1 = findViewById<View>(R.id.answer1) as Button
        answer2 = findViewById<View>(R.id.answer2) as Button
        answer3 = findViewById<View>(R.id.answer3) as Button
        answer4 = findViewById<View>(R.id.answer4) as Button
        score = findViewById<View>(R.id.score) as TextView
        question = findViewById<View>(R.id.question) as TextView
        score!!.text = "Score: $userScore"
        updateQuestion(startQuestionNumber)
        answer1!!.setOnClickListener(View.OnClickListener {
            if (answer1!!.getText() === userAnswer) {
                showScoreAndNextQuestion()
            } else {
                gameOver()
            }
        })
        answer2!!.setOnClickListener(View.OnClickListener {
            if (answer2!!.getText() === userAnswer) {
                showScoreAndNextQuestion()
            } else {
                gameOver()
            }
        })
        answer3!!.setOnClickListener(View.OnClickListener {
            if (answer3!!.getText() === userAnswer) {
                showScoreAndNextQuestion()
            } else {
                gameOver()
            }
        })
        answer4!!.setOnClickListener(View.OnClickListener {
            if (answer4!!.getText() === userAnswer) {
                showScoreAndNextQuestion()
            } else {
                gameOver()
            }
        })
    }

    private fun updateQuestion(num: Int) {
        question!!.setText(HealthyQuizQuestions.getQuestion(num))
        answer1!!.setText(HealthyQuizQuestions.getChoice1(num))
        answer2!!.setText(HealthyQuizQuestions.getChoice2(num))
        answer3!!.setText(HealthyQuizQuestions.getChoice3(num))
        answer4!!.setText(HealthyQuizQuestions.getChoice4(num))
        userAnswer = HealthyQuizQuestions.getCorrectAnswer(num)
    }

    private fun gameOver() {
        val alertDialogBuilder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this@Quiz)
        alertDialogBuilder
            .setMessage("Game over. Your score is$userScore")
            .setCancelable(false)
            .setPositiveButton("NEW GAME",
                DialogInterface.OnClickListener { dialog, which ->
                    startActivity(
                        Intent(
                            applicationContext,
                            Quiz::class.java
                        )
                    )
                })
            .setNegativeButton("EXIT",
                DialogInterface.OnClickListener { dialog, which ->
                    startActivity(
                        Intent(
                            applicationContext,
                            StartView::class.java
                        )
                    )
                })
        val alertDialog: android.app.AlertDialog? = alertDialogBuilder.create()
        alertDialog!!.show()
    }

    fun showScoreAndNextQuestion() {
        userScore++
        score!!.text = "Score: $userScore"
        startQuestionNumber++
        if (startQuestionNumber < questionsLenght) {
            updateQuestion(startQuestionNumber)
        } else {
            gameOver()
        }
    }
}