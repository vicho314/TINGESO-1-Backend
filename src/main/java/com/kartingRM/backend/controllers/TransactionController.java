package com.kartingRM.backend.controllers;

import com.kartingRM.backend.entities.TransactionEntity;
import com.kartingRM.backend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Service; 

import java.util.List;
import java.time.*;

@RestController                                                                 
@RequestMapping("/api/v1/transaction")                                            
@CrossOrigin("*")
public class TransactionEntity {
	//get,save,update,delete, getRut,getName, getAllBirthday
	@Autowired
	TransactionService transactionService;

	@GetMapping("/")
	public List<TransactionEntity> listTransactions() {
		return transactionService.getAll();
	}

	@GetMapping("/{id}")
	public TransactionEntity getTransactionById(@PathVariable Long id){
		return transactionService.getById(id);
	}	
	
	@GetMapping("/find")
	public TransactionEntity getTransactionByIdandDate(@RequestParam Long id,@RequestParam LocalDateTime date){
		return transactionService.getTransactionByIdandDate(id,date);
	}
	
	@PostMapping("/")
	public boolean saveTransaction(@RequestBody TransactionEntity transaction){
		boolean result = transactionService.save(transaction);
		return result;
	}

	@PutMapping("/")
	public boolean updateTransaction(@RequestBody TransactionEntity transaction){
		boolean result = transactionService.update(transaction);
		return result;
	}

	@DeleteMapping("/{id}")
	public boolean deleteTransaction(@PathVariable Long id){
		boolean result = transactionService.delete(id);
	}
}
