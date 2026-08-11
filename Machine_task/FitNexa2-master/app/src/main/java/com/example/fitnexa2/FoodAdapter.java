package com.example.fitnexa2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> implements Filterable {

    private List<Food> foods;
    private List<Food> foodsFull;

    public FoodAdapter(List<Food> foods) {
        this.foods = foods;
        this.foodsFull = new ArrayList<>(foods);
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtCalorie, txtServing, txtProtein, txtFat, txtCarbs, txtFiber;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtFoodName);
            txtServing = itemView.findViewById(R.id.txtServing);
            txtCalorie = itemView.findViewById(R.id.txtCalories);
            txtFiber = itemView.findViewById(R.id.txtFiber);
            txtProtein = itemView.findViewById(R.id.protein);
            txtCarbs = itemView.findViewById(R.id.carbs);
            txtFat = itemView.findViewById(R.id.fat);
        }
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.diet_view_holder, parent, false);

        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        Food food = foods.get(position);

        holder.txtName.setText(food.getName());
        holder.txtServing.setText("Serving Size: " + food.getServingSize());
        holder.txtCalorie.setText("Calories:\n" + food.getCalories());
        holder.txtFiber.setText("Fiber:\n" + food.getFiber());
        holder.txtProtein.setText("Protein:\n" + food.getProtein());
        holder.txtCarbs.setText("Carbs:\n" + food.getCarbs());
        holder.txtFat.setText("Fat:\n" + food.getFat());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    @Override
    public Filter getFilter() {
        return foodFilter;
    }

    private final Filter foodFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Food> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {

                filteredList.addAll(foodsFull);

            } else {

                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Food item : foodsFull) {

                    if (item.getName().toLowerCase().contains(filterPattern)
                            || item.getCategory().toLowerCase().contains(filterPattern)
                            || item.getServingSize().toLowerCase().contains(filterPattern)) {

                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            foods.clear();
            foods.addAll((List<Food>) results.values);
            notifyDataSetChanged();
        }
    };

    public void updateData(List<Food> newFoods) {

        foods.clear();
        foods.addAll(newFoods);

        foodsFull.clear();
        foodsFull.addAll(newFoods);

        notifyDataSetChanged();
    }
}