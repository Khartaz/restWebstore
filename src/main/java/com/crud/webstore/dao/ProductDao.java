package com.crud.webstore.dao;

import com.crud.webstore.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductDao extends CrudRepository<Product, Long> {
    @Query
    List<Product> findByName(@Param("NAME") String name);

    List<Product> findByCategory(String category);

    List<Product> findByManufacturer(String manufacturer);

    List<Product> findByManufacturerAndCategory(String manufacturer, String category);
}
