package com.petproject.carrental.controllers;

import com.petproject.carrental.models.car.Car;
import com.petproject.carrental.services.CarDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private CarDetailsService carDetailsService;

    @GetMapping("/addNewCar")
    public void addCar(@RequestParam String automobile_factory, String model, int year, int price, boolean available_for_booking, int car_classification_id) {
        Car car = new Car();
        car.setAutomobileFactory(automobile_factory);
        car.setModel(model);
        car.setYear(year);
        car.setPrice(price);
        car.setAvailableForBooking(available_for_booking);
        car.setCarClassificationId(car_classification_id);
        carDetailsService.save(car);
    }

    @GetMapping("/getAllCars")
    public List<Car> getAllCars() {
        return carDetailsService.findAllCars();
    }

    @GetMapping("/findCarByModel")
    public List<Car> getCarByModel(String model) {
        return carDetailsService.findCarsByModel(model);
    }

    @GetMapping("/findCarByAutomobileFactory")
    public List<Car> getCarByAutomobileFactory(String automobileFactory) {
        return carDetailsService.findCarsByAutomobileFactory(automobileFactory);
    }
}
