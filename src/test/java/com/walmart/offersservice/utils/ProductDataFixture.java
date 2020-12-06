package com.walmart.offersservice.utils;

import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;

public final class ProductDataFixture {

    private Integer id;
    private String brand;
    private String description;
    private String image;
    private Integer price;

    private ProductDataFixture() {
        id = 40;
        brand = "Marca12";
        description = "Freezer Horizontal 99L";
        image = "no_photo";
        price = 120000;
    }

    public static ProductDataFixture aProductData() {
        return new ProductDataFixture();
    }

    public ProductDataFixture withId(Integer id) {
        this.id = id;
        return this;
    }

    public ProductDataFixture withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductDataFixture withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductDataFixture withImage(String image) {
        this.image = image;
        return this;
    }

    public ProductDataFixture withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public ProductData build() {
        return new ProductData(id, brand, description, image, price);
    }
}
