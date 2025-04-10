package com.kartingRM.backend.services;

import com.kartingRM.backend.entities.FeeTypeEntity;
import com.kartingRM.backend.repositories.FeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
// get, save, update, delete
@Service
public class FeeTypeService {
    @Autowired
    private FeeTypeRepository feeTypeRepo;  
    
    public FeeTypeService(FeeTypeRepository feeTypeRepo) {
        this.feeTypeRepo = feeTypeRepo;
    }

    public FeeTypeEntity getFeeTypeById(Long id){
	return feeTypeRepo.findById(id).get();
    }

    public List<FeeTypeEntity> getAllFeeType(){
	return (ArrayList<FeeTypeEntity>) feeTypeRepo.findAll();
    }
    
    public boolean saveFeeType(FeeTypeEntity newFee){
        feeTypeRepo.save(newFee);
	return true;
    }

    //FIXME: assume it already exists?
    // Should the repo, service or controller do the check?
    public boolean updateFeeType(FeeTypeEntity newFee){
	feeTypeRepo.save(newFee);
	return true;
    }

    public boolean deleteFeeType(Long id) throws Exception {
        try {
		feeTypeRepo.deleteById(id);
		return true;
	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
    }
}
