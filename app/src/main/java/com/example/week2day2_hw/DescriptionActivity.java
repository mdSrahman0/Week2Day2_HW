// The final activity to be displayed in our application.

package com.example.week2day2_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView tvShowDescription; 
    Intent intent;
    String animalDescription = ""; // the position of the animal that was clicked in the recycler view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        tvShowDescription = findViewById(R.id.tvShowDescription);

        // get the passed in intent
        intent = getIntent();

        // set the string to the passed in description
        animalDescription = intent.getStringExtra("animal_passed_in");
        tvShowDescription.setText(animalDescription);
    }
}
