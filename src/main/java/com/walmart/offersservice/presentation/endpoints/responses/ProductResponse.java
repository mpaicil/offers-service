package com.walmart.offersservice.presentation.endpoints.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductResponse {

    private Integer id;
    private String brand;
    private String description;
    private PriceResponse prices;

}
