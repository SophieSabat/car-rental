package com.petproject.carrental.services.implementation;

import com.petproject.carrental.dao.UserDAO;
import com.petproject.carrental.models.user.User;
import com.petproject.carrental.services.UserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserDAO userDAO;

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
    public User getUserByLogin(String login) {
        return null;
    }
}
