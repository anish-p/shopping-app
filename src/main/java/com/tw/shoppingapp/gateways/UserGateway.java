package com.tw.shoppingapp.gateways.user;

import com.tw.shoppingapp.entities.UserEntity;
import com.tw.shoppingapp.gateways.user.inmemory.User;

public interface UserGateway {

    public UserEntity save(UserEntity user);
}
