package com.kartingRM.backend.controllers;

import com.kartingRM.backend.entities.DiscountEntity;
import com.kartingRM.backend.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Service; 

import java.util.List;
import java.time.*;

@RestController                                                                 
@RequestMapping("/api/v1/discount")                                            
@CrossOrigin("*")
public class DiscountController {
	//get,save,update,delete, getRut,getName, getAllBirthday
	@Autowired
	DiscountService discountService;

	@GetMapping("/")
	public List<DiscountEntity> listDiscounts() {
		return discountService.getAll();
	}

	@GetMapping("/{id}")
	public DiscountEntity getDiscountById(@PathVariable Long id){
		return discountService.getById(id);
	}

	@GetMapping("/allCat")
	public List<String> getCategories(){
		return discountService.getCategories();
	}
	
	@GetMapping("/byCat")
	public List<DiscountEntity> getDiscountsByCategory(@RequestParam String cat){
		return discountService.getDiscountsByCategory(cat);
	}
	
	@PostMapping("/")
	public boolean saveDiscount(@RequestBody DiscountEntity client){
		boolean result = discountService.save(client);
		return result;
	}

	@PutMapping("/")
	public boolean updateDiscount(@RequestBody DiscountEntity client){
		boolean result = discountService.update(client);
		return result;
	}

	@DeleteMapping("/{id}")
	public boolean deleteDiscount(@PathVariable Long id){
		boolean result = discountService.delete(id);
		return result;
	}
}
