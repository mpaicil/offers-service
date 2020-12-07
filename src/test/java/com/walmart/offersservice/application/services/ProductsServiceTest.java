package com.walmart.offersservice.application.services;

import com.walmart.offersservice.domain.Product;
import com.walmart.offersservice.infrastructure.repositories.ProductsRepository;
import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;
import com.walmart.offersservice.utils.MemoryProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static com.walmart.offersservice.utils.ProductDataFixture.aProductData;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ProductsServiceTest {

    private ProductsRepository productsRepository;

    private ProductsService productsService;

    @BeforeEach
    void setUp() {
        productsRepository = new MemoryProductsRepository();
        productsService = new ProductsService(productsRepository);

        prepareProductInformation();
    }

    @Test
    void returnsThePersistProductWithId123() {
        Optional<Product> optionalProduct = productsService.findProductById(123);

        assertThat(optionalProduct).isNotNull()
                .isPresent();
    }

    @Test
    void returnsEmptyForAnInvalidID() {
        Optional<Product> optionalProduct = productsService.findProductById(321);

        assertThat(optionalProduct).isNotNull()
                .isEmpty();
    }

    @Test
    void returnsProductsListFromCommonDescriptionOrBrand() {
        List<Product> productList = productsService.findProductsByText("ejemplo");

        assertThat(productList).isNotNull()
                .isNotEmpty()
                .hasSize(2);
    }

    @Test
    void returnsEmptyListWhenTheTextDoesntMatch() {
        List<Product> productList = productsService.findProductsByText("nadaquever");

        assertThat(productList).isNotNull()
                .isEmpty();
    }

    private void prepareProductInformation() {
        ProductData firstProductData = aProductData().withId(123).withDescription("ejemplo de descripcion").build();
        ProductData secondProductData = aProductData().withId(222).withDescription("ejemplo de descripcion con mas informacion").build();

        productsRepository.save(firstProductData);
        productsRepository.save(secondProductData);
    }
}