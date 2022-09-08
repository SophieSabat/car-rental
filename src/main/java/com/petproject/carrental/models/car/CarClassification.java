package com.petproject.carrental.models.car;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "car_classification")
public class CarClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(name = "seating_capacity")
    int seatingCapacity;

    public CarClassification(String name, int seatingCapacity) {
        this.name = name;
        this.seatingCapacity = seatingCapacity;
    }
}
