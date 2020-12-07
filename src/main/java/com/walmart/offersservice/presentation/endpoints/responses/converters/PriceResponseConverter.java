package com.walmart.offersservice.presentation.endpoints.responses.converters;

import com.walmart.offersservice.domain.Prices;
import com.walmart.offersservice.presentation.endpoints.responses.PriceResponse;

public class PriceResponseConverter {

    private Prices prices;

    private PriceResponseConverter(Prices prices) {
        this.prices = prices;
    }

    public static PriceResponseConverter with(Prices prices) {
        return new PriceResponseConverter(prices);
    }

    public PriceResponse toResponse() {
        return new PriceResponse(prices.getOriginal(), prices.getDiscounted(), prices.getAppliedDiscount());
    }

}
