package com.example.simplecrudapp.io.entity;

import com.example.simplecrudapp.shared.dto.UserDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="previousPositions")
public class PositionEntity implements Serializable {

    private static final long serialVersionUID = 5333846309231993410L;

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 30, nullable = false)
    private String positionId;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 30, nullable = false)
    private String companyName;

    @Column(length = 30, nullable = false)
    private String city;

    @Column(length = 300, nullable = false)
    private String keyResponsibilities;


    @ManyToOne
    @JoinColumn(name="users_id")
    private UserEntity userDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
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

    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }
}
