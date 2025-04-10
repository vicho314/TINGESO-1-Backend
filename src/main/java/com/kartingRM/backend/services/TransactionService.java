package com.kartingRM.backend.services;

import com.kartingRM.backend.entities.TransactionEntity;
import com.kartingRM.backend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
// get, save, update, delete
@Service
public class TransactionService extends AbstractService<TransactionEntity,TransactionRepository> {
    @Autowired
    private TransactionRepository transactionRepo;  
    
    public TransactionService(TransactionRepository repo) {
        super(repo);
	this.transactionRepo = repo;
    }    
}
