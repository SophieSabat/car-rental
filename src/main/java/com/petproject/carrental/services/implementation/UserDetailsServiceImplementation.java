package com.petproject.carrental.services.implementation;

import com.petproject.carrental.dao.UserDAO;
import com.petproject.carrental.dto.CredentialsDTO;
import com.petproject.carrental.dto.SingUpDTO;
import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.exeptions.AppExeption;
import com.petproject.carrental.mapper.UserMapperImplementation;
import com.petproject.carrental.models.user.User;
import com.petproject.carrental.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserDAO userDAO;
    private UserMapperImplementation userMapperImplementation;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsServiceImplementation(UserDAO userDAO, UserMapperImplementation userMapperImplementation, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.userMapperImplementation = userMapperImplementation;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(User user) {
        if (user != null) {
            userDAO.save(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userDAO.findByEmail(email)
                .orElseThrow(() -> new AppExeption("Unknown user", HttpStatus.NOT_FOUND));

        return userMapperImplementation.toDto(user);
    }

    public UserDTO login(CredentialsDTO credentialsDTO) {
        User user = userDAO.findByEmail(credentialsDTO.getEmail())
                .orElseThrow(() -> new AppExeption("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.getPassword()), user.getPassword())) {
            return userMapperImplementation.toDto(user);
        }

        throw new AppExeption("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDTO register(SingUpDTO userDTO) {
        Optional<User> optionalUser = userDAO.findByEmail(userDTO.getEmail());

        if (optionalUser.isPresent()) {
            throw new AppExeption("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapperImplementation.singUpToUser(userDTO);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDTO.getPassword())));
        userDAO.save(user);

        return userMapperImplementation.toDto(user);
    }
}
