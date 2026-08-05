package com.example.intershipproject;

import java.io.Serializable;

public class Food implements Serializable {
    int id,calories;
    String name;
    String category;
    String servingSize;
    double protein, carbs, fat, fiber;

    public Food(int id, int calories, String name, String category, String servingSize, double protein, double carbs, double fat, double fiber) {
        this.id = id;
        this.calories = calories;
        this.name = name;
        this.category = category;
        this.servingSize = servingSize;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.fiber = fiber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", calories=" + calories +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", servingSize='" + servingSize + '\'' +
                ", protein=" + protein +
                ", carbs=" + carbs +
                ", fat=" + fat +
                ", fiber=" + fiber +
                '}';
    }
}