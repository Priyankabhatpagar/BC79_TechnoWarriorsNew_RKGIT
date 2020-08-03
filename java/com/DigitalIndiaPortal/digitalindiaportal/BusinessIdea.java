package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BusinessIdea extends AppCompatActivity {
    RecyclerView busRecyclerview;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    List<BusinessModel> businessModels;
    BusinessModel businessModel;

    ProgressBar busProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_idea);
        busRecyclerview=findViewById(R.id.busRecyclerview);
        busProgressBar=findViewById(R.id.busProgress);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        busRecyclerview.setLayoutManager(gridLayoutManager);

        businessModels=new ArrayList<>();
        final BusinessAdpter businessAdpter = new BusinessAdpter(this,businessModels);
        busRecyclerview.setAdapter(businessAdpter);
        databaseReference= FirebaseDatabase.getInstance().getReference("BusinessIdea");
        valueEventListener=databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                businessModels.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()){


                    BusinessModel info=itemSnapshot.getValue(BusinessModel.class);
                    businessModels.add(info);

                }

                businessAdpter.notifyDataSetChanged();
                busProgressBar.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}