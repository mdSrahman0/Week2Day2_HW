/**
 * Md Rahman
Create an app which is a directory for all the animals in a zoo.
        1. Activity one: Make a homepage for zoo information
        2. Activity two: ListView with list of all the categories.
        3. Activity three: RecyclerView with a list of all the animals in that category
        4. Activity four: Detail of that animal selected from the list.
        It should have the detail of that animal and play a sound of that animal.
*/
package com.example.week2day2_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.btCategory) {
            Intent intent = new Intent(this, CategoryListViewActivity.class);
            startActivity(intent);
        }
    } // end onClick
} // end main activity
