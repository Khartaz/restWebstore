package com.crud.webstore.repository;

import com.crud.webstore.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Override
    UserEntity save(UserEntity userEntity);

    UserEntity findByEmail(String email);
}
