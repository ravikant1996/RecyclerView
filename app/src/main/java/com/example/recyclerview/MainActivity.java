package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.itemClicked{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Person> people;
    Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnadd = findViewById(R.id.addbtn);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people.add(new Person("Munna", "Ray", "Plane"));
                adapter.notifyDataSetChanged();
            }
        });
        recyclerView.setHasFixedSize(true);

//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        layoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<>();
        people.add(new Person("Ravikant", "Yadav", "Bus"));
        people.add(new Person("Ravikant", "Yadav", "Bus"));
        people.add(new Person("Ravikant", "Yadav", "Bus"));
        people.add(new Person("Shashikant", "Yadav", "Plane"));
        people.add(new Person("Vipin", "Yadav", "Bus"));
        people.add(new Person("Vipin", "Yadav", "Bus"));
        people.add(new Person("Vipin", "Yadav", "Bus"));
        people.add(new Person("Laxmi", "Yadav", "Plane"));
        people.add(new Person("Laxmi", "Yadav", "Plane"));
        people.add(new Person("Laxmi", "Yadav", "Plane"));
        adapter= new PersonAdapter(this, people);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname "+ people.get(index).getSurname(), Toast.LENGTH_SHORT).show();

    }
}