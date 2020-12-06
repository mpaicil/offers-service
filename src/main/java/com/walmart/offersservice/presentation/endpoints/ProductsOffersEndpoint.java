package com.walmart.offersservice.presentation.endpoints;

import com.walmart.offersservice.presentation.endpoints.responses.OfferResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.walmart.offersservice.presentation.endpoints.utils.OfferResponseFixture.anOfferResponse;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ProductsOffersEndpoint {

    @RequestMapping(value = "products", params = "id", method = GET)
    public ResponseEntity<OfferResponse> retrieveProductsById(@RequestParam Integer id) {
        return ok(anOfferResponse().build());
    }

    @RequestMapping(value = "products", params = "text", method = GET)
    public ResponseEntity<OfferResponse> retrieveProductsByText(@RequestParam String text) {
        return ok(anOfferResponse().build());
    }

}
