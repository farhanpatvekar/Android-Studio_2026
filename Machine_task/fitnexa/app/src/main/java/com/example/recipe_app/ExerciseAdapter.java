package com.example.recipe_app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    List<Exercise> exercises;

    public ExerciseAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }
    class ExerciseViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtEquipment, txtLevel;
        ImageView imageViewHolder;

        public ExerciseViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtEquipment = itemView.findViewById(R.id.txtEquipment);
            txtLevel = itemView.findViewById(R.id.txtLevel);
            imageViewHolder = itemView.findViewById(R.id.imageViewHolder);
        }

    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View exerciseView = layoutInflater.inflate(
                R.layout.exercise_viewholder,
                parent,
                false
        );
        return new ExerciseViewHolder(exerciseView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);

        holder.txtName.setText(exercise.getName());
        holder.txtLevel.setText(exercise.getLevel());
        holder.txtEquipment.setText(exercise.getEquipment());
        Log.d("IMAGE_LIST", String.valueOf(exercise.getImages()));

        if (exercise.getImages() != null && !exercise.getImages().isEmpty()) {

            String imageURL = "https://raw.githubusercontent.com/yuhonas/free-exercise-db/main/exercises/"
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

}
