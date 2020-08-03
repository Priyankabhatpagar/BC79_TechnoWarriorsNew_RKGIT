package com.DigitalIndiaPortal.digitalindiaportal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FreelancingAdpter extends RecyclerView.Adapter<FreeViewHolder> {
    Context context;
    List<FreelancingModel> freelancingModels;

    public FreelancingAdpter(Context context, List<FreelancingModel> freelancingModels) {
        this.context = context;
        this.freelancingModels = freelancingModels;
    }

    @Override
    public FreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
             View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.freelancing_item,parent,false);
        return new FreeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FreeViewHolder holder, int position) {
        holder.freeTitle.setText(freelancingModels.get(position).getTitle());
        holder.freeEmail.setText(freelancingModels.get(position).getEmail());
        holder.freePhone.setText(freelancingModels.get(position).getPhone());
        holder.freeDes.setText(freelancingModels.get(position).getDescription());
        holder.freeOther.setText(freelancingModels.get(position).getOther());
        holder.freeUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpUrl = new Intent(context,FreeWebView.class);
                jumpUrl.putExtra("freeUrl",freelancingModels.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(jumpUrl);
            }
        });

    }

    @Override
    public int getItemCount() {
        return freelancingModels.size();
    }
}
class FreeViewHolder extends RecyclerView.ViewHolder {
    TextView freeTitle,freeEmail,freePhone,freeDes,freeOther;
    CardView freeCardView;
    Button freeUrl;
    public FreeViewHolder(@NonNull View itemView) {
        super(itemView);
        freeTitle=itemView.findViewById(R.id.freeTitle);
        freeEmail=itemView.findViewById(R.id.freeEmail);
        freePhone=itemView.findViewById(R.id.freePhone);
        freeDes=itemView.findViewById(R.id.freeDescription);
        freeOther=itemView.findViewById(R.id.freeDetail);
        freeCardView=itemView.findViewById(R.id.freeCardView);
        freeUrl=itemView.findViewById(R.id.freeUrl);

    }



        }
