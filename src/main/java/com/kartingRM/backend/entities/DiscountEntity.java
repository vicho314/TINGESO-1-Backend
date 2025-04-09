package com.kartingRM.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "discounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //FIXME: ManyToOne
    private String category;
    private int groupRangeMin;
    private int groupRangeMax;
    private String freqClientCategory;
    private int totalTime;
    private String specialDayType;
    private Date specialDay;
    private boolean atBirthDay;
    private float percent;
    @ManyToMany(mappedBy = "discountList")
    private List<TransactionEntity> discountTransactionList;
}
