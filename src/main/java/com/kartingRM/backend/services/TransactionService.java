package com.kartingRM.backend.services;

import com.kartingRM.backend.services.AbstractService;
import com.kartingRM.backend.entities.TransactionEntity;
import com.kartingRM.backend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.*;
//import java.util.ArrayList;
// get, save, update, delete
@Service
public class TransactionService extends AbstractService<TransactionEntity> {
    @Autowired
    private TransactionRepository transactionRepo;

    public TransactionService(TransactionRepository repo) {
        super(repo);
	this.transactionRepo = repo;
    }

    public TransactionEntity getTransactionByIdAndDate(Long id, LocalDateTime t){
	    return transactionRepo.findByIdAndReservationDate(id, t);
    }
}
