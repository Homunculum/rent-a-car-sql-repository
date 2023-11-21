package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.entities.Rentals;
import com.tobeto.kadir.rentacarsql.repositories.RentalsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {
    private final RentalsRepository rentalsRepository;

    public RentalsController(RentalsRepository rentalsRepository) {

        this.rentalsRepository = rentalsRepository;
    }


    @GetMapping
    public List<Rentals> getAll() {

        return rentalsRepository.findAll();
    }

    @GetMapping("{id}")
    public Rentals getById(@PathVariable int id) {

        return rentalsRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rentals rentals) {
        rentalsRepository.save(rentals);
    }

    @PutMapping
    public void update(@RequestBody Rentals rentals) {
        rentalsRepository.findById(rentals.getId()).orElseThrow();
        rentalsRepository.save(rentals);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Rentals rentalsDelete = rentalsRepository.findById(id).orElseThrow();
        rentalsRepository.delete(rentalsDelete);
    }
}
