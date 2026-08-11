package com.example.fitnexa2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class BodyPart extends AppCompatActivity {

    CardView arms, legs, chest, abs, shoulderBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_1); // change if your XML filename is different

        arms = findViewById(R.id.arms);
        legs = findViewById(R.id.legs);
        chest = findViewById(R.id.chest);
        abs = findViewById(R.id.abs);
        shoulderBack = findViewById(R.id.shoulder_back);

        arms.setOnClickListener(v -> openDifficulty("arms"));

        legs.setOnClickListener(v -> openDifficulty("legs"));

        chest.setOnClickListener(v -> openDifficulty("chest"));

        abs.setOnClickListener(v -> openDifficulty("abs"));

        shoulderBack.setOnClickListener(v ->
                openDifficulty("shoulder_back"));
    }

    private void openDifficulty(String bodyPart) {

        Intent intent = new Intent(
                BodyPart.this,
                DifficultyLevel.class
        );

        intent.putExtra("bodyPart", bodyPart);

        startActivity(intent);
    }
}