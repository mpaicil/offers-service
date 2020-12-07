package com.walmart.offersservice.presentation.endpoints.responses.converters;

import com.walmart.offersservice.domain.Product;
import com.walmart.offersservice.presentation.endpoints.responses.OfferResponse;
import org.junit.jupiter.api.Test;

import static com.walmart.offersservice.domain.Product.createProductBy;
import static com.walmart.offersservice.utils.ProductDataFixture.aProductData;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class OfferResponseConverterTest {

    @Test
    void generatesOfferResponse() {
        Product product = createProductBy(aProductData().build());

        OfferResponse offerResponse = OfferResponseConverter.with(singletonList(product)).toResponse();

        assertThat(offerResponse.getProducts()).isNotNull()
                .isNotEmpty()
                .hasSize(1);
    }
}