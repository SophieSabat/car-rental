package com.petproject.carrental.repository;

import com.petproject.carrental.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Override
    List<User> findAll();
}
