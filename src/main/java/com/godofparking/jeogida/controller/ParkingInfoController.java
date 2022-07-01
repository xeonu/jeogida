package com.godofparking.jeogida.controller;

import com.godofparking.jeogida.domain.ParkingInfo;
import com.godofparking.jeogida.mapper.ParkingInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkinginfo")
public class ParkingInfoController {
    private ParkingInfoMapper mapper;

    @Autowired
    public ParkingInfoController(ParkingInfoMapper mapper){
        super();
        this.mapper = mapper;
    }

    @PostMapping("")
    public ParkingInfo post(@RequestBody ParkingInfo parkingInfo){
        mapper.insert(parkingInfo);
        return parkingInfo;
    }

    @GetMapping("")
    public List<ParkingInfo> get(){
        return mapper.getAll();
    }


    @GetMapping("/{id}")
    public ParkingInfo get(@PathVariable("id") int id){
        return mapper.getById(id);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return mapper.deleteParkingInfo(id);
    }
}
