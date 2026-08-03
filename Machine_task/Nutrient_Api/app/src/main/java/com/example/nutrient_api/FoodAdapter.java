package com.example.nutrient_api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    List<Food> foods;

    public FoodAdapter(List<Food> foods) {
        this.foods = foods;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtName,txtCategory, txtCalorie, txtServing, txtProtein, txtFat, txtCarbs, txtFiber;
        public FoodViewHolder(View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtId);
            txtName = itemView.findViewById(R.id.txtName);
            txtCategory = itemView.findViewById(R.id.txtCategory);
            txtServing = itemView.findViewById(R.id.txtServing);
            txtCalorie = itemView.findViewById(R.id.txtCalories);
            txtFiber = itemView.findViewById(R.id.txtFiber);
            txtProtein = itemView.findViewById(R.id.txtProtein);
            txtCarbs = itemView.findViewById(R.id.txtCarbs);
            txtFat = itemView.findViewById(R.id.txtFat);
        }

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View foodView = layoutInflater.inflate(R.layout.food_activity,parent, false);
        return new FoodViewHolder(foodView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food =  foods.get(position);
        holder.txtId.setText(food.getId() + "");
        holder.txtName.setText( food.getName());
        holder.txtCategory.setText("Category: " + food.getCategory());
        holder.txtServing.setText("Serving Size: " + food.getServingSize());
        holder.txtCalorie.setText("Calorie: \n" + food.getCalories() + "");
        holder.txtFiber.setText("Fiber: \n" + food.getFiber() + "");
        holder.txtProtein.setText("Protein: \n" + food.getProtein() + "");
        holder.txtCarbs.setText("Carbs: \n" + food.getCarbs() + "");
        holder.txtFat.setText("Fats: \n" + food.getFat() + "");
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

}
