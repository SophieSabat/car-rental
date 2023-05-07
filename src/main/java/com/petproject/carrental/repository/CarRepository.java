package com.petproject.carrental.repository;

import com.petproject.carrental.models.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Override
    List<Car> findAll();

    List<Car> findCarsByModel(String model);

    List<Car> findCarsByAutomobileFactory(String automobileFactory);
}
