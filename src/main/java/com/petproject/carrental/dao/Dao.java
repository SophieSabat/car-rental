package com.petproject.carrental.dao;

import com.petproject.carrental.models.user.User;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void delete(T t);
}
