package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDetail extends AppCompatActivity {
    Button freeLancing,tender,userLogOut,busIdea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        freeLancing=findViewById(R.id.freeLancing);
        tender=findViewById(R.id.Tender);
        userLogOut=findViewById(R.id.userLogout);
        busIdea=findViewById(R.id.BandS);


        userLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpBack= new Intent(UserDetail.this,UserLogin.class);
                startActivity(jumpBack);
            }
        });
        tender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpTen = new Intent(UserDetail.this,Tender.class);
                startActivity(jumpTen);
            }
        });
        freeLancing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpFree = new  Intent(UserDetail.this,Freelancing.class);
                startActivity(jumpFree);
            }
        });
        busIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpBusId=new Intent(UserDetail.this,BusinessIdea.class);
                startActivity(jumpBusId);
            }
        });

    }
}