package com.kartingRM.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "feetypes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //private String category;
    private int laps;
    private int lapsTime;
    private int cost;
    private int totalTime;
    private List<Discount> discounts;
}
