package com.tw.shoppingapp.gateways.user.inmemory;

import com.tw.shoppingapp.entities.UserEntity;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User extends UserEntity implements Serializable {

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

    public User() {
    }

    public User(String name, String emailId, String username, String password, String address, String mobileNumber,
                String type, String gender, Date dateOfBirth, String panNumber, Integer expInYears, Integer expInMonths) {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getPanNumber() {
        return this.panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    @Override
    public Integer getExpInYears() {
        return this.expInYears;
    }

    public void setExpInYears(Integer expInYears) {
        this.expInYears = expInYears;
    }

    @Override
    public Integer getExpInMonths() {
        return this.expInMonths;
    }

    public void setExpInMonths(Integer expInMonths) {
        this.expInMonths = expInMonths;
    }

    public static class Builder implements UserEntity.Builder {

        private String name;
        private String emailId;
        private String username;
        private String password;
        private String address;
        private String mobileNumber;
        private String type;
        private String gender;
        private Date dateOfBirth;
        private String panNumber;
        private Integer expInYears;
        private Integer expInMonths;

        @Override
        public UserEntity.Builder name(String name) {
            if (null == name || name.trim().length() == 0) {
                throw new ConstraintViolationException("Field should not be null or empty", null);
            }
            this.name = name;
            return this;
        }

        @Override
        public UserEntity.Builder emailId(String emailId) {
            if (null == emailId || emailId.trim().length() == 0) {
                throw new ConstraintViolationException("Field should not be null or empty", null);
            }
            this.emailId = emailId;
            return this;
        }

        @Override
        public UserEntity.Builder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public UserEntity.Builder password(String password) {
            this.password = password;
            return this;
        }

        @Override
        public UserEntity.Builder address(String address) {
            this.address = address;
            return this;
        }

        @Override
        public UserEntity.Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        @Override
        public UserEntity.Builder type(String type) {
            if (null == type || type.trim().length() == 0) {
                throw new ConstraintViolationException("Field should not be null or empty", null);
            }

            switch (type.toLowerCase()) {
                case BUYER:
                case SELLER:
                    break;
                default:
                    throw new IllegalArgumentException("Not a valid type of a user.User type should either be buyer or seller");
            }

            this.type = type;
            return this;
        }

        @Override
        public UserEntity.Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        @Override
        public UserEntity.Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        @Override
        public UserEntity.Builder panNumber(String panNumber) {
            this.panNumber = panNumber;
            return this;
        }

        @Override
        public UserEntity.Builder expInYears(Integer expInYears) {
            this.expInYears = expInYears;
            return this;
        }

        @Override
        public UserEntity.Builder expInMonths(Integer expInMonths) {
            this.expInMonths = expInMonths;
            return this;
        }

        @Override
        public UserEntity build() {
            return new User(name, emailId, username, password, address, mobileNumber, type, gender, dateOfBirth,
                    panNumber, expInYears, expInMonths);
        }
    }
}
