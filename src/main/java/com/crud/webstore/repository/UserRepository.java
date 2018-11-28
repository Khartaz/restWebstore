package com.crud.webstore.repository;

import com.crud.webstore.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Override
    UserEntity save(final UserEntity userEntity);

    UserEntity findByEmail(String email);

    UserEntity findByUserId(String id);

    void deleteByUserId(String userId);

}
