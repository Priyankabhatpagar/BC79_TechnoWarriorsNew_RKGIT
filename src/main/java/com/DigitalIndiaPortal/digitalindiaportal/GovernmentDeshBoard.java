package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GovernmentDeshBoard extends AppCompatActivity {
    Button jumpGovtJob,govtLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_desh_board);
        jumpGovtJob=findViewById(R.id.jumpGovtJob);
        govtLogout=findViewById(R.id.logOut);

        jumpGovtJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpgovtjob = new Intent(GovernmentDeshBoard.this,AddGovtJob.class);
                startActivity(jumpgovtjob);
            }
        });
        govtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpLogin= new Intent(GovernmentDeshBoard.this,GovtLoginActivity.class);
                startActivity(jumpLogin);
            }
        });
    }
}