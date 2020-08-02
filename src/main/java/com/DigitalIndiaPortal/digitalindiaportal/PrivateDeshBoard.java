package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrivateDeshBoard extends AppCompatActivity {
    Button jumPvt,pvtLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_desh_board);
        jumPvt=findViewById(R.id.jumpPvt);
        pvtLogout=findViewById(R.id.pvtlogOut);

        jumPvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpPvtJob = new Intent(PrivateDeshBoard.this,PvtAddActivity.class);
                startActivity(jumpPvtJob);
            }
        });
        pvtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpPvtLogin  = new Intent(PrivateDeshBoard.this,PvtLogin.class);
                startActivity(jumpPvtLogin);
            }
        });
    }
}