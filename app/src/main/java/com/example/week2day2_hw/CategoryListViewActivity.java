package com.example.week2day2_hw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoryListViewActivity extends AppCompatActivity {

    ListView lvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list_view);

        lvCategory = findViewById(R.id.lvCategory);

        // Create a new ArrayList to hold categories of animals
        final ArrayList<String> myList = new ArrayList<>();
        myList.add("Land Animals");
        myList.add("Water Animals");

        // attach the arrayList to an adapter, and pass that adapter to the listview
        ArrayAdapter Adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myList);
        lvCategory.setAdapter(Adapter);

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long l) {
                Intent intent = new Intent(view.getContext(), RecyclerViewActivity.class);

                if(position == 0){
                    intent.putExtra("category_type", 0);
                    startActivity(intent);
                }
                else if(position == 1){
                    intent.putExtra("category_type", 1);
                    startActivity(intent);
                }
            }
        });
    } // end onCreate
} // end class
