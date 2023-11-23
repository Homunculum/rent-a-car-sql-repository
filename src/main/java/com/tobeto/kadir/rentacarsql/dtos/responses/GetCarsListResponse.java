package com.tobeto.kadir.rentacarsql.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarsListResponse {
    private String carType;
    private int dailyPrice;

}
