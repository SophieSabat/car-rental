package com.petproject.carrental.models.car;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "automobile_factory")
    String automobileFactory;
    String model;
    int year;
    int price;
    @Column(name = "available_for_booking")
    Boolean availableForBooking;
    @Column(name = "car_classification_id")
    int carClassificationId;

    public Car(String automobileFactory, String model, int year, int price, Boolean availableForBooking, int carClassificationId) {
        this.automobileFactory = automobileFactory;
        this.model = model;
        this.year = year;
        this.price = price;
        this.availableForBooking = availableForBooking;
        this.carClassificationId = carClassificationId;
    }
}
