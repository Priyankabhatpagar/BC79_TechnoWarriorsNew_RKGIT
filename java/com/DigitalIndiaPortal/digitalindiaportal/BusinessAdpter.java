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

public class BusinessAdpter extends RecyclerView.Adapter<BusinessViewHolder> {
    Context context;
    List<BusinessModel> businessModels;

    public BusinessAdpter(Context context, List<BusinessModel> businessModels) {
        this.context = context;
        this.businessModels = businessModels;
    }

    @Override
    public BusinessViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tender_item,parent,false);
        return new BusinessViewHolder(view);
    }

    @Override
    public void onBindViewHolder( final BusinessViewHolder holder, int position) {
        holder.busITitle.setText(businessModels.get(position).getTitle());
        holder.busIEmail.setText(businessModels.get(position).getEmail());
        holder.busIPhone.setText(businessModels.get(position).getPhone());
        holder.busIDes.setText(businessModels.get(position).getDescription());
        holder.busIOther.setText(businessModels.get(position).getOther());
        holder.busIUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpBus = new Intent(context,BusWebView.class);
                jumpBus.putExtra("busUrl",businessModels.get(holder.getAdapterPosition()).getUrl());
                context.startActivity(jumpBus);
            }
        });

    }

    @Override
    public int getItemCount() {
        return businessModels.size();
    }
}
class BusinessViewHolder extends RecyclerView.ViewHolder{
    TextView busITitle,busIEmail,busIPhone,busIDes,busIOther;

    Button busIUrl;

    public BusinessViewHolder(@NonNull View itemView) {
        super(itemView);
        busITitle=itemView.findViewById(R.id.busTitle);
        busIEmail=itemView.findViewById(R.id.busEmail);
        busIPhone=itemView.findViewById(R.id.busPhone);
        busIDes=itemView.findViewById(R.id.busDes);
        busIOther=itemView.findViewById(R.id.busDetail);
        busIUrl=itemView.findViewById(R.id.busUrl);
    }
}