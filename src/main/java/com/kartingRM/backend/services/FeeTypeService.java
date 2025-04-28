package com.kartingRM.backend.services;

//import com.kartingRM.backend.services.AbstractService;
import com.kartingRM.backend.entities.FeeTypeEntity;
import com.kartingRM.backend.repositories.FeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
// get, save, update, delete
@Service
public class FeeTypeService{
    @Autowired
    private FeeTypeRepository feeTypeRepo;  
    
    public FeeTypeService(FeeTypeRepository feeTypeRepo) {
	//super(feeTypeRepo);
        this.feeTypeRepo = feeTypeRepo;
    }
    public FeeTypeEntity getById(Long id){
	return feeTypeRepo.findById(id).get();
    }

    public List<FeeTypeEntity> getAll(){
	return (ArrayList<FeeTypeEntity>) feeTypeRepo.findAll();
    }

    public boolean save(FeeTypeEntity newFee){
        feeTypeRepo.save(newFee);
	return true;
    }

    //FIXME: assume it already exists?
    // Should the repo, service or controller do the check?
    public boolean update(FeeTypeEntity newFee){
	feeTypeRepo.save(newFee);
	return true;
    }

    public boolean delete(Long id){
        try {
		feeTypeRepo.deleteById(id);
		return true;
	
	} catch (Exception e) {
		return false;
		//throw new Exception(e.getMessage());
	}
	
    }

    public List<Integer> getLaps(){
	return feeTypeRepo.findDistinctLaps();
    }

    public List<FeeTypeEntity> getFeeTypeByLap(int laps){
	return feeTypeRepo.findAllByLaps(laps);
    }
}
