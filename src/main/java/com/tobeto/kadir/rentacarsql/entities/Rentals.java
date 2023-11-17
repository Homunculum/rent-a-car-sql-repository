package com.tobeto.kadir.rentacarsql.entities;

import jakarta.persistence.*;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rentals")
@Entity
public class Rentals {
    @Id
    @Column(name="rentals_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "retal_date")
    private Date rentalDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "total_price")
    private int totalPrice;

    @ManyToOne
    @JoinColumn(name = "cars_id")
    private Cars car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

}
