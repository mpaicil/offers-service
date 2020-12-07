package com.walmart.offersservice.presentation.endpoints.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceResponse {

    private Integer original;
    private Integer discounted;
    private Integer appliedDiscount;

}
