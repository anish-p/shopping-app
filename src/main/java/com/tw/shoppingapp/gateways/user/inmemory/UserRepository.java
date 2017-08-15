package com.tw.shoppingapp.gateways.user.inmemory;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
