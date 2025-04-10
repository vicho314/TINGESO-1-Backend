package com.kartingRM.backend.services;

import com.kartingRM.backend.services.AbstractService;
import com.kartingRM.backend.entities.DiscountEntity;
import com.kartingRM.backend.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
// get, save, update, delete
@Service
public class DiscountService extends AbstractService<DiscountEntity>{
    @Autowired
    private DiscountRepository discountRepo;
    
    public DiscountService(DiscountRepository discountRepo) {
	super(discountRepo);
        this.discountRepo = discountRepo;
    }

    public List<String> getCategories(){
	return discountRepo.findDistinctCategory();
    }
    //FIXME: Check if category exists first!
    public List<DiscountEntity> getDiscountsbyCategory(String cat){
	if(this.getCategories().contains(cat)){
		return discountRepo.findAllByCategory(cat)
	}
	else{//FIXME: Optional<>? Exception?
		return null;
	}
    }
}
