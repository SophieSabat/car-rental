package com.petproject.carrental.dao;

import com.petproject.carrental.models.car.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Repository
public class CarDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveCar(Car car) {
        entityManager.persist(car);
    }

    public List<Car> findAllCars() {
        return entityManager.createQuery("select c from Car c", Car.class).getResultList();
    }

    public List<Car> findCarsByAutomobileFactory(String automobileFactory) {
        return entityManager.createQuery("select с from Car с where Car.automobileFactory = " + automobileFactory, Car.class).getResultList();
    }

    public List<Car> findCarsByModel(String model) {
        return entityManager.createQuery("select с from Car с where Car.model = " + model, Car.class).getResultList();
    }
}
