package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.dtos.request.AddUsersRequest;
import com.tobeto.kadir.rentacarsql.dtos.request.UpdateUsersRequest;
import com.tobeto.kadir.rentacarsql.dtos.responses.GetUsersListResponse;
import com.tobeto.kadir.rentacarsql.dtos.responses.GetUsersResponse;
import com.tobeto.kadir.rentacarsql.entities.Brands;
import com.tobeto.kadir.rentacarsql.entities.Users;
import com.tobeto.kadir.rentacarsql.repositories.BrandsRepository;
import com.tobeto.kadir.rentacarsql.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UsersController {
    private final UsersRepository usersRepository;

    @GetMapping
    public List<GetUsersListResponse> getAll() {
        List<Users> usersList= usersRepository.findAll();
        List<GetUsersListResponse> getUsersListResponses = new ArrayList<>();
        for (Users users : usersList) {
            GetUsersListResponse usersListResponse = new GetUsersListResponse();
            usersListResponse.setFirstName(users.getFirstName());
            usersListResponse.setLastName(users.getLastName());
            usersListResponse.setAge(users.getAge());
            usersListResponse.setPhone(users.getPhone());
            usersListResponse.setEmail(users.getEmail());
            usersListResponse.setAddress(users.getAddress());
            getUsersListResponses.add(usersListResponse);

        }
        return getUsersListResponses;
    }

    @GetMapping("{id}")
    public Users getById(@PathVariable int id) {
        Users users = usersRepository.findById(id).orElseThrow();
        GetUsersResponse getUsersResponse = new GetUsersResponse();
        getUsersResponse.setFirstName(users.getFirstName());
        getUsersResponse.setLastName(users.getLastName());
        getUsersResponse.setAge(users.getAge());
        getUsersResponse.setPhone(users.getPhone());
        getUsersResponse.setEmail(users.getEmail());
        getUsersResponse.setAddress(users.getAddress());

        return  usersRepository.save(users);
    }

    @PostMapping
    public void add(@RequestBody AddUsersRequest addUsersRequest) {
      Users users = new Users();
      users.setFirstName(addUsersRequest.getFirstName());
      users.setLastName(addUsersRequest.getLastName());
      users.setAge(addUsersRequest.getAge());
      users.setPhone(users.getPhone());
      users.setEmail(addUsersRequest.getEmail());
      users.setAddress(addUsersRequest.getAddress());
    }

    @PutMapping
    public void update(@PathVariable int id, UpdateUsersRequest updateUsersRequest) {
        Users users = usersRepository.findById(id).orElseThrow();
        users.setFirstName(updateUsersRequest.getFirstName());
        users.setLastName(updateUsersRequest.getLastName());
        users.setAge(updateUsersRequest.getAge());
        users.setPhone(updateUsersRequest.getPhone());
        users.setEmail(updateUsersRequest.getEmail());
        users.setAddress(updateUsersRequest.getAddress());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Users usersDelete = usersRepository.findById(id).orElseThrow();
        usersRepository.delete(usersDelete);
    }
}
