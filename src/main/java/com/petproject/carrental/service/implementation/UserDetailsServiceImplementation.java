package com.petproject.carrental.service.implementation;

import com.petproject.carrental.dto.CredentialsDTO;
import com.petproject.carrental.dto.SingUpDTO;
import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.exception.AppException;
import com.petproject.carrental.mapper.UserMapper;
import com.petproject.carrental.model.user.User;
import com.petproject.carrental.repository.UserRepository;
import com.petproject.carrental.service.UserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapperImplementation;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void addUser(User user) {
        if (user != null) {
            userRepository.save(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        return userMapperImplementation.toDto(user);
    }

    @Override
    public UserDTO login(CredentialsDTO credentialsDTO) {
        User user = userRepository.findByEmail(credentialsDTO.getEmail())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.getPassword()), user.getPassword())) {
            return userMapperImplementation.toDto(user);
        }

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserDTO register(SingUpDTO userDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapperImplementation.signUpToUser(userDTO);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDTO.getPassword())));
        userRepository.save(user);

        return userMapperImplementation.toDto(user);
    }
}
