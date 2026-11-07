package com.upiiz.security.repositories;

import com.upiiz.security.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    //Requerimos otros metodo
    Optional<User> findByUsername(String username);
}
