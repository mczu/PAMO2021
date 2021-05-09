package com.example.bmi_calc_extended;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartView extends AppCompatActivity {

    // Add button Move to Activity
    Button bmi_Calc_button;
    Button bmr_Calc_button;
    Button chart_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_view);

        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        bmi_Calc_button = (Button)findViewById(R.id.bmi_calc);
        bmr_Calc_button = (Button)findViewById(R.id.bmrcalc);
        chart_button = (Button)findViewById(R.id.chart_button);

        // Add_button add clicklistener
        bmi_Calc_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(StartView.this, MainActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });
        // Add_button add clicklistener
        bmr_Calc_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(StartView.this, CaloriesCalculator.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });
        // Add_button add clicklistener
        chart_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(StartView.this, Chart.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });
    }
}