package com.crud.webstore.web.controller;

import com.crud.webstore.dto.ProductDto;
import com.crud.webstore.mapper.ProductMapper;
import com.crud.webstore.repository.ProductRepository;
import com.crud.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/product")
public class ProductController {
    private ProductRepository repository;
    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(repository.findAll());
    }

    @GetMapping(value = "getProductById")
    public ProductDto getProduct(@RequestParam Long productId)  {
        return productMapper.mapToProductDto(repository.getProductByProductId(productId));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        repository.deleteByProductId(productId);
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productMapper.mapToProductDto(repository.save(productMapper.mapToProduct(productDto)));
    }

    @PostMapping(value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        repository.save(productMapper.mapToProduct(productDto));
    }

    @GetMapping(value = "getProductsByName")
    public List<ProductDto> getByName(@RequestParam String name) {
        return productMapper.mapToProductDtoList(repository.getByName(name));
    }

    @GetMapping(value = "getProductsByCategory")
    public List<ProductDto> getByCategory(@RequestParam String category) {
        return productMapper.mapToProductDtoList(repository.getByCategory(category));
    }

    @GetMapping(value = "getProductsByManufacturer")
    public List<ProductDto> getByManufacturer(@RequestParam String manufacturer) {
        return productMapper.mapToProductDtoList(repository.getByManufacturer(manufacturer));
    }

    @GetMapping(value = "getByCriteria")
    public List<ProductDto> getByCriteria(@RequestParam String manufacturer, @RequestParam String category) {
        return productMapper.mapToProductDtoList(repository.getByManufacturerAndCategory(manufacturer, category));
    }
}
