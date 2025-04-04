package com.kartingRM.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.kartingRM.backend.entities.FeeTypeEntity;
import com.kartingRM.backend.entities.ClientEntity;
import com.kartingRM.backend.entities.TransactionEntity;
import java.util.Date;
import java.util.List;
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
    @OneToOne
    @JoinColumn(name = "fee")
    private FeeTypeEntity feeInfo;
    private int peopleAmount;
    @ManyToMany(mappedBy = "discountTransactionList")
    private List<DiscountEntity> discountList;
    @ManyToMany(mappedBy = "transactionsList")
    private List<ClientEntity> clientsList;
}
