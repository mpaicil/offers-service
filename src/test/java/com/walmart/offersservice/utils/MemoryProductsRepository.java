package com.walmart.offersservice.utils;

import com.walmart.offersservice.infrastructure.repositories.ProductsRepository;
import com.walmart.offersservice.infrastructure.repositories.domain.ProductData;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryProductsRepository implements ProductsRepository {

    private List<ProductData> products = new ArrayList<>();

    @Override
    public List<ProductData> findAllByBrandContainingOrDescriptionContaining(String forBrand, String forDescription) {
        return products.stream()
                .filter(productData -> productData.getDescription().contains(forDescription) || productData.getBrand().contains(forBrand))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductData> findById(Integer id) {
        return products.stream().filter(productData -> productData.getId().equals(id)).findAny();
    }

    @Override
    public <S extends ProductData> S save(S entity) {
        products.add(entity);
        return entity;
    }

    @Override
    public <S extends ProductData> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ProductData> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<ProductData> findAll() {
        return null;
    }

    @Override
    public Iterable<ProductData> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(ProductData entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProductData> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ProductData> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProductData> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductData> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends ProductData> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends ProductData> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProductData> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ProductData> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ProductData> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductData> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProductData> boolean exists(Example<S> example) {
        return false;
    }
}
