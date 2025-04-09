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
    private String rut;
    @Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private Date birthDay;
    //private String rutLastDigit;
    private int monthlyRecord;
    @ManyToMany
    @JoinTable(
    	name = "client_transaction",
    	joinColumns = @JoinColumn(name = "client_id"),
    	inverseJoinColumns = @JoinColumn(name = "transaction_id"),
    	)
    private List<TransactionEntity> transactionsList;
}
