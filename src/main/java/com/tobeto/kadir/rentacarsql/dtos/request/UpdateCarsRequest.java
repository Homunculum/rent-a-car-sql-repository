package com.tobeto.kadir.rentacarsql.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarsRequest {
    private int id;
    private String carType;
    private int dailyPrice;
}
