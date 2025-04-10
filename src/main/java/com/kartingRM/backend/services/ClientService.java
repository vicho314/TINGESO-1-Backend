package com.kartingRM.backend.services;

import com.kartingRM.backend.entities.ClientEntity;
import com.kartingRM.backend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
// get, save, update, delete
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepo;  
    
    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public ClientEntity getClientById(Long id){
	return clientRepo.findById(id).get();
    }

    public List<ClientEntity> getAllClient(){
	return (ArrayList<ClientEntity>) clientRepo.findAll();
    }
    
    public boolean saveClient(ClientEntity newFee){
        clientRepo.save(newFee);
	return true;
    }

    //FIXME: assume it already exists?
    // Should the repo, service or controller do the check?
    public boolean updateClient(ClientEntity newFee){
	clientRepo.save(newFee);
	return true;
    }

    public boolean deleteClient(Long id) throws Exception {
        try {
		clientRepo.deleteById(id);
		return true;
	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
    }
}
