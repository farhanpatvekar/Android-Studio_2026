package com.example.intershipproject;


import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface FoodService {

    @GET("foods.json")
    Call<List<Food>> getFoods();

    static FoodService getInstance() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/farhanpatvekar/Nutrients/main/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create(FoodService.class);
    }
}