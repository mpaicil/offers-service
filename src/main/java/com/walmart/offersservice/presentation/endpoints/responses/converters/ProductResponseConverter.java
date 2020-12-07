package com.walmart.offersservice.presentation.endpoints.responses.converters;

import com.walmart.offersservice.domain.Product;
import com.walmart.offersservice.presentation.endpoints.responses.ProductResponse;

public class ProductResponseConverter {

    private Product product;

    private ProductResponseConverter(Product product) {
        this.product = product;
    }

    public static ProductResponseConverter with(Product product) {
        return new ProductResponseConverter(product);
    }

    public ProductResponse toResponse() {
        return new ProductResponse(product.getId(),
                product.getBrand(),
                product.getDescription().getText(),
                PriceResponseConverter.with(product.getPrices()).toResponse());
    }
}
