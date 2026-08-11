package com.example.fitnexa2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    LinearLayout exerciseButton, dietButton, bmiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        exerciseButton = findViewById(R.id.exercise_button);
        dietButton = findViewById(R.id.diet_button);
        bmiButton = findViewById(R.id.bmi_button);

        exerciseButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomePage.this,
                    BodyPart.class
            );

            startActivity(intent);
        });

        dietButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomePage.this,
                    MainActivity.class
            );

            intent.putExtra("isDietSelected", true);

            startActivity(intent);
        });

        bmiButton.setOnClickListener(v -> {

            // BMI Activity will be added later

        });
    }
}