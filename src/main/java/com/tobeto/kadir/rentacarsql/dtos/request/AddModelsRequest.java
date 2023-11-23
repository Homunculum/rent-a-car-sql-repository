package com.tobeto.kadir.rentacarsql.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelsRequest {
    private int modelYear;
    private String modelName;
    private int brands;
}
