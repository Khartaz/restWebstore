package com.crud.webstore.web.controller;

import com.crud.webstore.dto.ProductDto;
import com.crud.webstore.mapper.ProductMapper;
import com.crud.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/product")
public class ProductController {
    private ProductService service;
    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService service, ProductMapper productMapper) {
        this.service = service;
        this.productMapper = productMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(service.getAllProducts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductById")
    public ProductDto getProduct(@RequestParam Long productId)  {
        return productMapper.mapToProductDto(service.getProductById(productId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        service.deleteByProductId(productId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productMapper.mapToProductDto(service.saveProduct(productMapper.mapToProduct(productDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        service.saveProduct(productMapper.mapToProduct(productDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductsByName")
    public List<ProductDto> getByName(@RequestParam String name) {
        return productMapper.mapToProductDtoList(service.getByName(name));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductsByCategory")
    public List<ProductDto> getByCategory(@RequestParam String category) {
        return productMapper.mapToProductDtoList(service.getByCategory(category));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProductsByManufacturer")
    public List<ProductDto> getByManufacturer(@RequestParam String manufacturer) {
        return productMapper.mapToProductDtoList(service.getByManufacturer(manufacturer));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getByCriteria")
    public List<ProductDto> getByCriteria(@RequestParam String manufacturer, @RequestParam String category) {
        return productMapper.mapToProductDtoList(service.getByCriteria(manufacturer, category));
    }
}
