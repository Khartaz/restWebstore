package com.crud.webstore.service;

import com.crud.webstore.domain.Product;
import com.crud.webstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long productId) {
        return repository.findOne(productId);
    }

    public void deleteByProductId(Long productId) {
        repository.delete(productId);
    }

    public Product saveProduct(final Product product) {
        return repository.save(product);
    }

    public List<Product> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Product> getByManufacturer(String manufacturer) {
        return repository.findByManufacturer(manufacturer);
    }
    /*
    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    public Product getProductById(String productId) {
        return repository.getProductById(productId);
    }

    public List<Product> getProductsByCategory(String category) {
        return repository.getProductsByCategory(category);
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return repository.getProductsByFilter(filterParams);
    }

    public List<Product> getProductsByManufacturer(String manufacturer) {
        return repository.getProductsByManufacturer(manufacturer);
    }

    public void addProduct(Product product) {
        repository.addProduct(product);
    }
    */
}
