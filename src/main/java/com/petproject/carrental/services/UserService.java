package com.petproject.carrental.services;

import com.petproject.carrental.models.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void save(User user);

    List<User> findAll();
}
