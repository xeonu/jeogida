package com.godofparking.jeogida.controller;

import com.godofparking.jeogida.domain.User;
import com.godofparking.jeogida.exception.NotFoundException;
import com.godofparking.jeogida.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllusers(){
        return service.findAll();
    }


    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user =  service.findOne(id);

        if(user == null){
            throw new NotFoundException(String.format("ID[%s] not found", id));
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if(user == null){
            throw new NotFoundException(String.format("ID[%s] not found", id));
        }
    }

}