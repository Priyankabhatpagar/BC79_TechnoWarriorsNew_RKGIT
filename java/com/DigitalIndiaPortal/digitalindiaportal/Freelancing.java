package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
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

public class Freelancing extends AppCompatActivity {
    RecyclerView freeRecyclerview;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    List<FreelancingModel> freelancingModels;
    FreelancingModel freelancingModel;
    Context context;
    ProgressBar freeProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freelancing);
        freeRecyclerview=findViewById(R.id.freeRecyclerview);
        freeProgressBar=findViewById(R.id.freeProgress);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        freeRecyclerview.setLayoutManager(gridLayoutManager);

        freelancingModels=new ArrayList<>();
          final FreelancingAdpter freelancingAdpter = new FreelancingAdpter(this,freelancingModels);
        freeRecyclerview.setAdapter(freelancingAdpter);
        databaseReference= FirebaseDatabase.getInstance().getReference("FreeLancing");
        valueEventListener=databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                freelancingModels.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()){


                    FreelancingModel info=itemSnapshot.getValue(FreelancingModel.class);
                    freelancingModels.add(info);

                }

                freelancingAdpter.notifyDataSetChanged();
                freeProgressBar.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}