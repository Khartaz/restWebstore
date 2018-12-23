package com.crud.webstore.repository;

import com.crud.webstore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Product save(Product product);

    @Query
    List<Product> findByName(@Param("NAME") String name);

    List<Product> getByManufacturer(String manufacturer);

    List<Product> getByManufacturerAndCategory(String manufacturer, String category);

    Product getProductByProductId(Long productId);

    void deleteByProductId(Long productId);

    List<Product> getByName(String name);

    List<Product> getByCategory(String category);

}