package com.godofparking.jeogida.controller;

import com.godofparking.jeogida.domain.User;
import com.godofparking.jeogida.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserMapper mapper;

    @Autowired
    public UserController(UserMapper mapper){
        super();
        this.mapper = mapper;
    }

    @PostMapping("")
    public User post(@RequestBody User user){
        mapper.insert(user);
        return user;
    }


    @GetMapping("")
    public List<User> get(){
        return mapper.getAll();
    }


    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id){
        return mapper.getById(id);
    }



}