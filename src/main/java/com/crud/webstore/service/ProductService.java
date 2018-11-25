package com.crud.webstore.service;

import com.crud.webstore.domain.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long productId);

    void deleteByProductId(Long productId);

    Product saveProduct(final Product product);

    List<Product> getByName(String name);

    List<Product> getByCategory(String category);

    List<Product> getByManufacturer(String manufacturer);

    List<Product> getByCriteria(String manufacturer, String category);

    /*

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return repository.getProductsByFilter(filterParams);
    }

    */
}
