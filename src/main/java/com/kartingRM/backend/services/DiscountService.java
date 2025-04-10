package com.kartingRM.backend.services;

import com.kartingRM.backend.entities.DiscountEntity;
import com.kartingRM.backend.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
// get, save, update, delete
@Service
public class DiscountService {
    @Autowired
    private DiscountRepository discountRepo;  
    
    public DiscountService(DiscountRepository discountRepo) {
        this.discountRepo = discountRepo;
    }

    public DiscountEntity getDiscountById(Long id){
	return discountRepo.findById(id).get();
    }

    public List<DiscountEntity> getAllDiscount(){
	return (ArrayList<DiscountEntity>) discountRepo.findAll();
    }
    
    public boolean saveDiscount(DiscountEntity newFee){
        discountRepo.save(newFee);
	return true;
    }

    //FIXME: assume it already exists?
    // Should the repo, service or controller do the check?
    public boolean updateDiscount(DiscountEntity newFee){
	discountRepo.save(newFee);
	return true;
    }

    public boolean deleteDiscount(Long id) throws Exception {
        try {
		discountRepo.deleteById(id);
		return true;
	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
    }
}
