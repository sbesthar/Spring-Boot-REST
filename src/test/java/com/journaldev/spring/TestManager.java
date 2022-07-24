package com.journaldev.spring;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.journaldev.spring.dao.UserDao2;
import com.journaldev.spring.entity.User2;
import com.journaldev.spring.service.UserServiceImpl2;
 
public class TestManager {
     
    @InjectMocks
    UserServiceImpl2 manager;
     
    @Mock
    UserDao2 dao;
 
    @Before(value = "")
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void getAllEmployeesTest()
    {
        User2 user2 = new User2(1, "sivaaa", "raj", "test@mail.com");

         
        //when(dao.findById(1)).thenReturn(user2);

        verify(dao, times(0)).findById(1);
    }
     
}