package com.DigitalIndiaPortal.digitalindiaportal;

public class GovtJobModel {
    String jobTitle;
    String jobQualification;
    String jobAge;
    String jobLocation;
    String jobPost;
    String jobSummary;
    String jobStart;
    String jobLast;
    String jobSeat;
    String jobFee;
    String jobUrl;

    public String getMjobUrl() {
        return mjobUrl;
    }

    public void setMjobUrl(String mjobUrl) {
        this.mjobUrl = mjobUrl;
    }

    String mjobUrl;

    GovtJobModel(){}

    public String getJobSeat() {
        return jobSeat;
    }

    public void setJobSeat(String jobSeat) {
        this.jobSeat = jobSeat;
    }

    public String getJobFee() {
        return jobFee;
    }

    public void setJobFee(String jobFee) {
        this.jobFee = jobFee;
    }





    public GovtJobModel(String jobTitle, String jobQualification, String jobAge, String jobLocation, String jobPost, String jobSummary, String jobStart, String jobLast, String jobSeat,String jobFee,String mjobUrl) {
        this.jobTitle = jobTitle;
        this.jobQualification = jobQualification;
        this.jobAge = jobAge;
        this.jobLocation = jobLocation;
        this.jobPost = jobPost;
        this.jobSummary = jobSummary;
        this.jobStart = jobStart;
        this.jobLast = jobLast;
        this.jobSeat=jobSeat;
        this.jobFee=jobFee;
        this.mjobUrl=mjobUrl;


    }




    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobQualification() {
        return jobQualification;
    }

    public void setJobQualification(String jobQualification) {
        this.jobQualification = jobQualification;
    }

    public String getJobAge() {
        return jobAge;
    }

    public void setJobAge(String jobAge) {
        this.jobAge = jobAge;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobPost() {
        return jobPost;
    }

    public void setJobPost(String jobPost) {
        this.jobPost = jobPost;
    }

    public String getJobSummary() {
        return jobSummary;
    }

    public void setJobSummary(String jobSummary) {
        this.jobSummary = jobSummary;
    }

    public String getJobStart() {
        return jobStart;
    }

    public void setJobStart(String jobStart) {
        this.jobStart = jobStart;
    }

    public String getJobLast() {
        return jobLast;
    }

    public void setJobLast(String jobLast) {
        this.jobLast = jobLast;
    }


}
