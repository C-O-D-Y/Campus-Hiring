package com.campushiring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campushiring.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
