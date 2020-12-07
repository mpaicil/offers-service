package com.walmart.offersservice.presentation.endpoints.utils;

import com.walmart.offersservice.presentation.endpoints.responses.PriceResponse;
import com.walmart.offersservice.presentation.endpoints.responses.ProductResponse;

import static com.walmart.offersservice.presentation.endpoints.utils.PriceResponseFixture.aPriceResponse;

public final class ProductResponseFixture {

    private Integer id;
    private String brand;
    private String description;
    private PriceResponse prices;

    private ProductResponseFixture() {
        id = 150;
        brand = "Marca Acme";
        description = "luces crypto 80W";
        prices = aPriceResponse().build();
    }

    public static ProductResponseFixture aProductResponse() {
        return new ProductResponseFixture();
    }

    public ProductResponseFixture withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductResponseFixture withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductResponseFixture withPrices(PriceResponse prices) {
        this.prices = prices;
        return this;
    }

    public ProductResponse build() {
        return new ProductResponse(id, brand, description, prices);
    }
}
