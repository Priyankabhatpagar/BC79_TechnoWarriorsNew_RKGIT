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

public class Tender extends AppCompatActivity {
    RecyclerView tenRecyclerview;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    List<TenderModel> tenderModels;
    TenderModel tenderModel;

    ProgressBar tenProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender);
        tenRecyclerview=findViewById(R.id.tenRecyclerview);
        tenProgressBar=findViewById(R.id.tenProgress);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        tenRecyclerview.setLayoutManager(gridLayoutManager);
        tenderModels=new ArrayList<>();
        final TenderAdpter tenderAdpter = new TenderAdpter(this,tenderModels);
        tenRecyclerview.setAdapter(tenderAdpter);
        databaseReference= FirebaseDatabase.getInstance().getReference("Tender");
        valueEventListener=databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tenderModels.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()){


                    TenderModel info=itemSnapshot.getValue(TenderModel.class);
                    tenderModels.add(info);

                }

                tenderAdpter.notifyDataSetChanged();
                tenProgressBar.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}