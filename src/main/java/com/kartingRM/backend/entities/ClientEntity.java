package com.kartingRM.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import com.kartingRM.backend.entities.TransactionEntity; 

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //private String category;
    @Column(unique = true, nullable = false)
    private String rutId;
    private String name;
    private Date birthDay;
    //private String rutLastDigit;
    //amount of times the client has purchased the service in a month
    private int purchaseMonthlyRecord;
    @ManyToMany
    @JoinColumn(name = "transaction_id")
    private List<TransactionEntity> transactionsList;
}
