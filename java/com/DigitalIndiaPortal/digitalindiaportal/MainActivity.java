package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
   private androidx.appcompat.widget.Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager  viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       toolbar=(Toolbar)findViewById(R.id.toolBar);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
           toolbar.setTitle("Digital Info. Portal");
           toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager){

     TabLayoutAdpter tabLayoutAdpter=new TabLayoutAdpter(getSupportFragmentManager());
             tabLayoutAdpter.addFragment(new HomeFragment(),"Home");
             tabLayoutAdpter.addFragment(new GovernmentFragment(),"Govt Jobs");
             tabLayoutAdpter.addFragment(new PrivateFragment(),"Private Jobs");

             viewPager.setAdapter(tabLayoutAdpter);

    }
}