package com.crud.webstore.domain.dto;

import java.math.BigDecimal;

public class ProductDto {
    private Long productId;
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;

    public ProductDto() {
    }

    public ProductDto(Long productId, String name,
                      BigDecimal unitPrice, String description,
                      String manufacturer, String category, long unitsInStock) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
        this.unitsInStock = unitsInStock;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

}
