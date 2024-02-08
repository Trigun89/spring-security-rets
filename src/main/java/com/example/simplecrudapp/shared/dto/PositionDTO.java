package com.example.simplecrudapp.shared.dto;

public class PositionDTO {
    private long id;

    private String positionId;
    private UserDTO userDetails;
    private String title;
    private String companyName;
    private String city;
    private String keyResponsibilities;



    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDTO userDetails) {
        this.userDetails = userDetails;
    }

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
