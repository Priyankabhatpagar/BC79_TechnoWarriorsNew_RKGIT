package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPanel extends AppCompatActivity {
    Button adminLogout,addFree,addTen,addBus,addCourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        adminLogout=findViewById(R.id.adminLogOut);
        addFree=findViewById(R.id.freelancer);
        addTen=findViewById(R.id.clickTender);
        addBus=findViewById(R.id.clickBus);
        addCourse=findViewById(R.id.Course);
        addTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpTen = new Intent(AdminPanel.this,AddTender.class);
                startActivity(jumpTen);
            }
        });
        adminLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpLogin = new Intent(AdminPanel.this,AdminLogin.class);
                startActivity(jumpLogin);
            }
        });
        addFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpFree = new Intent(AdminPanel.this,AddFreeLancing.class);
                startActivity(jumpFree);
            }
        });
        addBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(AdminPanel.this,AddBusIdea.class);
                startActivity(newIntent);
            }
        });
    }
}