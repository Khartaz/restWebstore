package com.crud.webstore.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "products")
public class Product {
    private Long productId;
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;

    public Product() {
    }

    public Product(Long productId, String name,
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long getProductId() {
        return productId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "UNIT_PRICE")
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @Column(name = "MANUFACTURER")
    public String getManufacturer() {
        return manufacturer;
    }

    @Column(name = "CATEGORY")
    public String getCategory() {
        return category;
    }

    @Column(name = "UNITS_IN_STOCK")
    public long getUnitsInStock() {
        return unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public String getCondition() {
        return condition;
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

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
