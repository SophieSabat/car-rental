package com.petproject.carrental.service;

import com.petproject.carrental.model.car.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarDetailsService {
    void save(Car car);

    List<Car> getAllCars();

    List<Car> getCarsByModel(String model);

    List<Car> getCarsByAutomobileFactory(String automobileFactory);
}
