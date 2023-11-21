package com.tobeto.kadir.rentacarsql.controllers;


import com.tobeto.kadir.rentacarsql.entities.Models;
import com.tobeto.kadir.rentacarsql.repositories.ModelsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelsController {
    private final ModelsRepository modelsRepository;

    public ModelsController(ModelsRepository modelsRepository) {

        this.modelsRepository = modelsRepository;
    }


    @GetMapping
    public List<Models> getAll() {

        return modelsRepository.findAll();
    }

    @GetMapping("{id}")
    public Models getById(@PathVariable int id) {

        return modelsRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Models models) {
        modelsRepository.save(models);
    }

    @PutMapping
    public void update(@RequestBody Models models) {
        modelsRepository.findById(models.getId()).orElseThrow();
        modelsRepository.save(models);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Models modelsDelete = modelsRepository.findById(id).orElseThrow();
        modelsRepository.delete(modelsDelete);
    }
}
