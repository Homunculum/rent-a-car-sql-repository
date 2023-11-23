package com.tobeto.kadir.rentacarsql.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalsRequest {
    private int id;
    private Date rentalDate;
    private Date returnDate;
}
