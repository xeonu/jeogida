package com.godofparking.jeogida.controller;

import com.godofparking.jeogida.domain.Location;
import com.godofparking.jeogida.domain.User;
import com.godofparking.jeogida.mapper.LocationMapper;
import com.godofparking.jeogida.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private LocationMapper mapper;

    @Autowired
    public LocationController(LocationMapper mapper){
        super();
        this.mapper = mapper;
    }

    @PostMapping("")
    public Location post(@RequestBody Location location){
        mapper.insert(location);
        return location;
    }

    @GetMapping("")
    public List<Location> get(){
        return mapper.getAll();
    }


    @GetMapping("/{id}")
    public Location get(@PathVariable("id") int id){
        return mapper.getById(id);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return mapper.deleteLocation(id);
    }
}