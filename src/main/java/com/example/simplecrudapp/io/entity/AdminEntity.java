package com.example.simplecrudapp.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="admins")
public class AdminEntity implements Serializable {
    private static final long serialVersionUID = 2434853030L;
    @Id
    @GeneratedValue
    private long adminId;

    @Column
    private String login;

    @Column
    private String password;

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(short adminId) {
        this.adminId = adminId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
