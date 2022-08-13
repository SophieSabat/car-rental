package com.petproject.carrental.controllers;

import com.petproject.carrental.models.user.User;
import com.petproject.carrental.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping("/register")
    public void register(@RequestParam String login, String password, String email, String firstName, String lastName) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRoleID(3);
        userService.save(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        List<User> users = userService.findAll();
        return users;
    }
}
