package com.petproject.carrental.services.implementation;

import com.petproject.carrental.dao.UserDAO;
import com.petproject.carrental.models.user.User;
import com.petproject.carrental.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private UserDAO userDAO;

    @Override
    public void save(User user) {
        if (user != null) {
            userDAO.saveUser(user);
        }
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAllUsers();
    }
}
