package com.godofparking.jeogida.controller;

import com.godofparking.jeogida.domain.Car;
import com.godofparking.jeogida.domain.ParkingLot;
import com.godofparking.jeogida.mapper.CarMapper;
import com.godofparking.jeogida.mapper.ParkingLotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkinglot")
public class ParkingLotController {
    private ParkingLotMapper mapper;

    @Autowired
    public ParkingLotController(ParkingLotMapper mapper){
        super();
        this.mapper = mapper;
    }

    @PostMapping("")
    public ParkingLot post(@RequestBody ParkingLot parkingLot){
        mapper.insert(parkingLot);
        return parkingLot;
    }

    @GetMapping("")
    public List<ParkingLot> get(){
        return mapper.getAll();
    }


    @GetMapping("/{id}")
    public ParkingLot get(@PathVariable("id") int id){
        return mapper.getById(id);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return mapper.deleteParkingLot(id);
    }
}
