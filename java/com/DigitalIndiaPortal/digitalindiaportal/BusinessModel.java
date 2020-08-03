package com.DigitalIndiaPortal.digitalindiaportal;

public class BusinessModel {
    String Title;
    String Email;
    String Phone;
    String Description;
    String Other;
    String Url;
    BusinessModel(){}

    public BusinessModel(String title, String email, String phone, String description, String other, String url) {
        Title = title;
        Email = email;
        Phone = phone;
        Description = description;
        Other = other;
        Url = url;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        Other = other;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
