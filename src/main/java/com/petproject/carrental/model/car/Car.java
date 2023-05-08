package com.petproject.carrental.model.car;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "car")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "automobile_factory")
    private String automobileFactory;
    private String model;
    private int year;
    private int price;
    @Column(name = "available_for_booking")
    private Boolean availableForBooking;
    @Column(name = "car_classification_id")
    private int carClassificationId;

    public Car(String automobileFactory, String model, int year, int price, Boolean availableForBooking, int carClassificationId) {
        this.automobileFactory = automobileFactory;
        this.model = model;
        this.year = year;
        this.price = price;
        this.availableForBooking = availableForBooking;
        this.carClassificationId = carClassificationId;
    }
}
