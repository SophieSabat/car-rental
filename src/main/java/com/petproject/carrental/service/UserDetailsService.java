package com.petproject.carrental.service;

import com.petproject.carrental.dto.CredentialsDTO;
import com.petproject.carrental.dto.SingUpDTO;
import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDetailsService {

    void addUser(User user);

    List<User> getAllUsers();

    UserDTO findByEmail(String email);

    UserDTO login(CredentialsDTO credentialsDTO);

    UserDTO register(SingUpDTO userDTO);
}
