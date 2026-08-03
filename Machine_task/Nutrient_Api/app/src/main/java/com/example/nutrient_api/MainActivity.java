package com.example.nutrient_api;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Food> foods = new ArrayList<>();
    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        foodAdapter = new FoodAdapter(foods);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));

        FoodService foodService = FoodService.getInstance();

        foodService.getFoods().enqueue(new Callback<List<Food>>() {

            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    foods.clear();
                    foods.addAll(response.body());
                    foodAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
