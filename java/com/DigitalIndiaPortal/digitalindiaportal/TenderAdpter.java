package com.DigitalIndiaPortal.digitalindiaportal;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TenderAdpter extends RecyclerView.Adapter<TenderViewHolder> {

    Context context;
    List<TenderModel> tenderModels;

    public TenderAdpter(Context context, List<TenderModel> tenderModels) {
        this.context = context;
        this.tenderModels = tenderModels;
    }

    @Override
    public TenderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tender_item,parent,false);
        return new TenderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TenderViewHolder holder, int position) {
        holder.tenTitle.setText(tenderModels.get(position).getTitle());
        holder.tenEmail.setText(tenderModels.get(position).getEmail());
        holder.tenPhone.setText(tenderModels.get(position).getPhone());
        holder.tenDes.setText(tenderModels.get(position).getDescription());
        holder.tenOther.setText(tenderModels.get(position).getOther());
        holder.tenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpUrl = new Intent(context,tenWebView.class);
                jumpUrl.putExtra("tenUrl",tenderModels.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(jumpUrl);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tenderModels.size();
    }
}
class TenderViewHolder extends RecyclerView.ViewHolder{

    TextView tenTitle,tenEmail,tenPhone,tenDes,tenOther;

    Button tenUrl;

    public TenderViewHolder(@NonNull View itemView) {
        super(itemView);

        tenTitle=itemView.findViewById(R.id.tenTitle);
        tenEmail=itemView.findViewById(R.id.tenEmail);
        tenPhone=itemView.findViewById(R.id.tenPhone);
        tenDes=itemView.findViewById(R.id.tenDes);
        tenOther=itemView.findViewById(R.id.tenDetail);
        tenUrl=itemView.findViewById(R.id.tenUrl);
    }
}