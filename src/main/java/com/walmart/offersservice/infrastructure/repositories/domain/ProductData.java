package com.walmart.offersservice.infrastructure.repositories.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "products")
public class ProductData {

    @Field("id")
    private Integer id;

    private String brand;

    private String description;

    private String image;

    private Integer price;

}
