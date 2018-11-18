package com.crud.webstore.controller;

import com.crud.webstore.domain.ProductDto;
import com.crud.webstore.mapper.ProductMapper;
import com.crud.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/product")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(service.getAllProducts());
    }
}
