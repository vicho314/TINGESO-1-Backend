package com.kartingRM.backend.services;

//import com.kartingRM.backend.services.AbstractService;
import com.kartingRM.backend.entities.ClientEntity;
import com.kartingRM.backend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.time.*;
// get, save, update, delete
@Service
public class ClientService{
    @Autowired
    private ClientRepository clientRepo;
    
    public ClientService(ClientRepository clientRepo) {
	//super(clientRepo);
        this.clientRepo = clientRepo;
    }
    
    public ClientEntity getById(Long id){
	return clientRepo.findById(id).get();
    }

    public List<ClientEntity> getAll(){
	return (ArrayList<ClientEntity>) clientRepo.findAll();
    }

    public boolean save(ClientEntity newFee){
        clientRepo.save(newFee);
	return true;
    }

    //FIXME: assume it already exists?
    // Should the repo, service or controller do the check?
    public boolean update(ClientEntity newFee){
	clientRepo.save(newFee);
	return true;
    }

    public boolean delete(Long id){
        try {
		clientRepo.deleteById(id);
		return true;
	
	} catch (Exception e) {
		return false;
		//throw new Exception(e.getMessage());
	}
	
    }

    // Assume it is a valid string, checks are done in frontend!
    public ClientEntity getClientByRut(String rut){
	return clientRepo.findByRut(rut);
    }

    public ClientEntity getClientByName(String name){
	return clientRepo.findByName(name);
    }

    public List<ClientEntity> getClientAllByBirthday(LocalDate day){
	return clientRepo.findAllByBirthday(day);
    }
}
