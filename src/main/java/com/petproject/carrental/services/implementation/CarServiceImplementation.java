package com.petproject.carrental.services.implementation;

import com.petproject.carrental.dao.CarDAO;
import com.petproject.carrental.models.car.Car;
import com.petproject.carrental.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImplementation implements CarService {
    private CarDAO carDAO;

    @Override
    public void save(Car car) {
        if (car != null) {
            carDAO.saveCar(car);
        }
    }

    @Override
    public List<Car> findAllCars() {
        return carDAO.findAllCars();
    }

    @Override
    public List<Car> findCarsByModel(String model) {
        return carDAO.findCarsByModel(model);
    }

    @Override
    public List<Car> findCarsByAutomobileFactory(String automobileFactory) {
        return carDAO.findCarsByAutomobileFactory(automobileFactory);
    }
}
