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

public class PrivateFragment extends Fragment {
    RecyclerView pvtRecyclerView;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    List<PvtJobModel> pvtJobModels;
    PvtJobModel pvtJobModel;
    ProgressBar pvtProgressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_private, container, false);
        pvtRecyclerView=view.findViewById(R.id.pvtRecyclerView);
        pvtProgressBar=view.findViewById(R.id.pvtProgressBar);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),1);
        pvtRecyclerView.setLayoutManager(gridLayoutManager);

        pvtJobModels=new ArrayList<>();
        final  PvtJobAdpter pvtJobAdpter = new PvtJobAdpter(getActivity(),pvtJobModels);
        pvtRecyclerView.setAdapter(pvtJobAdpter);
        databaseReference= FirebaseDatabase.getInstance().getReference("PvtJobs");
        valueEventListener=databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pvtJobModels.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()){


                    PvtJobModel info=itemSnapshot.getValue(PvtJobModel.class);
                    pvtJobModels.add(info);

                }

                pvtJobAdpter.notifyDataSetChanged();
                pvtProgressBar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}