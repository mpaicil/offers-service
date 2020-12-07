package com.walmart.offersservice.presentation.endpoints;

import com.walmart.offersservice.application.services.ProductsService;
import com.walmart.offersservice.presentation.endpoints.responses.OfferResponse;
import com.walmart.offersservice.presentation.endpoints.responses.converters.OfferResponseConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ProductsOffersEndpoint {

    private ProductsService productsService;

    public ProductsOffersEndpoint(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "products", params = "id", method = GET)
    public ResponseEntity<OfferResponse> retrieveProductsById(@RequestParam Integer id) {
        return ok(OfferResponseConverter
                .with(productsService.findProductById(id)
                        .map(product -> singletonList(product))
                        .orElse(emptyList())
                ).toResponse());
    }

    @RequestMapping(value = "products", params = "text", method = GET)
    public ResponseEntity<OfferResponse> retrieveProductsByText(@RequestParam String text) {
        return ok(OfferResponseConverter
                .with(productsService.findProductsByText(text))
                .toResponse());
    }

}
