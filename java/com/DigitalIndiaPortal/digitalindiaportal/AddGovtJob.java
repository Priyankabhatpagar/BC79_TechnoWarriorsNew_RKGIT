package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddGovtJob extends AppCompatActivity {
    EditText addUrl,detailTitle,detailQualification,detailAge,detailLocation,detailPost,detailSummary,detailStart,detailLast,detailSeat,detailFee;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_govt_job);
        detailTitle=findViewById(R.id.addgovtTtitle);
        detailQualification=findViewById(R.id.addgovtQualification);
        detailAge=findViewById(R.id.addgovtAge);
        detailLocation=findViewById(R.id.addgovtlocation);
        detailPost=findViewById(R.id.addgovtPost);
        detailSummary=findViewById(R.id.addgovtSummary);
        detailStart=findViewById(R.id.addgovtStart);
        detailLast=findViewById(R.id.addgovtLast);
        detailSeat=findViewById(R.id.addgovtSeat);
        detailFee=findViewById(R.id.addgovtFee);
       addUrl=findViewById(R.id.addUrl);

        submitButton=findViewById(R.id.submitGovtjob);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               UploadGovtJob();
            }
        });
    }
    public void UploadGovtJob(){
       GovtJobModel uploadJob =new GovtJobModel(
               detailTitle.getText().toString(),
               detailQualification.getText().toString(),
               detailAge.getText().toString(),
               detailLocation.getText().toString(),
               detailPost.getText().toString(),
               detailSummary.getText().toString(),
               detailStart.getText().toString(),
               detailLast.getText().toString(),
               detailSeat.getText().toString(),
               detailFee.getText().toString(),
               addUrl.getText().toString()








       );
        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        FirebaseDatabase.getInstance().getReference("GovtJobs").child(currentDate).setValue(uploadJob).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(AddGovtJob.this, "add SuccessFull", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}