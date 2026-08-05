 package com.example.intershipproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

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
    TextView AppName1;
    SearchView searchView;
    Button exercise, diet;

    List<Food> foods = new ArrayList<>();
    FoodAdapter foodAdapter;

    List<Exercise> exercises = new ArrayList<>();
    ExerciseAdapter exerciseAdapter;


    boolean isDietSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_home_page);

        AppName1 = findViewById(R.id.AppName1);
        searchView = findViewById(R.id.searchView);
        exercise = findViewById(R.id.exercise);
        diet = findViewById(R.id.diet);
        recyclerView = findViewById(R.id.recycleView1);

        android.widget.EditText searchText =
                searchView.findViewById(androidx.appcompat.R.id.search_src_text);

        if (searchText != null) {
            searchText.setTextColor(android.graphics.Color.BLACK);
            searchText.setHintTextColor(android.graphics.Color.GRAY);
            searchText.setTextSize(18);
        }

        android.widget.ImageView searchIcon =
                searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);

        if (searchIcon != null) {
            searchIcon.setColorFilter(android.graphics.Color.parseColor("#B8FF1A"));
        }

        android.widget.ImageView closeButton =
                searchView.findViewById(androidx.appcompat.R.id.search_close_btn);

        if (closeButton != null) {
            closeButton.setColorFilter(android.graphics.Color.parseColor("#B8FF1A"));
        }


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initExerciseRecyclerView();

        exercise.setOnClickListener(v -> {

            isDietSelected = false;
            searchView.setQuery("", false);
            searchView.clearFocus();

            initExerciseRecyclerView();
        });

        diet.setOnClickListener(v -> {

            isDietSelected = true;
            searchView.setQuery("", false);
            searchView.clearFocus();

            initFoodRecyclerView();
        });

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {

                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {

                        if (isDietSelected) {

                            if (foodAdapter != null) {
                                foodAdapter.getFilter().filter(newText);
                            }

                        } else {

                            if (exerciseAdapter != null) {
                                exerciseAdapter.getFilter().filter(newText);
                            }
                        }

                        return true;
                    }
                });
    }

    private void initFoodRecyclerView() {

        foodAdapter = new FoodAdapter(foods);

        recyclerView.setAdapter(foodAdapter);

        FoodService.getInstance().getFoods().enqueue(
                new Callback<List<Food>>() {

                    @Override
                    public void onResponse(Call<List<Food>> call,
                                           Response<List<Food>> response) {

                        if (response.isSuccessful()
                                && response.body() != null) {

                            foodAdapter.updateData(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Food>> call,
                                          Throwable t) {

                        t.printStackTrace();
                    }
                });
    }

    private void initExerciseRecyclerView() {

        exerciseAdapter = new ExerciseAdapter(exercises);

        recyclerView.setAdapter(exerciseAdapter);

        ExerciseService.getInstance().getExercises().enqueue(
                new Callback<List<Exercise>>() {

                    @Override
                    public void onResponse(Call<List<Exercise>> call,
                                           Response<List<Exercise>> response) {

                        if (response.isSuccessful()
                                && response.body() != null) {

                            exerciseAdapter.updateData(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Exercise>> call,
                                          Throwable t) {

                        t.printStackTrace();
                    }
                });
    }
}