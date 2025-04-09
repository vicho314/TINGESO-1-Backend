package com.kartingRM.backend.services;

import com.kartingRM.backend.entities.FeeTypeEntity;
import com.kartingRM.backend.repositories.FeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeTypeService {
    @Autowired
    private FeeTypeRepository feeTypeRepo;

    public vehiculoService(FeeTypeRepository feeTypeRepo) {
        this.feeTypeRepo = feeTypeRepo;
    }

    public int createFeeType(FeeTypeEntity newFee){
        FeeTypeEntity foundFee = feeTypeRepo.findById(newFee.getId()).orElse(null);
        if(foundFee != null){
            return 0;
        }
        else{
            feeTypeRepo.save(newFee);
            return 1;
        }
    }
}
