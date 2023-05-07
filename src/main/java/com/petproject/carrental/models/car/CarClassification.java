package com.petproject.carrental.models.car;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "car_classification")
@Entity
public class CarClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @Column(name = "seating_capacity")
    private int seatingCapacity;

    public CarClassification(String name, int seatingCapacity) {
        this.name = name;
        this.seatingCapacity = seatingCapacity;
    }
}
