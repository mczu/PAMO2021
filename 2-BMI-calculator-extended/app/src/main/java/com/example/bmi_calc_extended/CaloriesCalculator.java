package com.example.bmi_calc_extended;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Objects;

public class CaloriesCalculator extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;
    private EditText age;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_calculator);

        height = findViewById(R.id.height_input);
        weight = findViewById(R.id.weight_input);
        result = findViewById(R.id.result);
        age = findViewById(R.id.age_input);
        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
    }

    public double calcBMRvalue(double weight, double height){
        double bmi;
        bmi = weight/ Math.pow(height, 2);
        return bmi;
    }

    public void calculateBMR(View view) {

        // get selected radio button from radioGroup
        int selectedId = radioSexGroup.getCheckedRadioButtonId();
// find the radiobutton by returned id
        radioSexButton = (RadioButton) findViewById(selectedId);

        String gender_value = radioSexButton.getText().toString();
        String height_value = height.getText().toString();
        String weight_value = weight.getText().toString();
        String age_value = age.getText().toString();



        if (height_value != null && !"".equals(height_value) && !"0".equals(height_value)
                && weight_value != null  &&  !"".equals(weight_value) && !"0".equals(weight_value)) {
//            double height= Double.parseDouble(height_value) / 100;
//            double weight = Double.parseDouble(weight_value);
//            double bmi = calcBMRvalue(weight, height);

            if(Objects.equals(gender_value, "Female")){
//                PPM (kobiety) = SWE (spoczynkowy wydatek energetyczny kcal) = 655,1 +
//                (9,563 x masa ciała [kg]) + (1,85 x wzrost [cm]) – (4,676 x [wiek])
                double bmr_score = 655.1 + (9.563* Double.parseDouble(weight_value)) + (1.85* Double.parseDouble(height_value)) - (4.676 * Double.parseDouble(age_value));
                String bmr_result = " "+ bmr_score + " " + gender_value;
                result.setText(bmr_result);
            }
            if(Objects.equals(gender_value, "Male")){
//                PPM (mężczyźni) = SWE (spoczynkowy wydatek energetyczny kcal) = 66,5
////                + (13,75 x masa ciała [kg]) + (5,003 x wzrost [cm]) – (6,775 x [wiek])
                double bmr_score = 66.5 + (13.75*Double.parseDouble(weight_value)) + (5.003 * Double.parseDouble(height_value)) - (6.775*Double.parseDouble(age_value));
                String bmr_result = " "+ bmr_score + " " + gender_value;
                result.setText(bmr_result);
            }
        }


//        String bmr_result = "BMR = " + height_value + weight_value + age_value + gender_value;
//        result.setText(bmr_result + " "+ bmr_score + " " + gender_value);
//            displayBMI(bmi);
    }

    private void displayBMI(double bmi) {
        double bmi_score = Math.round(bmi * 100.00) / 100.00;
        String bmi_result = "BMR = " + bmi_score;
        result.setText(bmi_result);
    }


}