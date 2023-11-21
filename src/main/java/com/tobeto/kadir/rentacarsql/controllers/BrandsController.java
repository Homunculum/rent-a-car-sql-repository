package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.entities.Brands;
import com.tobeto.kadir.rentacarsql.repositories.BrandsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandsRepository brandsRepository;

    public BrandsController(BrandsRepository brandRepository) {

        this.brandsRepository = brandRepository;
    }


    @GetMapping
    public List<Brands> getAll() {

        return brandsRepository.findAll();
    }

    @GetMapping("{id}")
    public Brands getById(@PathVariable int id) {

        return brandsRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brands brands) {
        brandsRepository.save(brands);
    }

    @PutMapping
    public void update(@RequestBody Brands brands) {
        brandsRepository.findById(brands.getId()).orElseThrow();
        brandsRepository.save(brands);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Brands brandsDelete = brandsRepository.findById(id).orElseThrow();
        brandsRepository.delete(brandsDelete);
    }
}
