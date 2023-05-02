package com.petproject.carrental.dao;

import com.petproject.carrental.models.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserDAO implements Dao<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public void delete(User user) {

    }

    public Optional<User> findByEmail(String email) {
        return null;
    }
}
