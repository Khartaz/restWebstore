package com.crud.webstore.repository;

import com.crud.webstore.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    User save(User user);

    User findByEmail(String email);
}
