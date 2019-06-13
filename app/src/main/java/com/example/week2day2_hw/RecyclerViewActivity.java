package com.example.week2day2_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvAnimalRecyclerView;
    ArrayList<AnimalList> animalList = new ArrayList<>();
    Intent passedIntent;
    int categoryType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        passedIntent = getIntent();

        // get the intent passed from CategoryListViewActivity
        categoryType = passedIntent.getIntExtra("category_type", 0);

        // populate ArrayList with appropriate elements given the category type (0 for land, 1 for water)
        if (categoryType == 0) {
            populateLandAnimalList();   // populate with land animals
            callRecyclerView();
            //finish();
        }
        if (categoryType == 1) {
            populateWaterAnimalList();  // populate with water animals
            callRecyclerView();
            //finish();
        }
    }

    // Bind the Recycler view to the layout, layout manager and create the adapter.
    // This will actually display the layout defined in the AnimalRecyclerViewAdapter
    private void callRecyclerView(){
        rvAnimalRecyclerView = findViewById(R.id.rvAnimalRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        AnimalRecyclerViewAdapter animalRecyclerViewAdapter = new AnimalRecyclerViewAdapter(animalList);

        // our Adapter class has a setInstance method we made. We pass in this activity to create an instance,
        // so we can later call our DescriptionActivity
        animalRecyclerViewAdapter.setInstance(this);

        rvAnimalRecyclerView.setLayoutManager(layoutManager);
        rvAnimalRecyclerView.setAdapter(animalRecyclerViewAdapter);
    }

    private void populateLandAnimalList(){
        animalList.add(new AnimalList("Cheetah", "0-60 faster than your secondhand civic"));
        animalList.add(new AnimalList("Dog","Abuse it and you answer to John Wick"));
        animalList.add(new AnimalList("Hyena", "Why are these idiots always laughing?"));
        animalList.add(new AnimalList("Dinosaur", "Yes I know they're extinct but they're still cool ok!"));
    }

    private void populateWaterAnimalList(){
        animalList.add(new AnimalList("Shark", "Kills less people per year than cows"));
        animalList.add(new AnimalList("Dolphin", "Super smart, friendly, and definitely up to something"));
        animalList.add(new AnimalList("Stringray", "Why did they kill my boy Steve Irwin?"));
        animalList.add(new AnimalList("Lobster", "Why are you guys so expensive"));
    }
} // end Activity

