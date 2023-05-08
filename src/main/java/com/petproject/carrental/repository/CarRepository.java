package com.petproject.carrental.repository;

import com.petproject.carrental.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Override
    List<Car> findAll();

    List<Car> findCarsByModel(String model);

    List<Car> findCarsByAutomobileFactory(String automobileFactory);
}
