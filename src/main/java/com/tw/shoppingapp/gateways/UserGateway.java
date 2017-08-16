package com.tw.shoppingapp.gateways;

import com.tw.shoppingapp.entities.UserEntity;

public interface UserGateway {

    public UserEntity save(UserEntity user);
}
