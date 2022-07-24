package com.journaldev.spring.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.entity.User;
import com.journaldev.spring.entity.User2;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    //User2 findByFirstName(String name);
    
    User findByUsername(String username);

}