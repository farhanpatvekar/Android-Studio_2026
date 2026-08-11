package com.example.fitnexa2;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ExerciseService {

    @GET("dist/exercises.json")
    Call<List<Exercise>> getExercises();

    static ExerciseService getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/yuhonas/free-exercise-db/main/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ExerciseService.class);
    }
}