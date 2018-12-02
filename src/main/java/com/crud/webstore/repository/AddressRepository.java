package com.crud.webstore.repository;

import com.crud.webstore.domain.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
    @Override
    AddressEntity save(final AddressEntity addressEntity);
}
