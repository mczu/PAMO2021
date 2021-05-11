package com.example.behealthykotlinapp

//import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class StartView : AppCompatActivity() {

    // Add button Move to Activity
//    var bmi_Calc_button: Button? = null
//    var bmr_Calc_button: Button? = null
//    var chart_button: Button? = null
//    var quiz_button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_view)

        val bmi_Calc_button:Button = findViewById(R.id.bmi_calc)
        bmi_Calc_button.setOnClickListener {
            val intent = Intent(this@StartView, MainActivity::class.java)
            startActivity(intent)
        }

        val bmr_Calc_button:Button = findViewById(R.id.bmrcalc)
        bmr_Calc_button.setOnClickListener {
            val intent = Intent(this@StartView, CaloriesCalculator::class.java)
            startActivity(intent)
        }

        val quiz_button:Button = findViewById(R.id.quiz_button)
        quiz_button.setOnClickListener {
            val intent = Intent(this@StartView, Quiz::class.java)
            startActivity(intent)
        }

        val chart_button:Button = findViewById(R.id.chart_button)
        chart_button.setOnClickListener {
            val intent = Intent(this@StartView, Chart::class.java)
            startActivity(intent)
        }
//        // by ID we can use each component which id is assign in xml file
//        // use findViewById() to get the Button
//        // by ID we can use each component which id is assign in xml file
//        // use findViewById() to get the Button
//        bmi_Calc_button = findViewById<View>(R.id.bmi_calc) as Button
//        bmr_Calc_button = findViewById<View>(R.id.bmrcalc) as Button
//        chart_button = findViewById<View>(R.id.chart_button) as Button
//        quiz_button = findViewById<View>(R.id.quiz_button) as Button
//
//        // Add_button add clicklistener
//
//        // Add_button add clicklistener
//        bmi_Calc_button.setOnClickListener(object : OnClickListener() {
//            fun onClick(v: View?) {
//
//                // Intents are objects of the android.content.Intent type. Your code can send them
//                // to the Android system defining the components you are targeting.
//                // Intent to start an activity called SecondActivity with the following code:
//                val intent = Intent(this@StartView, MainActivity::class.java)
//
//                // start the activity connect to the specified class
//                startActivity(intent)
//            }
//        })
//        // Add_button add clicklistener
//        // Add_button add clicklistener
//        bmr_Calc_button.setOnClickListener(object : OnClickListener() {
//            fun onClick(v: View?) {
//
//                // Intents are objects of the android.content.Intent type. Your code can send them
//                // to the Android system defining the components you are targeting.
//                // Intent to start an activity called SecondActivity with the following code:
//                val intent = Intent(this@StartView, CaloriesCalculator::class.java)
//
//                // start the activity connect to the specified class
//                startActivity(intent)
//            }
//        })
//        // Add_button add clicklistener
//        // Add_button add clicklistener
//        chart_button.setOnClickListener(object : OnClickListener() {
//            fun onClick(v: View?) {
//
//                // Intents are objects of the android.content.Intent type. Your code can send them
//                // to the Android system defining the components you are targeting.
//                // Intent to start an activity called SecondActivity with the following code:
//                val intent = Intent(this@StartView, Chart::class.java)
//
//                // start the activity connect to the specified class
//                startActivity(intent)
//            }
//        })
//        // Add_button add clicklistener
//        // Add_button add clicklistener
//        quiz_button.setOnClickListener(object : OnClickListener() {
//            fun onClick(v: View?) {
//
//                // Intents are objects of the android.content.Intent type. Your code can send them
//                // to the Android system defining the components you are targeting.
//                // Intent to start an activity called SecondActivity with the following code:
//                val intent = Intent(this@StartView, Quiz::class.java)
//
//                // start the activity connect to the specified class
//                startActivity(intent)
//            }
//        })
    }
}