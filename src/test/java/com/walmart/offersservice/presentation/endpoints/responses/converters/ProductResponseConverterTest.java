package com.walmart.offersservice.presentation.endpoints.responses.converters;

import com.walmart.offersservice.domain.Product;
import com.walmart.offersservice.presentation.endpoints.responses.ProductResponse;
import org.junit.jupiter.api.Test;

import static com.walmart.offersservice.domain.Product.createProductBy;
import static com.walmart.offersservice.presentation.endpoints.responses.converters.ProductResponseConverter.with;
import static com.walmart.offersservice.utils.ProductDataFixture.aProductData;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductResponseConverterTest {

    @Test
    void generatesProductResponse() {
        Product product = createProductBy(aProductData().build());

        ProductResponse productResponse = with(product).toResponse();

        assertThat(productResponse).isNotNull()
                .hasFieldOrPropertyWithValue("id", 40)
                .hasFieldOrPropertyWithValue("brand", "Marca12")
                .hasFieldOrPropertyWithValue("description", "Freezer Horizontal 99L");
    }
}