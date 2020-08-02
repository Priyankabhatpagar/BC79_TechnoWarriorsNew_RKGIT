package com.DigitalIndiaPortal.digitalindiaportal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment {

Button govtLogin,pvtlogin;
SliderView sliderView;
int setTotal;
ProgressBar sldierProgress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        govtLogin=view.findViewById(R.id.govtLoginClick);
        pvtlogin=view.findViewById(R.id.pvtLoginCLick);
        sliderView=view.findViewById(R.id.imageSlider);
        sldierProgress=view.findViewById(R.id.sliderProgress);
        pvtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumppvtlogin = new Intent(getActivity().getApplication(),PvtLogin.class);
                  startActivity(jumppvtlogin);
            }
        });
        govtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent govtLogin = new Intent(getActivity().getApplication(),GovtLoginActivity.class);
                startActivity(govtLogin);
            }
        });
        FirebaseDatabase.getInstance().getReference("Updates").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long counts =dataSnapshot.getChildrenCount();
                setTotal=counts.intValue();

                sliderView.setSliderAdapter(new SliderAdpter(getContext(),setTotal));
                        sldierProgress.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return view;
    }
}