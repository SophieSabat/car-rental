package com.petproject.carrental.model.order;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "order_number")
    private int orderNumber;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "order_status_id")
    private int orderStatusId;

    public Order(int orderNumber, int userId, int orderStatusId) {
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.orderStatusId = orderStatusId;
    }
}
