package com.tobeto.kadir.rentacarsql.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUsersRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String address;
}
