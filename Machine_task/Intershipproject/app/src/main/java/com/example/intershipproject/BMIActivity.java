package com.example.intershipproject;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMIActivity extends AppCompatActivity {

    EditText etHeight, etWeight;
    Button btnCalculate;

    TextView tvBMI, tvCategory, tvWater, tvAdvice;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_bmi);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);

        btnCalculate = findViewById(R.id.btnCalculate);

        tvBMI = findViewById(R.id.tvBMI);
        tvCategory = findViewById(R.id.tvCategory);
        tvWater = findViewById(R.id.tvWater);
        tvAdvice = findViewById(R.id.tvAdvice);

        sp = getSharedPreferences("BMI_PREF", MODE_PRIVATE);

        loadData();

        btnCalculate.setOnClickListener(v -> {

            String h = etHeight.getText().toString().trim();
            String w = etWeight.getText().toString().trim();

            if (h.isEmpty()) {
                etHeight.setError("Enter Height");
                return;
            }

            if (w.isEmpty()) {
                etWeight.setError("Enter Weight");
                return;
            }

            double heightCm = Double.parseDouble(h);
            double weightKg = Double.parseDouble(w);

            double heightMeter = heightCm / 100.0;
            double bmi = weightKg / (heightMeter * heightMeter);

            String category;
            String advice;

            if (bmi < 18.5) {
                category = "Underweight";
                advice = "Increase calorie intake and strength training.";
            }
            else if (bmi < 25) {
                category = "Normal";
                advice = "Maintain your current lifestyle.";
            }
            else if (bmi < 30) {
                category = "Overweight";
                advice = "Exercise regularly and eat a balanced diet.";
            }
            else {
                category = "Obese";
                advice = "Consult a healthcare professional.";
            }

            double water = (weightKg * 35) / 1000.0;

            tvBMI.setText(String.format("BMI : %.2f", bmi));
            tvCategory.setText("Category : " + category);
            tvWater.setText(String.format("Water Intake : %.1f L/day", water));
            tvAdvice.setText("Recommendation : " + advice);

            saveData(h, w);
        });

    }

    private void saveData(String height, String weight) {

        SharedPreferences.Editor editor = sp.edit();

        editor.putString("HEIGHT", height);
        editor.putString("WEIGHT", weight);

        editor.apply();
    }

    private void loadData() {

        String height = sp.getString("HEIGHT", "");
        String weight = sp.getString("WEIGHT", "");

        etHeight.setText(height);
        etWeight.setText(weight);
    }

}
