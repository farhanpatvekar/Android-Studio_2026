package com.example.intershipproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> implements Filterable {

    private List<Exercise> exercises;
    private List<Exercise> exercisesFull;

    public ExerciseAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
        this.exercisesFull = new ArrayList<>(exercises);
    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtEquipment, txtLevel;
        ImageView imageViewHolder;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.textViewForName);
            txtEquipment = itemView.findViewById(R.id.textViewForEquipment2);
            txtLevel = itemView.findViewById(R.id.textViewForLevel);
            imageViewHolder = itemView.findViewById(R.id.exerciseImgView);
        }
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_view_holder, parent, false);

        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {

        Exercise exercise = exercises.get(position);

        holder.txtName.setText(exercise.getName());
        holder.txtEquipment.setText(exercise.getEquipment());
        holder.txtLevel.setText(exercise.getLevel());

        if (exercise.getImages() != null && !exercise.getImages().isEmpty()) {

            String imageURL =
                    "https://raw.githubusercontent.com/yuhonas/free-exercise-db/main/exercises/"
                            + exercise.getImages().get(0);

            Log.d("IMAGE_URL", imageURL);

            Glide.with(holder.itemView.getContext())
                    .load(imageURL)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imageViewHolder);
        }
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    @Override
    public Filter getFilter() {
        return exerciseFilter;
    }

    private final Filter exerciseFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Exercise> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {

                filteredList.addAll(exercisesFull);

            } else {

                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Exercise item : exercisesFull) {

                    boolean matchName = item.getName() != null &&
                            item.getName().toLowerCase().contains(filterPattern);

                    boolean matchEquipment = item.getEquipment() != null &&
                            item.getEquipment().toLowerCase().contains(filterPattern);

                    boolean matchLevel = item.getLevel() != null &&
                            item.getLevel().toLowerCase().contains(filterPattern);

                    if (matchName || matchEquipment || matchLevel) {
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

            exercises.clear();
            exercises.addAll((List<Exercise>) results.values);
            notifyDataSetChanged();
        }
    };

    public void updateData(List<Exercise> newExercises) {

        exercises.clear();
        exercises.addAll(newExercises);

        exercisesFull.clear();
        exercisesFull.addAll(newExercises);

        notifyDataSetChanged();
    }
}