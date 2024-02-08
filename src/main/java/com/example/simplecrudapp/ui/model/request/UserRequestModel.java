package com.example.simplecrudapp.ui.model.request;

import java.util.List;

public class UserRequestModel {
    private String firstName;
    private String lastName;
   // private String title;
    private int cohortNumber; // TODO: debug, it doesn't take input value, assign default 0 instead
    //private Date joinDate;

    private List<PositionRequestModel> previousPositions;

    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

    public int getCohortNumber() {
        return cohortNumber;
    }

    public void setCohortNumber(int cohortNumber) {
        this.cohortNumber = cohortNumber;
    }

    public List<PositionRequestModel> getPreviousPositions() {
        return previousPositions;
    }

    public void setPreviousPositions(List<PositionRequestModel> previousPositions) {
        this.previousPositions = previousPositions;
    }
}
