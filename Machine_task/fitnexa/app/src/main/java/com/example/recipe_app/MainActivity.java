package com.example.recipe_app;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Exercise> exercises = new ArrayList<>();
    ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));

        exerciseAdapter = new ExerciseAdapter(exercises);
        recyclerView.setAdapter(exerciseAdapter);


        ExerciseService exerciseService = ExerciseService.getInstance();

        exerciseService.getExercises().enqueue(new Callback<List<Exercise>>() {

            @Override
            public void onResponse(Call<List<Exercise>> call, Response<List<Exercise>> response) {

                System.out.println("Code: " + response.code());

                if (response.isSuccessful() && response.body() != null) {

                    System.out.println("Exercises: " + response.body().size());

                    exercises.clear();
                    exercises.addAll(response.body());
                    exerciseAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Exercise>> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }
}