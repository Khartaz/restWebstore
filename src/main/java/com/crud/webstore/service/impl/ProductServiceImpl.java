package com.crud.webstore.service.impl;

import com.crud.webstore.dao.ProductDao;
import com.crud.webstore.domain.Product;
import com.crud.webstore.repository.ProductRepository;
import com.crud.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductDao productDao;

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

    public List<Product> getByName(String name) {
        return productDao.findByName(name);
    }

    public List<Product> getByCategory(String category) {
        return productDao.findByCategory(category);
    }

    public List<Product> getByManufacturer(String manufacturer) {
        return productDao.findByManufacturer(manufacturer);
    }

    public List<Product> getByCriteria(String manufacturer, String category) {
        return productDao.findByManufacturerAndCategory(manufacturer, category);
    }
}
