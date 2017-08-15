package com.tw.shoppingapp.gateways.user.inmemory;

import com.tw.shoppingapp.entities.UserEntity;
import com.tw.shoppingapp.gateways.user.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class InMemoryUserGateway implements UserGateway {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity user) {
        return this.userRepository.save((User) user);
    }
}
