package com.crud.webstore.repository.impl;

import com.crud.webstore.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepositoryImpl {
    private List<Product> listOfProducts = new ArrayList<>();

    public List<Product> findByCateogry(String category) {
        return listOfProducts.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
