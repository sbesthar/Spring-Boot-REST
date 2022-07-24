package com.journaldev.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.spring.dao.UserDao2;
import com.journaldev.spring.entity.User2;
import com.journaldev.spring.service.UserService2;

//@CrossOrigin(value = "http://localhost:4200")
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService2 userService;

    @Autowired
    UserDao2 userdao;
    
    @PostMapping
    public User2 create(@RequestBody User2 user){
        return userService.create(user);
    }

    @GetMapping(path = {"/{id}"})
    public User2 findOne(@PathVariable("id") int id){
    	System.out.println(">>>>>>> "+userdao.findAllActiveUsers().size());
    	
        return userService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public User2 update(@PathVariable("id") int id, @RequestBody User2 user){
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public User2 delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping
    public List findAll(){
        return userService.findAll();
    }
}