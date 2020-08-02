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

public class PvtJobAdpter extends RecyclerView.Adapter<pvtViewHolder> {
    Context context;
    List<PvtJobModel> pvtJobModels;

    public PvtJobAdpter(Context context, List<PvtJobModel> pvtJobModels) {
        this.context = context;
        this.pvtJobModels = pvtJobModels;
    }

    @Override
    public pvtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pvt_job_item,parent,false);
        return new pvtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final pvtViewHolder holder, int position) {
           holder.pvtjobTitle.setText(pvtJobModels.get(position).getPvtTitle());
           holder.pvtjobQualification.setText(pvtJobModels.get(position).getPvtQualification());
           holder.pvtjobAge.setText(pvtJobModels.get(position).getPvtAge());
           holder.pvtjobLocation.setText(pvtJobModels.get(position).getPvtLocation());
           holder.pvtjobPost.setText(pvtJobModels.get(position).getPvtPost());
           holder.povtjobCompany.setText(pvtJobModels.get(position).getPvtCompanyName());
           holder.pvtjobSeat.setText(pvtJobModels.get(position).getPvtSeat());
           holder.pvtjobContact.setText(pvtJobModels.get(position).getPvtContactDetails());
           holder.pvtjobSummary.setText(pvtJobModels.get(position).getPvtSummary());
           holder.pvtButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent pvtWebIntent = new Intent(context,PvtWebView.class);
                   pvtWebIntent.putExtra("pvtWebUrl",pvtJobModels.get(holder.getAdapterPosition()).getPvtUrl());
                   context.startActivity(pvtWebIntent);
               }
           });
           holder.pvtCardView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent pvtCardIntent = new Intent(context,PvtDetailActivity.class);
                   pvtCardIntent.putExtra("pvtTitle",pvtJobModels.get(holder.getAdapterPosition()).getPvtTitle());
                   pvtCardIntent.putExtra("pvtQualification",pvtJobModels.get(holder.getAdapterPosition()).getPvtQualification());
                   pvtCardIntent.putExtra("pvtAge",pvtJobModels.get(holder.getAdapterPosition()).getPvtAge());
                   pvtCardIntent.putExtra("pvtLocation",pvtJobModels.get(holder.getAdapterPosition()).getPvtLocation());
                   pvtCardIntent.putExtra("pvtPost",pvtJobModels.get(holder.getAdapterPosition()).getPvtPost());
                   pvtCardIntent.putExtra("pvtCompany",pvtJobModels.get(holder.getAdapterPosition()).getPvtCompanyName());
                   pvtCardIntent.putExtra("pvtSeat",pvtJobModels.get(holder.getAdapterPosition()).getPvtSeat());
                   pvtCardIntent.putExtra("pvtContact",pvtJobModels.get(holder.getAdapterPosition()).getPvtContactDetails());
                   pvtCardIntent.putExtra("pvtSummary",pvtJobModels.get(holder.getAdapterPosition()).getPvtSummary());
                   context.startActivity(pvtCardIntent);
               }
           });

    }

    @Override
    public int getItemCount() {
        return pvtJobModels.size();
    }
}
class pvtViewHolder extends RecyclerView.ViewHolder{
    TextView pvtjobTitle,pvtjobQualification,pvtjobAge,pvtjobLocation,pvtjobPost,povtjobCompany,pvtjobSeat,pvtjobContact,pvtjobSummary;
    Button pvtButton;
    CardView pvtCardView;

    public pvtViewHolder(@NonNull View itemView) {
        super(itemView);
        pvtjobTitle=itemView.findViewById(R.id.pvtJobTitle);
        pvtjobQualification=itemView.findViewById(R.id.pvtQualification);
        pvtjobAge=itemView.findViewById(R.id.pvtAge);
        pvtjobLocation=itemView.findViewById(R.id.pvtlocation);
        pvtjobPost=itemView.findViewById(R.id.pvtPost);
        povtjobCompany=itemView.findViewById(R.id.pvtCompany);
        pvtjobSeat=itemView.findViewById(R.id.pvtSeat);
        pvtjobContact=itemView.findViewById(R.id.pvtContacts);
        pvtjobSummary=itemView.findViewById(R.id.pvtSummary);
        pvtButton=itemView.findViewById(R.id.pvtJobUrl);
        pvtCardView=itemView.findViewById(R.id.pvtCardView);
    }
}