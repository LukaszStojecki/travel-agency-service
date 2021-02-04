package com.example.sda.travelagencyservice.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BuyTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Trip trip;
    @OneToOne
    private Customer customer;
    private BigDecimal tripPrice;
    private BigDecimal adultsQuantity;
    private BigDecimal childQuantity;

}
