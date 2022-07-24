package com.journaldev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journaldev.spring.dao.UserRepository;
import com.journaldev.spring.entity.User2;

@Service
public class UserServiceImpl2 implements UserService2 {

    @Autowired
    private UserRepository repository;

    @Override
    public User2 create(User2 user2) {
        return repository.save(user2);
    }

    @Override
    public User2 delete(int id) {
        User2 user2 = findById(id);
        if(user2 != null){
            repository.delete(user2);
        }
        return user2;
    }

    @Override
    public List<User2> findAll() {
        return repository.findAll();
    }

    @Override
    public User2 findById(int id) {
        return repository.findById(id);
    	//return null;
    }

    @Override
    public User2 update(User2 user2) {
        return repository.save(user2);
    }
}