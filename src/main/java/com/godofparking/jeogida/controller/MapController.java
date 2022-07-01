package com.godofparking.jeogida.controller;

import com.godofparking.jeogida.domain.Map;
import com.godofparking.jeogida.mapper.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
public class MapController {
    private MapMapper mapper;

    @Autowired
    public MapController(MapMapper mapper){
        super();
        this.mapper = mapper;
    }

    @PostMapping("")
    public Map post(@RequestBody Map map){
        mapper.insert(map);
        return map;
    }

    @GetMapping("")
    public List<Map> get(){
        return mapper.getAll();
    }


    @GetMapping("/{id}")
    public Map get(@PathVariable("id") int id){
        return mapper.getById(id);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return mapper.deleteMap(id);
    }

}
