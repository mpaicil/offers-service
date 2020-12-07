package com.walmart.offersservice.presentation.endpoints;

import com.walmart.offersservice.presentation.endpoints.responses.OfferResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@ActiveProfiles("local")
@SpringBootTest
class ProductsOffersEndpointComponentTest {

    @Autowired
    private ProductsOffersEndpoint endpoint;

    @Test
    void retrievesSpecificProduct() {
        ResponseEntity<OfferResponse> responseEntity = endpoint.retrieveProductsById(150);

        assertThat(responseEntity)
                .satisfies(offer -> assertThat(offer.getStatusCode()).isEqualTo(HttpStatus.OK))
                .satisfies(response -> assertThat(response.getBody()).isNotNull()
                        .satisfies(body -> assertThat(body.getProducts().get(0).getDescription())
                                .isEqualTo("luces crypto 80W"))
                );
    }

    @Test
    void receiptEmptyOfferOfProducts() {
        ResponseEntity<OfferResponse> responseEntity = endpoint.retrieveProductsById(151);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getProducts()).isEmpty();
    }

    @Test
    void retrievesOfferWithFivesProducts() {
        ResponseEntity<OfferResponse> responseEntity = endpoint.retrieveProductsByText("Televi");

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getProducts()).hasSize(5);
    }

    @Test
    void returnsOfferWithEmptyProducts() {
        ResponseEntity<OfferResponse> responseEntity = endpoint.retrieveProductsByText("nadaquever");

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getProducts()).isEmpty();
    }
}