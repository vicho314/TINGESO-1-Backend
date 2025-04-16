package com.kartingRM.backend.controllers;

import com.kartingRM.backend.entities.FeeTypeEntity;
import com.kartingRM.backend.services.FeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Service; 

import java.util.List;
import java.time.*;

@RestController                                                                 
@RequestMapping("/api/v1/feeType")                                            
@CrossOrigin("*")
public class FeeTypeEntity {
	//get,save,update,delete, getRut,getName, getAllBirthday
	@Autowired
	FeeTypeService feeTypeService;

	@GetMapping("/")
	public List<FeeTypeEntity> listFeeTypes() {
		return feeTypeService.getAll();
	}

	@GetMapping("/{id}")
	public FeeTypeEntity getFeeTypeById(@PathVariable Long id){
		return feeTypeService.getById(id);
	}

	@GetMapping("/")
	public FeeTypeEntity getFeeTypeByLap(@RequestParam int lap){
		return feeTypeService.getFeeTypeByLap(lap);
	}
	
	@GetMapping("/allCat")
	public List<FeeTypeEntity> getLaps(){
		return feeTypeService.getLaps();
	}

	@PostMapping("/")
	public boolean saveFeeType(@RequestBody FeeTypeEntity feeType){
		boolean result = feeTypeService.save(feeType);
		return result;
	}

	@PutMapping("/")
	public boolean updateFeeType(@RequestBody FeeTypeEntity feeType){
		boolean result = feeTypeService.update(feeType);
		return result;
	}

	@DeleteMapping("/{id}")
	public boolean deleteFeeType(@PathVariable Long id){
		boolean result = feeTypeService.delete(id);
	}
}
