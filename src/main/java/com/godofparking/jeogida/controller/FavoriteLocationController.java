package com.godofparking.jeogida.controller;

import com.godofparking.jeogida.domain.FavoriteLocation;
import com.godofparking.jeogida.mapper.FavoriteLocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritelocation")
public class FavoriteLocationController {
    private FavoriteLocationMapper mapper;

    @Autowired
    public FavoriteLocationController(FavoriteLocationMapper mapper){
        super();
        this.mapper = mapper;
    }

    @PostMapping("")
    public FavoriteLocation post(@RequestBody FavoriteLocation favoriteLocation){
        mapper.insert(favoriteLocation);
        return favoriteLocation;
    }

    @GetMapping("")
    public List<FavoriteLocation> get(){
        return mapper.getAll();
    }


    @GetMapping("/{id}")
    public FavoriteLocation get(@PathVariable("id") int id){
        return mapper.getById(id);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return mapper.deleteFavoriteLocation(id);
    }
}
