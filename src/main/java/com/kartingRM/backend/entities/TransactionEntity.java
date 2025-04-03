package com.kartingRM.backend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.kartingRM.backend.entities.FeeTypeEntity;
import com.kartingRM.backend.entities.ClientEntity;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //private String category;
    private String reservationCode;
    private Date reservationDate;
    private FeeTypeEntity feeInfo;
    private int peopleAmount;
    private ClientEntity client;
}
