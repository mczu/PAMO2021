package com.example.behealthykotlinapp

//import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var height: EditText? = null
    private var weight: EditText? = null
    private var result: TextView? = null

    // Add button Move previous activity
    var back_to_start_button: Button? = null
    var go_to_recipe_button: Button? = null
    var go_to_recipe_for_normalweight_button: Button? = null
    var go_to_recipe_for_obese_button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        height = findViewById(R.id.height_input)
        weight = findViewById(R.id.weight_input)
        result = findViewById(R.id.result)
        back_to_start_button = findViewById<View>(R.id.back_to_start_button) as Button
        go_to_recipe_button = findViewById<View>(R.id.go_to_recipe) as Button
        go_to_recipe_for_normalweight_button =
            findViewById<View>(R.id.go_to_recipe_for_normalweight) as Button
        go_to_recipe_for_obese_button = findViewById<View>(R.id.go_to_recipe_for_obese) as Button

        // Add_button add clicklistener
        back_to_start_button!!.setOnClickListener { // Intents are objects of the android.content.Intent type. Your code can send them
            // to the Android system defining the components you are targeting.
            // Intent to start an activity called SecondActivity with the following code:
            val intent = Intent(this@MainActivity, StartView::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }

        // Add_button add clicklistener
        go_to_recipe_button!!.setOnClickListener { // Intents are objects of the android.content.Intent type. Your code can send them
            // to the Android system defining the components you are targeting.
            // Intent to start an activity called SecondActivity with the following code:
            val intent = Intent(this@MainActivity, RecipeForUnderweight::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }

        // Add_button add clicklistener
        go_to_recipe_for_normalweight_button!!.setOnClickListener { // Intents are objects of the android.content.Intent type. Your code can send them
            // to the Android system defining the components you are targeting.
            // Intent to start an activity called SecondActivity with the following code:
            val intent = Intent(this@MainActivity, RecipeForNormalWeight::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }
        // Add_button add clicklistener
        go_to_recipe_for_obese_button!!.setOnClickListener { // Intents are objects of the android.content.Intent type. Your code can send them
            // to the Android system defining the components you are targeting.
            // Intent to start an activity called SecondActivity with the following code:
            val intent = Intent(this@MainActivity, RecipeForObese::class.java)

            // start the activity connect to the specified class
            startActivity(intent)
        }
    }

    fun calcBMIvalue(weight: Double, height: Double): Double {
        val bmi: Double
        bmi = weight / Math.pow(height, 2.0)
        return bmi
    }

    fun calculateBMI(view: View?) {
        val height_value = height!!.text.toString()
        val weight_value = weight!!.text.toString()
        if (height_value != null && "" != height_value && "0" != height_value
            && weight_value != null && "" != weight_value && "0" != weight_value
        ) {
            val height = height_value.toDouble() / 100
            val weight = weight_value.toDouble()
            val bmi = calcBMIvalue(weight, height)
            displayBMI(bmi)
        }
    }

    private fun displayBMI(bmi: Double) {
        val bmi_score = Math.round(bmi * 100.00) / 100.00
        val bmi_result = "BMI = $bmi_score"
        result!!.text = bmi_result

//        String result_value = result.getText().toString();
//        double result_number = Double.parseDouble(result_value);
        if (bmi_score < 18.5) {
            // go to underweight recipie
            // make button visible
            go_to_recipe_button!!.visibility = View.VISIBLE //SHOW the button
            go_to_recipe_for_obese_button!!.visibility = View.INVISIBLE
            go_to_recipe_for_normalweight_button!!.visibility = View.INVISIBLE
        } else if (bmi_score >= 18.5 && bmi_score < 24.9) {
            //  go to normal recipe
            // make correct button visible
            go_to_recipe_for_normalweight_button!!.visibility = View.VISIBLE
            go_to_recipe_button!!.visibility = View.INVISIBLE
            go_to_recipe_for_obese_button!!.visibility = View.INVISIBLE
        } else {
            // go to overwieight recipe
            //make correct button visible
            go_to_recipe_for_obese_button!!.visibility = View.VISIBLE
            go_to_recipe_for_normalweight_button!!.visibility = View.INVISIBLE
            go_to_recipe_button!!.visibility = View.INVISIBLE
        }
    }


}