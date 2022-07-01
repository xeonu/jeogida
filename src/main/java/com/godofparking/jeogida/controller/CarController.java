package com.godofparking.jeogida.controller;

import com.godofparking.jeogida.domain.Car;
import com.godofparking.jeogida.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private CarMapper mapper;

    @Autowired
    public CarController(CarMapper mapper){
        super();
        this.mapper = mapper;
    }

    @PostMapping("")
    public Car post(@RequestBody Car car){
        mapper.insert(car);
        return car;
    }

    @GetMapping("")
    public List<Car> get(){
        return mapper.getAll();
    }


    @GetMapping("/{id}")
    public Car get(@PathVariable("id") int id){
        return mapper.getById(id);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return mapper.deleteCar(id);
    }

}
