package com.walmart.offersservice.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PricesTest {

    @Test
    void createsPricesFromAmountAndDiscount() {
        Prices prices = Prices.createBy(20000, 30);

        assertThat(prices).isNotNull()
                .hasFieldOrPropertyWithValue("original",20000)
                .hasFieldOrPropertyWithValue("discounted", 14000)
                .hasFieldOrPropertyWithValue("appliedDiscount",30);
    }
}