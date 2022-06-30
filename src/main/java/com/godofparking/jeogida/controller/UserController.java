package com.godofparking.jeogida.controller;

import com.godofparking.jeogida.domain.User;
import com.godofparking.jeogida.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    private UserMapper mapper;

    public UserController(UserMapper mapper){
        this.mapper = mapper;
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return mapper.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return mapper.getUser(id);
    }

    @PutMapping("/user")
    public User createUser(@PathVariable("id") Integer id, @PathVariable("email") String email, @PathVariable("nickname") String nickname, @PathVariable("password") String password, @PathVariable("createdAt") Date createdAt, @PathVariable("updatedAt")Date updatedAt){
        return mapper.createUser(id, email, nickname, password, createdAt, updatedAt);
    }

    @PostMapping("/user/id")
    public User updateUser(@PathVariable("name") String name, @PathVariable("id") Integer id){
        return mapper.updateUser(name, id);
    }

    @DeleteMapping("/user/id")
    public User deleteUser(@PathVariable("id") Integer id){
        return mapper.deleteUser(id);
    }
}