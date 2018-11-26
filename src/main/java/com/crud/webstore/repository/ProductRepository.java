package com.crud.webstore.repository;

import com.crud.webstore.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Override
    List<Product> findAll();

    @Override
    Product findOne(Long productId);

    @Override
    void delete(Long id);

    @Override
    Product save(Product product);

    /*
    Product getProductById(String productId);
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    List<Product> getProductsByManufacturer(String manufacturer);
    void addProduct(Product product);

    JpaRepository<Product, Long>
    */
}