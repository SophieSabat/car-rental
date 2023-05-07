package com.petproject.carrental.services.implementation;

import com.petproject.carrental.models.car.Car;
import com.petproject.carrental.repository.CarRepository;
import com.petproject.carrental.services.CarDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarDetailsServiceImplementation implements CarDetailsService {

    private final CarRepository carRepository;

    @Override
    public void save(Car car) {
        if (car != null) {
            carRepository.save(car);
        }
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getCarsByModel(String model) {
        return carRepository.findCarsByModel(model);
    }

    @Override
    public List<Car> getCarsByAutomobileFactory(String automobileFactory) {
        return carRepository.findCarsByAutomobileFactory(automobileFactory);
    }
}
