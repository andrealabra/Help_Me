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

    private String returnFinalGrade;

   //  private lateinit var binding : ActivityFinalCalculatorBinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_calculator);

        Button btn = (Button) findViewById(R.id.calculate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(FinalCalculator.this, Results.class);

                String currentGrade = ((EditText) findViewById(R.id.currentGrade)).getText().toString();
                String gradeDesired = ((EditText) findViewById(R.id.gradeDesired)).getText().toString();
                String finalWeight = ((EditText) findViewById(R.id.finalWeight)).getText().toString();
                returnFinalGrade = calculation(currentGrade, gradeDesired, finalWeight);

                startIntent.putExtra("result", returnFinalGrade);
                startActivity(startIntent);


/*
                TextView output = (TextView) findViewById(R.id.result_test);
                output.setText(returnFinalGrade);
*/
            }
        });

    }

    public String calculation(String cg, String gd, String fw) {
        double currentGrade = Double.parseDouble(cg);
        double gradeDesired = Double.parseDouble(gd);
        double finalWeight = Double.parseDouble(fw);
        double finalExamGrade = (gradeDesired - currentGrade * (1 - finalWeight / 100)) / (finalWeight / 100);
        DecimalFormat two = new DecimalFormat("0.0");
        return "You need a " + two.format(finalExamGrade) + "% on your final exam.";
    }
}
