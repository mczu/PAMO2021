package com.example.bmi_calc_extended;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;

    // Add button Move previous activity
    Button back_to_start_button;
    Button go_to_recipe_button;
    Button go_to_recipe_for_normalweight_button;
    Button go_to_recipe_for_obese_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.height_input);
        weight = findViewById(R.id.weight_input);
        result = findViewById(R.id.result);

        back_to_start_button = (Button)findViewById(R.id.back_to_start_button);
        go_to_recipe_button = (Button)findViewById(R.id.go_to_recipe);
        go_to_recipe_for_normalweight_button = (Button)findViewById(R.id.go_to_recipe_for_normalweight);
        go_to_recipe_for_obese_button = (Button)findViewById(R.id.go_to_recipe_for_obese);

        // Add_button add clicklistener
        back_to_start_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, StartView.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });

        // Add_button add clicklistener
        go_to_recipe_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, RecipeForUnderweight.class);

                // start the activity connect to the specified class
                startActivity(intent);


            }


        });

        // Add_button add clicklistener
        go_to_recipe_for_normalweight_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, RecipeForNormalWeight.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });
        // Add_button add clicklistener
        go_to_recipe_for_obese_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, RecipeForObese.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });
    }

    public double calcBMIvalue(double weight, double height){
        double bmi;
        bmi = weight/ Math.pow(height, 2);
        return bmi;
    }

    public void calculateBMI(View view) {

        String height_value = height.getText().toString();
        String weight_value = weight.getText().toString();

        if (height_value != null && !"".equals(height_value) && !"0".equals(height_value)
                && weight_value != null  &&  !"".equals(weight_value) && !"0".equals(weight_value)) {
            double height= Double.parseDouble(height_value) / 100;
            double weight = Double.parseDouble(weight_value);
            double bmi = calcBMIvalue(weight, height);

            displayBMI(bmi);


        }
    }

    private void displayBMI(double bmi) {
        double bmi_score = Math.round(bmi * 100.00) / 100.00;
        String bmi_result = "BMI = " + bmi_score;
        result.setText(bmi_result);

//        String result_value = result.getText().toString();
//        double result_number = Double.parseDouble(result_value);
        if (bmi_score < 18.5 ){
            // go to underweight recipie
            // make button visible
            go_to_recipe_button.setVisibility(View.VISIBLE); //SHOW the button
            go_to_recipe_for_obese_button.setVisibility(View.INVISIBLE);
            go_to_recipe_for_normalweight_button.setVisibility(View.INVISIBLE);
        }
        else if (bmi_score >= 18.5 && bmi_score < 24.9){
            //  go to normal recipe
            // make correct button visible
            go_to_recipe_for_normalweight_button.setVisibility(View.VISIBLE);
            go_to_recipe_button.setVisibility(View.INVISIBLE);
            go_to_recipe_for_obese_button.setVisibility(View.INVISIBLE);
        } else {
            // go to overwieight recipe
            //make correct button visible
            go_to_recipe_for_obese_button.setVisibility(View.VISIBLE);
            go_to_recipe_for_normalweight_button.setVisibility(View.INVISIBLE);
            go_to_recipe_button.setVisibility(View.INVISIBLE);
        }
    }



}