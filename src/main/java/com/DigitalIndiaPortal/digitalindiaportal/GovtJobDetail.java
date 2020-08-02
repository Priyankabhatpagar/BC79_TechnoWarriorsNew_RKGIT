package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GovtJobDetail extends AppCompatActivity {
    TextView jobTitle,jobQualification,jobAge,jobLocation,jobPost,jobSummary,jobStart,jobLast,jobSeat,jobFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_job_detail);
        jobTitle=findViewById(R.id.govtdetailTitle);
        jobQualification=findViewById(R.id.govtdetailQualification);
        jobAge=findViewById(R.id.govtdetailAge);
        jobLocation=findViewById(R.id.govtdetailLocation);
        jobPost=findViewById(R.id.govtdetailpost);
        jobSummary=findViewById(R.id.govtdetailSummary);
        jobStart=findViewById(R.id.govtstartDate);
        jobLast=findViewById(R.id.govtLastDate);
        jobSeat=findViewById(R.id.govtTotalSeat);
        jobFee=findViewById(R.id.govtFee);



        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            jobTitle.setText(bundle.getString("jobTitle"));
            jobQualification.setText(bundle.getString("jobQualification"));
            jobAge.setText(bundle.getString("jobAge"));
            jobLocation.setText(bundle.getString("jobLocation"));
            jobPost.setText(bundle.getString("jobPost"));
            jobSummary.setText(bundle.getString("jobSummary"));
            jobStart.setText(bundle.getString("jobStart"));
            jobLast.setText(bundle.getString("jobLast"));
            jobSeat.setText(bundle.getString("jobSeat"));
            jobFee.setText(bundle.getString("jobFee"));



        }
    }
}