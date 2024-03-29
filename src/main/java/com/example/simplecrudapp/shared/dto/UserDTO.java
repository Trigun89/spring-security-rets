package com.example.simplecrudapp.shared.dto;

import javax.swing.text.Position;
import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 2434853030L;
    private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private int cohort;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;

    private List<PositionDTO> previousPositions;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public int getCohort() {
        return cohort;
    }

    public void setCohort(int cohort) {
        this.cohort = cohort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public boolean isEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public List<PositionDTO> getPreviousPositions() {
        return previousPositions;
    }

    public void setPreviousPositions(List<PositionDTO> previousPositions) {
        this.previousPositions = previousPositions;
    }
}
