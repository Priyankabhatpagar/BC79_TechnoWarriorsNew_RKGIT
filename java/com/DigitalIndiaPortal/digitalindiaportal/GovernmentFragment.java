package com.DigitalIndiaPortal.digitalindiaportal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GovernmentFragment extends Fragment {

RecyclerView recyclerView;
private DatabaseReference databaseReference;
private ValueEventListener valueEventListener;
List<GovtJobModel> govtJobModels;
GovtJobModel govtJobModel;
ProgressBar progressBar;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_government,container,false);
            recyclerView=view.findViewById(R.id.recyclerView);
            progressBar=view.findViewById(R.id.progressbar);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(gridLayoutManager);



      govtJobModels=new ArrayList<>();
      final  GovtJobAdpter govtJobAdpter = new GovtJobAdpter(getActivity(),govtJobModels);
        recyclerView.setAdapter(govtJobAdpter);
        databaseReference= FirebaseDatabase.getInstance().getReference("GovtJobs");
        valueEventListener=databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                govtJobModels.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()){


                    GovtJobModel info=itemSnapshot.getValue(GovtJobModel.class);
                    govtJobModels.add(info);

                }

                govtJobAdpter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

  return view;
    }
}