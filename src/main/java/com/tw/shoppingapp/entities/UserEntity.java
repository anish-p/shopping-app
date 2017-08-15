package com.tw.shoppingapp.entities;

import java.util.Date;

public abstract class UserEntity extends Entity {

    public abstract String getName();

    public abstract String getEmailId();

    public abstract String getUsername();

    public abstract String getPassword();

    public abstract String getAddress();

    public abstract String getMobileNumber();

    public abstract String getType();

    public abstract String getGender();

    public abstract Date getDateOfBirth();

    public abstract String getPanNumber();

    public abstract Integer getExpInYears();

    public abstract Integer getExpInMonths();

    public interface Builder {

        Builder name(String name);

        Builder emailId(String emailId);

        Builder username(String username);

        Builder password(String password);

        Builder address(String address);

        Builder mobileNumber(String mobileNumber);

        Builder type(String type);

        Builder gender(String gender);

        Builder dateOfBirth(Date dateOfBirth);

        Builder panNumber(String panNumber);

        Builder expInYears(Integer expInYears);

        Builder expInMonths(Integer expInMonths);

        UserEntity build();
    }
}