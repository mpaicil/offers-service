package com.walmart.offersservice.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PricesTest {

    @Test
    void createsPricesFromAmountAndDiscount() {
        Prices prices = Prices.createPricesBy(20000, 30);

        assertThat(prices).isNotNull()
                .hasFieldOrPropertyWithValue("original",20000)
                .hasFieldOrPropertyWithValue("discounted", 14000)
                .hasFieldOrPropertyWithValue("appliedDiscount",30);
    }

    @Test
    void createsPricesWithTheLimitOfDiscount() {
        Prices prices = Prices.createPricesBy(20000, 60);

        assertThat(prices).isNotNull()
                .hasFieldOrPropertyWithValue("original",20000)
                .hasFieldOrPropertyWithValue("discounted", 10000)
                .hasFieldOrPropertyWithValue("appliedDiscount",50);
    }
}