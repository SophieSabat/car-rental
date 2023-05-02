package com.petproject.carrental.services;

import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.models.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDetailsService {

    void addUser(User user);

    List<User> getAllUsers();

    UserDTO findByEmail(String email);
}
