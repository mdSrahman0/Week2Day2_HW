package com.example.week2day2_hw;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week2day2_hw.AnimalList;

import java.util.ArrayList;

public class AnimalRecyclerViewAdapter extends RecyclerView.Adapter<AnimalRecyclerViewAdapter.ViewHolder> {

    ArrayList<AnimalList> animalList = new ArrayList<>();

    // we need this because startActivity() can only be referenced from an Activity, not a class
    private RecyclerViewActivity instance;

    public AnimalRecyclerViewAdapter(ArrayList<AnimalList> animalList) {
        this.animalList = animalList;
    }

    public void setInstance(RecyclerViewActivity instance){
        this.instance = instance;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup,
                false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        final AnimalList itemsAnimals = animalList.get(position);
        viewHolder.tvShowAnimals.setText(itemsAnimals.getName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // Get the description of the animal that was clicked.
               String description = itemsAnimals.getDescription();

               // pass the instance of the RecyclerViewActivity and the activity to go to
               Intent intent = new Intent(instance, DescriptionActivity.class);
               intent.putExtra("animal_passed_in", description);
               instance.startActivity(intent);  // start the activity
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvShowAnimals;

        public ViewHolder(View itemView) {
            super(itemView);
            tvShowAnimals = itemView.findViewById(R.id.tvShowAnimals);
        }
    }
}


