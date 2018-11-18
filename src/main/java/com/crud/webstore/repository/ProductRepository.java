package com.crud.webstore.repository;

import com.crud.webstore.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface ProductRepository extends CrudRepository<Product, Long> {
    @Override
    List<Product> findAll();
    /*
    List<Product> getAllProducts();
    Product getProductById(String productId);
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    List<Product> getProductsByManufacturer(String manufacturer);
    void addProduct(Product product);
    */
}