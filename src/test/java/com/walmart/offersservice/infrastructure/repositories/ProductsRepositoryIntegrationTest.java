package com.walmart.offersservice.infrastructure.repositories;

import com.walmart.offersservice.OffersServiceApplication;
import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ActiveProfiles("local")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = OffersServiceApplication.class)
class ProductsRepositoryIntegrationTest {

    public static final String EXAMPLE_WORD = "Televi";

    @Autowired
    private ProductsRepository productsRepository;

    @Test
    void retrievesDataFromBrandOrDescription() {

        List<ProductData> products = productsRepository.findAllByBrandContainingOrDescriptionContaining(EXAMPLE_WORD, EXAMPLE_WORD);

        assertThat(products).isNotNull()
                .isNotEmpty()
                .hasSize(5);
    }

    @Test
    void retrievesDataFromTheID() {
        Optional<ProductData> product = productsRepository.findById(150);

        assertThat(product).isPresent()
                .get().hasNoNullFieldsOrProperties()
                .hasFieldOrPropertyWithValue("brand", "Marca Acme")
                .hasFieldOrPropertyWithValue("description", "luces crypto 80W");
    }
}