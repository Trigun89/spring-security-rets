package com.example.simplecrudapp.ui.model.request;

public class PositionRequestModel {

    private String title;
    private String companyName;
    private String city;
    private String keyResponsibilities;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getKeyResponsibilities() {
        return keyResponsibilities;
    }

    public void setKeyResponsibilities(String keyResponsibilities) {
        this.keyResponsibilities = keyResponsibilities;
    }
}
