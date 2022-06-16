package com.nemes.retrofit_newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem home,sports,health,science,entertainment,technology;
    PagerAdapter pagerAdapter;

    String api_key = "df61a47b5ba347439110cde09f5d2b70";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        home = findViewById(R.id.home);
        sports = findViewById(R.id.sports);
        health = findViewById(R.id.health);
        science = findViewById(R.id.science);
        entertainment = findViewById(R.id.entertainment);
        technology = findViewById(R.id.technology);

        ViewPager viewPager = findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.tab_layout);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}