package com.example.behealthykotlinapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CaloriesCalculator : AppCompatActivity() {
    private var height: EditText? = null
    private var weight: EditText? = null
    private var result: TextView? = null
    private var age: EditText? = null
    private var radioSexGroup: RadioGroup? = null
    private var radioSexButton: RadioButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories_calculator)
        height = findViewById(R.id.height_input)
        weight = findViewById(R.id.weight_input)
        result = findViewById(R.id.result)
        age = findViewById(R.id.age_input)
        radioSexGroup = findViewById<View>(R.id.radioSex) as RadioGroup
    }

    fun calcBMRvalue(weight: Double, height: Double): Double {
        val bmi: Double
        bmi = weight / Math.pow(height, 2.0)
        return bmi
    }

    fun calculateBMR(view: View?) {

        // get selected radio button from radioGroup
        val selectedId = radioSexGroup!!.checkedRadioButtonId
        // find the radiobutton by returned id
        radioSexButton = findViewById<View>(selectedId) as RadioButton
        val gender_value = radioSexButton!!.text.toString()
        val height_value = height!!.text.toString()
        val weight_value = weight!!.text.toString()
        val age_value = age!!.text.toString()
        if (height_value != null && "" != height_value && "0" != height_value
            && weight_value != null && "" != weight_value && "0" != weight_value
        ) {
//            double height= Double.parseDouble(height_value) / 100;
//            double weight = Double.parseDouble(weight_value);
//            double bmi = calcBMRvalue(weight, height);
            if (gender_value == "Female") {
//                PPM (kobiety) = SWE (spoczynkowy wydatek energetyczny kcal) = 655,1 +
//                (9,563 x masa ciała [kg]) + (1,85 x wzrost [cm]) – (4,676 x [wiek])
                val bmr_score =
                    655.1 + 9.563 * weight_value.toDouble() + 1.85 * height_value.toDouble() - 4.676 * age_value.toDouble()
                val bmr_result = " $bmr_score $gender_value"
                result!!.text = bmr_result
            }
            if (gender_value == "Male") {
//                PPM (mężczyźni) = SWE (spoczynkowy wydatek energetyczny kcal) = 66,5
////                + (13,75 x masa ciała [kg]) + (5,003 x wzrost [cm]) – (6,775 x [wiek])
                val bmr_score =
                    66.5 + 13.75 * weight_value.toDouble() + 5.003 * height_value.toDouble() - 6.775 * age_value.toDouble()
                val bmr_result = " $bmr_score $gender_value"
                result!!.text = bmr_result
            }
        }


//        String bmr_result = "BMR = " + height_value + weight_value + age_value + gender_value;
//        result.setText(bmr_result + " "+ bmr_score + " " + gender_value);
//            displayBMI(bmi);
    }

    private fun displayBMI(bmi: Double) {
        val bmi_score = Math.round(bmi * 100.00) / 100.00
        val bmi_result = "BMR = $bmi_score"
        result!!.text = bmi_result
    }
}