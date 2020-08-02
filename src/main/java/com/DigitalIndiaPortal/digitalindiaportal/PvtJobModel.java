package com.DigitalIndiaPortal.digitalindiaportal;

public class PvtJobModel {
    String pvtTitle;
    String pvtQualification;
    String pvtAge;
    String pvtLocation;
    String pvtPost;
    String pvtCompanyName;
    String pvtSeat;
    String pvtContactDetails;
    String pvtSummary;
    String pvtUrl;
    PvtJobModel(){}

    public PvtJobModel(String pvtTitle, String pvtQualification, String pvtAge, String pvtLocation, String pvtPost, String pvtCompanyName, String pvtSeat, String pvtContactDetails, String pvtSummary, String pvtUrl) {
        this.pvtTitle = pvtTitle;
        this.pvtQualification = pvtQualification;
        this.pvtAge = pvtAge;
        this.pvtLocation = pvtLocation;
        this.pvtPost = pvtPost;
        this.pvtCompanyName = pvtCompanyName;
        this.pvtSeat = pvtSeat;
        this.pvtContactDetails = pvtContactDetails;
        this.pvtSummary = pvtSummary;
        this.pvtUrl = pvtUrl;
    }

    public String getPvtTitle() {
        return pvtTitle;
    }

    public void setPvtTitle(String pvtTitle) {
        this.pvtTitle = pvtTitle;
    }

    public String getPvtQualification() {
        return pvtQualification;
    }

    public void setPvtQualification(String pvtQualification) {
        this.pvtQualification = pvtQualification;
    }

    public String getPvtAge() {
        return pvtAge;
    }

    public void setPvtAge(String pvtAge) {
        this.pvtAge = pvtAge;
    }

    public String getPvtLocation() {
        return pvtLocation;
    }

    public void setPvtLocation(String pvtLocation) {
        this.pvtLocation = pvtLocation;
    }

    public String getPvtPost() {
        return pvtPost;
    }

    public void setPvtPost(String pvtPost) {
        this.pvtPost = pvtPost;
    }

    public String getPvtCompanyName() {
        return pvtCompanyName;
    }

    public void setPvtCompanyName(String pvtCompanyName) {
        this.pvtCompanyName = pvtCompanyName;
    }

    public String getPvtSeat() {
        return pvtSeat;
    }

    public void setPvtSeat(String pvtSeat) {
        this.pvtSeat = pvtSeat;
    }

    public String getPvtContactDetails() {
        return pvtContactDetails;
    }

    public void setPvtContactDetails(String pvtContactDetails) {
        this.pvtContactDetails = pvtContactDetails;
    }

    public String getPvtSummary() {
        return pvtSummary;
    }

    public void setPvtSummary(String pvtSummary) {
        this.pvtSummary = pvtSummary;
    }

    public String getPvtUrl() {
        return pvtUrl;
    }

    public void setPvtUrl(String pvtUrl) {
        this.pvtUrl = pvtUrl;
    }
}
