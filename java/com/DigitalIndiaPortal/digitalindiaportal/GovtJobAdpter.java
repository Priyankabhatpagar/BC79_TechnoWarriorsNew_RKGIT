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

public class GovtJobAdpter extends RecyclerView.Adapter<viewHolder> {
    Context context;

    public GovtJobAdpter(Context context, List<GovtJobModel> govtJobModels) {
        this.context = context;
        this.govtJobModels = govtJobModels;
    }

    List<GovtJobModel> govtJobModels;

    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.govt_job_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {
           holder.jobTitle.setText(govtJobModels.get(position).getJobTitle());
           holder.jobQualification.setText(govtJobModels.get(position).getJobQualification());
           holder.jobAge.setText(govtJobModels.get(position).getJobAge());
           holder.jobLocation.setText(govtJobModels.get(position).getJobLocation());
           holder.jobPost.setText(govtJobModels.get(position).getJobPost());
           holder.jobSummary.setText(govtJobModels.get(position).getJobSummary());
           holder.jobStart.setText(govtJobModels.get(position).getJobStart());
           holder.jobLast.setText(govtJobModels.get(position).getJobLast());
           holder.jobSeat.setText(govtJobModels.get(position).getJobSeat());
           holder.jobFee.setText(govtJobModels.get(position).getJobFee());
           holder.mjobUrl.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent urlIntent = new Intent(context,GovtWebView.class);
                   urlIntent.putExtra("govtUrl",govtJobModels.get(holder.getAdapterPosition()).getMjobUrl());
                       context.startActivity(urlIntent);
               }
           });


           holder.govtcardView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent govtIntent = new Intent(context,GovtJobDetail.class);
                   govtIntent.putExtra("jobTitle",govtJobModels.get(holder.getAdapterPosition()).getJobTitle());
                   govtIntent.putExtra("jobQualification",govtJobModels.get(holder.getAdapterPosition()).getJobQualification());
                   govtIntent.putExtra("jobAge",govtJobModels.get(holder.getAdapterPosition()).getJobAge());
                   govtIntent.putExtra("jobLocation",govtJobModels.get(holder.getAdapterPosition()).getJobLocation());
                   govtIntent.putExtra("jobPost",govtJobModels.get(holder.getAdapterPosition()).getJobPost());
                   govtIntent.putExtra("jobSummary",govtJobModels.get(holder.getAdapterPosition()).getJobSummary());
                   govtIntent.putExtra("jobStart",govtJobModels.get(holder.getAdapterPosition()).getJobStart());
                   govtIntent.putExtra("jobLast",govtJobModels.get(holder.getAdapterPosition()).getJobLast());
                   govtIntent.putExtra("jobSeat",govtJobModels.get(holder.getAdapterPosition()).getJobSeat());
                   govtIntent.putExtra("jobFee",govtJobModels.get(holder.getAdapterPosition()).getJobFee());


                   context.startActivity(govtIntent);
               }
           });
    }

    @Override
    public int getItemCount() {
        return govtJobModels.size();
    }
}
class viewHolder extends RecyclerView.ViewHolder{
           TextView jobTitle,jobQualification,jobAge,jobLocation,jobPost,jobSummary,jobStart,jobLast,jobSeat,jobFee;
           Button mjobUrl;
            CardView govtcardView;
    public viewHolder(@NonNull View itemView) {
        super(itemView);
        jobTitle=itemView.findViewById(R.id.JobTitle);
        jobQualification=itemView.findViewById(R.id.Qualification);
        jobAge=itemView.findViewById(R.id.Age);
        jobLocation=itemView.findViewById(R.id.location);
        jobPost=itemView.findViewById(R.id.post);
        jobSummary=itemView.findViewById(R.id.govtSummary);
        jobStart=itemView.findViewById(R.id.govtStart);
        jobLast=itemView.findViewById(R.id.govtLast);
        jobSeat=itemView.findViewById(R.id.govtSeat);
        jobFee=itemView.findViewById(R.id.govtsFee);
        mjobUrl=itemView.findViewById(R.id.bjobUrl);





        govtcardView=itemView.findViewById(R.id.govtCardview);
    }
}