package com.crud.webstore.mapper;

import com.crud.webstore.domain.Product;
import com.crud.webstore.domain.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getProductId(),
                productDto.getName(),
                productDto.getUnitPrice(),
                productDto.getDescription(),
                productDto.getManufacturer(),
                productDto.getCategory(),
                productDto.getUnitsInStock()
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getName(),
                product.getUnitPrice(),
                product.getDescription(),
                product.getManufacturer(),
                product.getCategory(),
                product.getUnitsInStock()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(p -> new ProductDto(
                        p.getProductId(),
                        p.getName(),
                        p.getUnitPrice(),
                        p.getDescription(),
                        p.getManufacturer(),
                        p.getCategory(),
                        p.getUnitsInStock()))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(p -> new Product(
                        p.getProductId(),
                        p.getName(),
                        p.getUnitPrice(),
                        p.getDescription(),
                        p.getManufacturer(),
                        p.getCategory(),
                        p.getUnitsInStock()))
                .collect(Collectors.toList());
    }
}
