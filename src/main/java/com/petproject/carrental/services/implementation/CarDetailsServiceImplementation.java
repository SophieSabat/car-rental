package com.petproject.carrental.services.implementation;

import com.petproject.carrental.dao.CarDAO;
import com.petproject.carrental.models.car.Car;
import com.petproject.carrental.services.CarDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarDetailsServiceImplementation implements CarDetailsService {
    private CarDAO carDAO;

    @Override
    public void save(Car car) {
        if (car != null) {
            carDAO.save(car);
        }
    }

    @Override
    public List<Car> getAllCars() {
        return carDAO.getAll();
    }

    @Override
    public List<Car> getCarsByModel(String model) {
        return carDAO.findCarsByModel(model);
    }

    @Override
    public List<Car> getCarsByAutomobileFactory(String automobileFactory) {
        return carDAO.findCarsByAutomobileFactory(automobileFactory);
    }
}
