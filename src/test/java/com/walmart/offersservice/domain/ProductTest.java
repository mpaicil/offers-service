package com.walmart.offersservice.domain;

import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;
import org.junit.jupiter.api.Test;

import static com.walmart.offersservice.utils.ProductDataFixture.aProductData;
import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void createsProductFromProductData() {
        ProductData productData = aProductData().build();

        Product actualProduct = Product.createBy(productData);

        assertThat(actualProduct).isNotNull()
                .satisfies(product -> assertThat(product.getId()).isEqualTo(product.getId()))
                .satisfies(product -> assertThat(product.getBrand()).isEqualTo(productData.getBrand()))
                .satisfies(product -> assertThat(product.getDescription())
                        .satisfies(description -> assertThat(description.getText()).isEqualTo(productData.getDescription()))
                        .satisfies(description -> assertThat(description.getVocalsRepeated()).isEqualTo(2)))
                .satisfies(product -> assertThat(product.getPrices())
                        .satisfies(prices -> assertThat(prices.getOriginal()).isEqualTo(productData.getPrice()))
                        .satisfies(prices -> assertThat(prices.getAppliedDiscount()).isEqualTo(20))
                );
    }
}