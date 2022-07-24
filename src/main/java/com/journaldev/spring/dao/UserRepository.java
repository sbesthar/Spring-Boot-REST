package com.journaldev.spring.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.journaldev.spring.entity.User2;

public interface UserRepository extends Repository<User2, Integer> {

    void delete(User2 user2);

    List<User2> findAll();

    User2 findById(int id);

    User2 save(User2 user2);
}