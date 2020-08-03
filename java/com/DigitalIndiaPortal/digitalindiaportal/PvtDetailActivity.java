package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PvtDetailActivity extends AppCompatActivity {
    TextView pvtDTitle,pvtDQualification,pvtDAge,pvtDPost,pvtDLocation,pvtDCompany,pvtDSeat,pvtDContact,pvtDSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvt_detail);
        pvtDTitle=findViewById(R.id.pvtDTitle);
        pvtDQualification=findViewById(R.id.pvtDQualification);
        pvtDAge=findViewById(R.id.pvtDAge);
        pvtDPost=findViewById(R.id.pvtDPost);
        pvtDLocation=findViewById(R.id.pvtDLocation);
        pvtDCompany=findViewById(R.id.pvtDCompany);
        pvtDSeat=findViewById(R.id.pvtDSeat);
        pvtDContact=findViewById(R.id.pvtDContacts);
        pvtDSummary=findViewById(R.id.pvtDSummary);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){

            pvtDTitle.setText(bundle.getString("pvtTitle"));
            pvtDQualification.setText(bundle.getString("pvtQualification"));
            pvtDAge.setText(bundle.getString("pvtAge"));
            pvtDPost.setText(bundle.getString("pvtPost"));
            pvtDLocation.setText(bundle.getString("pvtLocation"));
            pvtDCompany.setText(bundle.getString("pvtCompany"));
            pvtDSeat.setText(bundle.getString("pvtSeat"));
            pvtDContact.setText(bundle.getString("pvtContact"));
            pvtDSummary.setText(bundle.getString("pvtSummary"));



        }
    }
}