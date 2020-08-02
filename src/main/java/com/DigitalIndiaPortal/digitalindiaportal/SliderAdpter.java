package com.DigitalIndiaPortal.digitalindiaportal;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdpter extends SliderViewAdapter<sliderViewHolder>{
        Context context;
        int setTtoal;
        String Update;

    public SliderAdpter(Context context, int setTtoal) {
        this.context = context;
        this.setTtoal = setTtoal;
    }

    @Override
    public sliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,parent,false);
        return new sliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final sliderViewHolder viewHolder,final int position) {
        FirebaseDatabase.getInstance().getReference("Updates").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                switch (position){

                    case 0:
                        Update=dataSnapshot.child("1").getValue(String.class);
                        viewHolder.sliderTextView.setText(Update);
                        viewHolder.sliderTextView.setTextColor(Color.BLACK);

                        break;
                    case 1:
                        Update=dataSnapshot.child("2").getValue(String.class);
                        viewHolder.sliderTextView.setText(Update);
                        viewHolder.sliderTextView.setTextColor(Color.BLACK);

                        break;
                    case 2:
                        Update=dataSnapshot.child("3").getValue(String.class);
                        viewHolder.sliderTextView.setText(Update);
                        viewHolder.sliderTextView.setTextColor(Color.BLACK);

                        break;
                    case 3:
                        Update=dataSnapshot.child("4").getValue(String.class);
                        viewHolder.sliderTextView.setText(Update);
                        viewHolder.sliderTextView.setTextColor(Color.BLACK);

                        break;
                    case 4:
                        Update=dataSnapshot.child("5").getValue(String.class);
                        viewHolder.sliderTextView.setText(Update);
                        viewHolder.sliderTextView.setTextColor(Color.BLACK);

                        break;
                    case 5:
                        Update=dataSnapshot.child("6").getValue(String.class);
                        viewHolder.sliderTextView.setText(Update);
                        viewHolder.sliderTextView.setTextColor(Color.BLACK);

                        break;
                    case 6:
                        Update=dataSnapshot.child("7").getValue(String.class);
                        viewHolder.sliderTextView.setText(Update);
                        viewHolder.sliderTextView.setTextColor(Color.BLACK);

                        break;
                    case 7:
                        Update=dataSnapshot.child("8").getValue(String.class);
                        viewHolder.sliderTextView.setText(Update);
                        viewHolder.sliderTextView.setTextColor(Color.BLACK);

                        break;
                    case 8:
                        Update=dataSnapshot.child("9").getValue(String.class);
                        viewHolder.sliderTextView.setText(Update);
                        viewHolder.sliderTextView.setTextColor(Color.BLACK);

                        break;





                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public int getCount() {

        return setTtoal;
    }
}

class sliderViewHolder extends SliderViewAdapter.ViewHolder{

           TextView sliderTextView;
    public sliderViewHolder(View itemView) {
        super(itemView);
        sliderTextView=itemView.findViewById(R.id.slider_item_text);
    }
}


