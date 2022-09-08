package com.petproject.carrental.services;

import com.petproject.carrental.models.car.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    void save(Car car);

    List<Car> findAllCars();

    List<Car> findCarsByModel(String model);

    List<Car> findCarsByAutomobileFactory(String automobileFactory);
}
