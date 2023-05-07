package com.petproject.carrental.services.implementation;

import com.petproject.carrental.dto.CredentialsDTO;
import com.petproject.carrental.dto.SingUpDTO;
import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.exeptions.AppExeption;
import com.petproject.carrental.mapper.UserMapper;
import com.petproject.carrental.models.user.User;
import com.petproject.carrental.repository.UserRepository;
import com.petproject.carrental.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapperImplementation;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImplementation(UserRepository userRepository, UserMapper userMapperImplementation, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapperImplementation = userMapperImplementation;
        this.passwordEncoder = passwordEncoder;
    }

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
                .orElseThrow(() -> new AppExeption("Unknown user", HttpStatus.NOT_FOUND));

        return userMapperImplementation.toDto(user);
    }

    public UserDTO login(CredentialsDTO credentialsDTO) {
        User user = userRepository.findByEmail(credentialsDTO.getEmail())
                .orElseThrow(() -> new AppExeption("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.getPassword()), user.getPassword())) {
            return userMapperImplementation.toDto(user);
        }

        throw new AppExeption("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDTO register(SingUpDTO userDTO) {
//        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());

//        if (optionalUser.) {
//            throw new AppExeption("Login already exists", HttpStatus.BAD_REQUEST);
//        }

        User user = userMapperImplementation.signUpToUser(userDTO);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDTO.getPassword())));
        userRepository.save(user);

        return userMapperImplementation.toDto(user);
    }
}
