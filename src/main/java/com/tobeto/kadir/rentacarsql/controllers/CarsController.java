package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.entities.Cars;
import com.tobeto.kadir.rentacarsql.repositories.CarsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarsRepository carsRepository;
    public CarsController(CarsRepository carsRepository, CarsRepository carsRepository1){

        this.carsRepository = carsRepository1;
    }
    @GetMapping
    public List<Cars> getAll(){
       return carsRepository.findAll();
    }
    @GetMapping("{id}")
    public Cars getById(@PathVariable int id) {

        return carsRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Cars cars) {
        carsRepository.save(cars);
    }

    @PutMapping
    public void update(@RequestBody Cars cars) {
        carsRepository.findById(cars.getId()).orElseThrow();
        carsRepository.save(cars);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Cars carsDelete = carsRepository.findById(id).orElseThrow();
        carsRepository.delete(carsDelete);
    }
}
