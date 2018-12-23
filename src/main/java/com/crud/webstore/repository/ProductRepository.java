package com.crud.webstore.repository;

import com.crud.webstore.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Override
    ProductEntity save(ProductEntity productEntity);

    @Query
    List<ProductEntity> findByName(@Param("NAME") String name);

    List<ProductEntity> getByManufacturer(String manufacturer);

    List<ProductEntity> getByManufacturerAndCategory(String manufacturer, String category);

    ProductEntity getProductByProductId(Long productId);

    void deleteByProductId(Long productId);

    List<ProductEntity> getByName(String name);

    List<ProductEntity> getByCategory(String category);

}