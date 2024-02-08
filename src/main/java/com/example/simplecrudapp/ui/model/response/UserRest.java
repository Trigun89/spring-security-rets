package com.example.simplecrudapp.ui.model.response;

import java.util.List;

public class UserRest {
    private String userId;
    private String firstName;
    private String lastName;
    private List<PositionRest> previousPositions;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public List<PositionRest> getPreviousPositions() {
        return previousPositions;
    }

    public void setPreviousPositions(List<PositionRest> previousPositions) {
        this.previousPositions = previousPositions;
    }
}
