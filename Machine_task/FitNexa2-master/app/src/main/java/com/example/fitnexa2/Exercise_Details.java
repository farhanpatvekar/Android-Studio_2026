package com.example.fitnexa2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Exercise_Details extends AppCompatActivity {

    ImageView imgviewexercise2;

    TextView exercisename2;
    TextView exerciselevel;
    TextView force;
    TextView mechanic;
    TextView equipment;
    TextView primarymuscles;
    TextView secondarymusles;
    TextView instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_detail);

        // Initialize views
        imgviewexercise2 = findViewById(R.id.imgviewexercise2);

        exercisename2 = findViewById(R.id.exercisename2);
        exerciselevel = findViewById(R.id.exerciselevel);
        force = findViewById(R.id.force);
        mechanic = findViewById(R.id.mechanic);
        equipment = findViewById(R.id.equipment);
        primarymuscles = findViewById(R.id.primarymuscles);
        secondarymusles = findViewById(R.id.secondarymusles);
        instructions = findViewById(R.id.instructions);

        // Get Exercise object from Intent
        Exercise exercise =
                (Exercise) getIntent().getSerializableExtra("exercise");

        if (exercise != null) {

            // Exercise name
            exercisename2.setText(exercise.getName());

            // Basic details
            exerciselevel.setText("Level: " + exercise.getLevel());

            force.setText("Force: " + exercise.getForce());

            mechanic.setText("Mechanic: " + exercise.getMechanic());

            equipment.setText("Equipment: " + exercise.getEquipment());

            // Primary muscles
            if (exercise.getPrimaryMuscles() != null &&
                    !exercise.getPrimaryMuscles().isEmpty()) {

                primarymuscles.setText(
                        "Primary Muscles: " +
                                String.join(", ",
                                        exercise.getPrimaryMuscles())
                );
            }

            // Secondary muscles
            if (exercise.getSecondaryMuscles() != null &&
                    !exercise.getSecondaryMuscles().isEmpty()) {

                secondarymusles.setText(
                        "Secondary Muscles: " +
                                String.join(", ",
                                        exercise.getSecondaryMuscles())
                );
            }

            // Instructions
            if (exercise.getInstructions() != null &&
                    !exercise.getInstructions().isEmpty()) {

                StringBuilder instructionText = new StringBuilder();

                for (int i = 0;
                     i < exercise.getInstructions().size();
                     i++) {

                    instructionText.append(i + 1)
                            .append(". ")
                            .append(exercise.getInstructions().get(i))
                            .append("\n\n");
                }

                instructions.setText(instructionText.toString());
            }

            // Exercise image
            if (exercise.getImages() != null &&
                    !exercise.getImages().isEmpty()) {

                String imageURL =
                        "https://raw.githubusercontent.com/yuhonas/free-exercise-db/main/exercises/"
                                + exercise.getImages().get(0);

                Glide.with(this)
                        .load(imageURL)
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(imgviewexercise2);
            }
        }
    }
}