package com.example.medicare.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.Adaptor.CategoryAdaptor;
import com.example.medicare.Adaptor.PoplurarAdaptor;
import com.example.medicare.Domain.CategoryDomain;
import com.example.medicare.Domain.MedicareDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import medicare.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Drugs", "ct1"));
        category.add(new CategoryDomain("Vitamin", "ct2"));
        category.add(new CategoryDomain("Supplies", "ct3"));
        category.add(new CategoryDomain("1st Aid", "ct4"));
        category.add(new CategoryDomain("21", "ct5"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<MedicareDomain> foodList = new ArrayList<>();
        foodList.add(new MedicareDomain("Blackmores", "popular1", "Blackmores Vitamin D3 1000 IU can assist in building and maintaining healthy bones. Vitamin D3 promotes the absorption of calcium and can help to support healthy muscles.\n" +
                "Size: 200 capsules\n" +
                "\n" +
                "Ingredients\n" +
                "Active Ingredients: Cholecalciferol (vitamin D3 1000 IU) 25 microgram", 200.0));
        foodList.add(new MedicareDomain("Paracetamol", "popular2", "Paracetamol Grindeks 500 mg tablets are drugs with antipyretic and analgesic effects, used for fever and moderate pain.", 25.0));
        foodList.add(new MedicareDomain("TestPack", "popular3", "First Response™ detects the pregnancy hormone 6 days sooner than the day of your missed period (5 days before day of expected period", 225.0));

        adapter2 = new PoplurarAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}