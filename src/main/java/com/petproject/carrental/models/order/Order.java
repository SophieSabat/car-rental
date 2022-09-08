package com.petproject.carrental.models.order;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "order_number")
    int orderNumber;
    @Column(name = "user_id")
    int userId;
    @Column(name = "order_status_id")
    int orderStatusId;

    public Order(int orderNumber, int userId, int orderStatusId) {
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.orderStatusId = orderStatusId;
    }
}
