package com.walmart.offersservice.presentation.endpoints.responses.converters;

import com.walmart.offersservice.domain.Product;
import com.walmart.offersservice.presentation.endpoints.responses.PriceResponse;
import org.junit.jupiter.api.Test;

import static com.walmart.offersservice.domain.Product.createProductBy;
import static com.walmart.offersservice.utils.ProductDataFixture.aProductData;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PriceResponseConverterTest {

    @Test
    void generatesPriceResponse() {
        Product product = createProductBy(aProductData().build());

        PriceResponse priceResponse = PriceResponseConverter.with(product.getPrices()).toResponse();

        assertThat(priceResponse).isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(product.getPrices());
    }
}