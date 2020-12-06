package com.walmart.offersservice.presentation.endpoints;

import com.walmart.offersservice.OffersServiceApplication;
import com.walmart.offersservice.presentation.endpoints.responses.OfferResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.http.HttpStatus.OK;

@ActiveProfiles("local")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = OffersServiceApplication.class)
class ProductsOffersEndpointIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void responseFromFinderEndpointById() throws URISyntaxException {
        ResponseEntity<OfferResponse> responseEntity = restTemplate.getForEntity(new URI("http://localhost:8080/offers-service/v1/products?id=150"), OfferResponse.class);

        assertThat(responseEntity.getStatusCode()).isNotNull()
                .isEqualTo(OK);

        assertThat(responseEntity.getBody()).isNotNull()
                .isInstanceOf(OfferResponse.class);
    }

    @Test
    void responseFromFinderEndpointByText() throws URISyntaxException {
        ResponseEntity<OfferResponse> responseEntity = restTemplate.getForEntity(new URI("http://localhost:8080/offers-service/v1/products?text='Televi'"), OfferResponse.class);

        assertThat(responseEntity.getStatusCode()).isNotNull()
                .isEqualTo(OK);

        assertThat(responseEntity.getBody()).isNotNull()
                .isInstanceOf(OfferResponse.class);
    }
}