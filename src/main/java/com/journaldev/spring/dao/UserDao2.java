package com.journaldev.spring.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.entity.User;
import com.journaldev.spring.entity.User2;

@Repository
public interface UserDao2 extends CrudRepository<User2, Integer> {

	 User2 findById(int id);

	    
	    @Query("SELECT u FROM User2 u WHERE u.firstName = 'siva'")
	    Collection<User2> findAllActiveUsers();
    
    //User findByUsername(String username);
}