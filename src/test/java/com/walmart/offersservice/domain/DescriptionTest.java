package com.walmart.offersservice.domain;

import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;
import org.junit.jupiter.api.Test;

import static com.walmart.offersservice.utils.ProductDataFixture.aProductData;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DescriptionTest {

    @Test
    void createsDescriptionWithTwoCharactersRepeated() {
        ProductData productData = aProductData().build();

        Description description = Description.createBy(productData);

        assertThat(description).isNotNull()
                .hasFieldOrPropertyWithValue("text",productData.getDescription())
                .hasFieldOrPropertyWithValue("vocalsRepeated", 2);
    }
}