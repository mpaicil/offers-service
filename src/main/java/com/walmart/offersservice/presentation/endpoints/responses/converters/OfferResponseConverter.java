package com.walmart.offersservice.presentation.endpoints.responses.converters;

import com.walmart.offersservice.domain.Product;
import com.walmart.offersservice.presentation.endpoints.responses.OfferResponse;

import java.util.List;
import java.util.stream.Collectors;

public class OfferResponseConverter {

    private List<Product> products;

    private OfferResponseConverter(List<Product> products) {
        this.products = products;
    }

    public static OfferResponseConverter with(List<Product> products) {
        return new OfferResponseConverter(products);
    }

    public OfferResponse toResponse() {
        return new OfferResponse(products.stream()
                .map(product -> ProductResponseConverter.with(product).toResponse())
                .collect(Collectors.toList())
        );
    }

}
