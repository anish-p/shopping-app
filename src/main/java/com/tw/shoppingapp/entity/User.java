package com.tw.shoppingapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String emailId;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String address;

    @NotNull
    private String mobileNumber;

    @NotNull
    private String type;

    private String gender;
    private Date dateOfBirth;
    private String panNumber;
    private Integer expInYears;
    private Integer expInMonths;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public Integer getExpInYears() {
        return expInYears;
    }

    public Integer getExpInMonths() {
        return expInMonths;
    }

    public User() {
    }

    public User(String name, String emailId, String username, String password, String address, String mobileNumber, String type, String gender, Date dateOfBirth, String panNumber, Integer expInYears, Integer expInMonths) {
        this.name = name;
        this.emailId = emailId;
        this.username = username;
        this.password = password;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.type = type;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.panNumber = panNumber;
        this.expInYears = expInYears;
        this.expInMonths = expInMonths;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", panNumber='" + panNumber + '\'' +
                ", expInYears=" + expInYears +
                ", expInMonths=" + expInMonths +
                '}';
    }
}
