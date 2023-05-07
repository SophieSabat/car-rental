package com.petproject.carrental.controllers;

import com.petproject.carrental.configs.UserAuthenticationProvider;
import com.petproject.carrental.dto.CredentialsDTO;
import com.petproject.carrental.dto.SingUpDTO;
import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.services.implementation.UserDetailsServiceImplementation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserDetailsServiceImplementation userDetailsServiceImplementation;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid CredentialsDTO credentialsDTO) {
        UserDTO userDTO = userDetailsServiceImplementation.login(credentialsDTO);
        userDTO.setToken(userAuthenticationProvider.createToken(userDTO.getEmail()));
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid SingUpDTO user) {
        UserDTO createdUser = userDetailsServiceImplementation.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(user.getEmail()));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
}
