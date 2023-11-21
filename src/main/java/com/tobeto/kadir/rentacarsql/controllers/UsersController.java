package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.entities.Brands;
import com.tobeto.kadir.rentacarsql.entities.Users;
import com.tobeto.kadir.rentacarsql.repositories.BrandsRepository;
import com.tobeto.kadir.rentacarsql.repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {

        this.usersRepository = usersRepository;
    }


    @GetMapping
    public List<Users> getAll() {

        return usersRepository.findAll();
    }

    @GetMapping("{id}")
    public Users getById(@PathVariable int id) {

        return usersRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Users users) {
        usersRepository.save(users);
    }

    @PutMapping
    public void update(@RequestBody Users users) {
        usersRepository.findById(users.getId()).orElseThrow();
        usersRepository.save(users);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Users usersDelete = usersRepository.findById(id).orElseThrow();
        usersRepository.delete(usersDelete);
    }
}
