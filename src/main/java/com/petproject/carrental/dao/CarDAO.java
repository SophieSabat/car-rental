package com.petproject.carrental.dao;

import com.petproject.carrental.models.car.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class CarDAO implements Dao<Car> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Car> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Car> getAll() {
        return entityManager.createQuery("select c from Car c", Car.class).getResultList();
    }

    @Transactional
    @Override
    public void save(Car car) {
        entityManager.persist(car);
    }

    @Override
    public void delete(Car car) {

    }

    public List<Car> findCarsByAutomobileFactory(String automobileFactory) {
        return entityManager.createQuery("select с from Car с where Car.automobileFactory = " + automobileFactory, Car.class).getResultList();
    }

    public List<Car> findCarsByModel(String model) {
        return entityManager.createQuery("select с from Car с where Car.model = " + model, Car.class).getResultList();
    }
}
