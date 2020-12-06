package com.walmart.offersservice.presentation.endpoints.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceResponse {

    private Integer total;
    private Integer discount;
    private Integer total_final;

}
