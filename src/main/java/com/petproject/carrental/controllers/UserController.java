package com.petproject.carrental.controllers;

import com.petproject.carrental.models.user.User;
import com.petproject.carrental.services.UserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserDetailsService userService;

    @RequestMapping("/register")
    public void register(@RequestBody User user) {
        if (user != null) {
            userService.save(user);
        }
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
