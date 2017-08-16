package com.tw.shoppingapp.gateways.user.inmemory;

import com.tw.shoppingapp.entities.UserEntity;
import org.junit.Test;

import javax.validation.ConstraintViolationException;

public class UserTest {

    private UserEntity userEntity;

    @Test(expected = ConstraintViolationException.class)
    public void givenMandatoryFieldsNull_whenBuilt_thenThrowException() {
        this.userEntity = new User.Builder()
                .name(null)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidType_whenBuilt_thenThrowException() {
        this.userEntity = new User.Builder()
                .name("Test-name")
                .type("Buyers")
                .build();
    }
}