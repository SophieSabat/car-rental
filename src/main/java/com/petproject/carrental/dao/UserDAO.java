package com.petproject.carrental.dao;

import com.petproject.carrental.models.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@AllArgsConstructor
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public List<User> findAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User findUserByLogin(String login) {
        Set<Parameter<?>> parameters = entityManager.createQuery("select * from User where User .login = " + login).getParameters();
        
        User user = new User();
        return user;
    }
}
