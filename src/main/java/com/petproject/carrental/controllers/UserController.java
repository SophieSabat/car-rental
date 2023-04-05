package com.petproject.carrental.controllers;

import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.mapper.UserMapperImplementation;
import com.petproject.carrental.models.user.User;
import com.petproject.carrental.services.UserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserDetailsService userService;
    private final UserMapperImplementation mapper;

    //    @PostMapping
    @RequestMapping(value = "/register")
    public void register(@RequestBody UserDTO userDTO) {
        if (userDTO != null) {
            User user = mapper.toUser(userDTO);
            userService.addUser(user);
        }
    }

    @GetMapping(value = "/getUser/{login}")
    public UserDTO getUserByLogin(@PathVariable String login) {
        if (login == null) {
            return null;
        }
        UserDTO userDTO = mapper.toDto(userService.getUserByLogin(login));
        return userDTO;
    }
}
