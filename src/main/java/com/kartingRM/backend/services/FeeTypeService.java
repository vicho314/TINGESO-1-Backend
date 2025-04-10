package com.kartingRM.backend.services;

import com.kartingRM.backend.services.AbstractService;
import com.kartingRM.backend.entities.FeeTypeEntity;
import com.kartingRM.backend.repositories.FeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.ArrayList;
// get, save, update, delete
@Service
public class FeeTypeService extends AbstractService<FeeTypeEntity>{
    @Autowired
    private FeeTypeRepository feeTypeRepo;  
    
    public FeeTypeService(FeeTypeRepository feeTypeRepo) {
        this.feeTypeRepo = feeTypeRepo;
    }
    
    public List<int> getLaps(){
	return feeTypeRepo.findDistinctLaps();
    }

    public List<FeeTypeEntity> getFeeTypeByLap(int laps){
	return feeTypeRepo.findAllByLaps(laps);
    }
}
