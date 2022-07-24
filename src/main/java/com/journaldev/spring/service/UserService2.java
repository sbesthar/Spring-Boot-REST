package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.entity.User2;

public interface UserService2 {
	User2 create(User2 user2);

    User2 delete(int id);

    List<User2> findAll();

    User2 findById(int id);

    User2 update(User2 user2);
}
