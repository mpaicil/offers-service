package com.walmart.offersservice.infrastructure.repositories;

import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends MongoRepository<ProductData, String> {

    public List<ProductData> findAllByBrandContainingOrDescriptionContaining(String forBrand, String forDescription);

    public Optional<ProductData> findById(Integer id);

}
