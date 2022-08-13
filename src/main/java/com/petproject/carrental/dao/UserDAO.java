package com.petproject.carrental.dao;

import com.petproject.carrental.models.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
}
