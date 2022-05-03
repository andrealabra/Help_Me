package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;
import com.example.project3.databinding.ActivityFinalCalculatorBinding;

public class FinalCalculator extends AppCompatActivity {
    // A Public Class FinalCalculator which extends AppCompactAcitivity Class
// AppCompactActivity Class is used to add action bar in the application
        // A returnFinalGrade variable of string type with private access modifier
        private String returnFinalGrade;
        // private late init var binding : ActivityFinalCalculatorBinding
        @Override
        // This is the main method from where application starts executing
        // or This is the main entry point of the application
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // setContentView is used to add the class with the respective UI
            // In this we are mapping this FinalCaculator class with activity_final_calculator.xml file
            setContentView(R.layout.activity_final_calculator);
            // we are registering button here in btn variable using caculate id
            Button btn = (Button) findViewById(R.id.calculate);
            // Adding on click listener in btn
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                // this is the default method of setOnClickListener method
                public void onClick(View v) {
                    // Here we are creating the object of Intent class to move from one class to another
                    // Here we are moving from current FinalCalculator class to Results class
                    Intent startIntent = new Intent(FinalCalculator.this, Results.class);
                    // Here we are getting value from the UI and storing in respective variables
                    String currentGrade = ((EditText) findViewById(R.id.currentGrade)).getText().toString();
                    String gradeDesired = ((EditText) findViewById(R.id.gradeDesired)).getText().toString();
                    String finalWeight = ((EditText) findViewById(R.id.finalWeight)).getText().toString();
                    // here we are storing the cacluation method return values in returnFinalGrade variable
                    returnFinalGrade = calculation(currentGrade, gradeDesired, finalWeight);
                    // here we call the putExtra method to pass the returnFinalGrade value from FinalCalculator class to Results class
                    startIntent.putExtra("result", returnFinalGrade);
                    // here we use the startActivity method to call the Intent object to start the new activity "Results"
                    startActivity(startIntent);
                    /* TextView output = (TextView) findViewById(R.id.result_test); output.setText(returnFinalGrade); */ }
            });
        }

        // This is the calculation class which accepts input from the UI
        public String calculation(String cg, String gd, String fw) {
            // we are parsing string data types to double
            double currentGrade = Double.parseDouble(cg);
            double gradeDesired = Double.parseDouble(gd);
            double finalWeight = Double.parseDouble(fw);
            // Calculate the  grade
            double finalExamGrade = (gradeDesired - currentGrade * (1 - finalWeight / 100)) / (finalWeight / 100);
            DecimalFormat two = new DecimalFormat("0.0");
            return "You need a " + two.format(finalExamGrade) + "% on your final exam.";
        }
}