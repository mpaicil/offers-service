package com.walmart.offersservice.presentation.endpoints.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse {

    private List<ProductResponse> products;

}
