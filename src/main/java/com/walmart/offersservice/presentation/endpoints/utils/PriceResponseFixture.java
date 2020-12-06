package com.walmart.offersservice.presentation.endpoints.utils;

import com.walmart.offersservice.presentation.endpoints.responses.PriceResponse;

public final class PriceResponseFixture {
    private Integer total;
    private Integer discount;
    private Integer total_final;

    private PriceResponseFixture() {
        total = 20000;
        discount = 30;
        total_final = 14000;
    }

    public static PriceResponseFixture aPriceResponse() {
        return new PriceResponseFixture();
    }

    public PriceResponseFixture withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public PriceResponseFixture withDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public PriceResponseFixture withTotal_final(Integer total_final) {
        this.total_final = total_final;
        return this;
    }

    public PriceResponse build() {
        return new PriceResponse(total, discount, total_final);
    }
}
