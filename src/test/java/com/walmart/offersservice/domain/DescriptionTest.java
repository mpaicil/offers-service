package com.walmart.offersservice.domain;

import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;
import org.junit.jupiter.api.Test;

import static com.walmart.offersservice.domain.Description.createDescriptionBy;
import static com.walmart.offersservice.utils.ProductDataFixture.aProductData;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DescriptionTest {

    @Test
    void createsDescriptionWithTwoCharactersRepeated() {
        ProductData productData = aProductData().build();

        Description description = createDescriptionBy(productData);

        assertThat(description).isNotNull()
                .hasFieldOrPropertyWithValue("text",productData.getDescription())
                .hasFieldOrPropertyWithValue("vocalsRepeated", 2);
    }

    @Test
    void createDescriptionWithFourCharactersRepeated() {
        String expectedDescription = "horAción con horAción";

        ProductData productData = aProductData()
                .withDescription(expectedDescription)
                .build();

        Description description = createDescriptionBy(productData);

        assertThat(description).isNotNull()
                .hasFieldOrPropertyWithValue("text",expectedDescription)
                .hasFieldOrPropertyWithValue("vocalsRepeated", 4);
    }
}