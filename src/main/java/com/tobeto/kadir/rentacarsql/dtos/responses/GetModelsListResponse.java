package com.tobeto.kadir.rentacarsql.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelsListResponse {
    private int modelYear;
    private String modelName;
}
