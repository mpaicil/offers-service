package com.walmart.offersservice.application.services;

import com.walmart.offersservice.domain.Product;
import com.walmart.offersservice.infrastructure.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.walmart.offersservice.domain.Product.createProductBy;

@Service
public class ProductsService {

    private ProductsRepository repository;

    public ProductsService(ProductsRepository repository) {
        this.repository = repository;
    }

    public Optional<Product> findProductById(Integer id) {
        return repository.findById(id)
                .map(productData -> createProductBy(productData));
    }

    public List<Product> findProductsByText(String text) {
        return repository.findAllByBrandContainingOrDescriptionContaining(text, text).stream()
                .map(productData -> createProductBy(productData))
                .collect(Collectors.toList());
    }
}
