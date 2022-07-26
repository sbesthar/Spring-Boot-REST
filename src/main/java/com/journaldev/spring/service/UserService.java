package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.entity.User;
import com.journaldev.spring.entity.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
}