package com.example.fitnexa2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DifficultyLevel extends AppCompatActivity {

    CardView card1, card2, card3;

    String bodyPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_2);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);

        // Get body part from BodyPartActivity
        bodyPart = getIntent().getStringExtra("bodyPart");

        card1.setOnClickListener(v -> openExerciseList("beginner"));

        card2.setOnClickListener(v -> openExerciseList("intermediate"));

        card3.setOnClickListener(v -> openExerciseList("expert"));
    }

    private void openExerciseList(String level) {

        Intent intent = new Intent(
                DifficultyLevel.this,
                MainActivity.class
        );

        intent.putExtra("bodyPart", bodyPart);
        intent.putExtra("level", level);

        startActivity(intent);
    }
}