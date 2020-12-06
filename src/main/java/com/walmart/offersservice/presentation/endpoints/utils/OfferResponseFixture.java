package com.walmart.offersservice.presentation.endpoints.utils;

import com.walmart.offersservice.presentation.endpoints.responses.OfferResponse;
import com.walmart.offersservice.presentation.endpoints.responses.ProductResponse;

import java.util.List;

import static com.walmart.offersservice.presentation.endpoints.utils.ProductResponseFixture.aProductResponse;
import static java.util.Collections.singletonList;

public final class OfferResponseFixture {

    private List<ProductResponse> products;

    private OfferResponseFixture() {
        products = singletonList(aProductResponse().build());
    }

    public static OfferResponseFixture anOfferResponse() {
        return new OfferResponseFixture();
    }

    public OfferResponseFixture withProducts(List<ProductResponse> products) {
        this.products = products;
        return this;
    }

    public OfferResponse build() {
        return new OfferResponse(products);
    }
}
