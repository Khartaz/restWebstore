package com.crud.webstore.repository;

import com.crud.webstore.domain.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
    @Override
    UserEntity save(UserEntity userEntity);

    UserEntity findByEmail(String email);

    UserEntity findByUserId(String userId);

    void deleteByUserId(String userId);

    UserEntity findUserEntityByEmailVerificationToken(String token);

    UserEntity findByPasswordToken(String token);

    //List<UserDto> findAll(int page, int limit);

}
