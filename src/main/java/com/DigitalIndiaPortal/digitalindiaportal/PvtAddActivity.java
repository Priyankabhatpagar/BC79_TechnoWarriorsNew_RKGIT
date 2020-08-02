package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class PvtAddActivity extends AppCompatActivity {
    TextView addpvtTitle, addpvtQualification, addpvtAge, addpvtLocation, addpvtPost, addpvtSummary, addpvtCompany, addpvtContact, addpvtSeat, addpvtUrl;
    Button pvtButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvt_add);
        addpvtTitle = findViewById(R.id.addpvtTitle);
        addpvtQualification = findViewById(R.id.addPvtQualification);
        addpvtAge = findViewById(R.id.addPvtAge);
        addpvtLocation = findViewById(R.id.addPvtLocation);
        addpvtPost = findViewById(R.id.addPvtPost);
        addpvtSummary = findViewById(R.id.addPvtSummary);
        addpvtCompany = findViewById(R.id.addpvtCompany);
        addpvtSeat = findViewById(R.id.addPvtSeat);
        addpvtContact = findViewById(R.id.addpvtContact);
        addpvtUrl = findViewById(R.id.addpvtUrl);
        pvtButton=findViewById(R.id.submitPvtJob);
        pvtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadPvtJob();
            }
        });
    }

    public void UploadPvtJob() {
        PvtJobModel uploadJob = new PvtJobModel(
                addpvtTitle.getText().toString(),
                addpvtQualification.getText().toString(),
                addpvtAge.getText().toString(),
                addpvtLocation.getText().toString(),
                addpvtPost.getText().toString(),
                addpvtCompany.getText().toString(),
                addpvtSeat.getText().toString(),
                addpvtContact.getText().toString(),
                addpvtSummary.getText().toString(),
                addpvtUrl.getText().toString()


        );
        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        FirebaseDatabase.getInstance().getReference("PvtJobs").child(currentDate).setValue(uploadJob).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(PvtAddActivity.this, "add SuccessFull", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}