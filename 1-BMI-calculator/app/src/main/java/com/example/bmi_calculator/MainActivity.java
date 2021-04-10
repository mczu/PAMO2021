package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.height_input);
        weight = findViewById(R.id.weight_input);
        result = findViewById(R.id.result);
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
    }
}