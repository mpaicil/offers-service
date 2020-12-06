package com.walmart.offersservice.domain;

import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;
import lombok.Getter;

import static com.walmart.offersservice.domain.Description.createDescriptionBy;
import static com.walmart.offersservice.domain.Prices.createPricesBy;

@Getter
public class Product {

    private Integer id;
    private String brand;
    private Description description;
    private Prices prices;

    public Product(Integer id, String brand, Description description, Prices prices) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.prices = prices;
    }

    public static Product createBy(ProductData data) {
        Description description = createDescriptionBy(data);

        return new Product(data.getId(),
                data.getBrand(),
                description,
                createPricesBy(data.getPrice(), description.getVocalsRepeated() * 10));
    }
}
