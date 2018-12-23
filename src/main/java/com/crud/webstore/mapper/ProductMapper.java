package com.crud.webstore.mapper;

import com.crud.webstore.domain.ProductEntity;
import com.crud.webstore.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductEntity mapToProduct(final ProductDto productDto) {
        return new ProductEntity(
                productDto.getProductId(),
                productDto.getName(),
                productDto.getUnitPrice(),
                productDto.getDescription(),
                productDto.getManufacturer(),
                productDto.getCategory(),
                productDto.getUnitsInStock()
        );
    }

    public ProductDto mapToProductDto(final ProductEntity productEntity) {
        return new ProductDto(
                productEntity.getProductId(),
                productEntity.getName(),
                productEntity.getUnitPrice(),
                productEntity.getDescription(),
                productEntity.getManufacturer(),
                productEntity.getCategory(),
                productEntity.getUnitsInStock()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<ProductEntity> productEntityList) {
        return productEntityList.stream()
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

    public List<ProductEntity> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(p -> new ProductEntity(
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
