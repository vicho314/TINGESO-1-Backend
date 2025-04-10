package com.kartingRM.backend.services;

import com.kartingRM.backend.services.AbstractService;
import com.kartingRM.backend.entities.ClientEntity;
import com.kartingRM.backend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.time.*;
// get, save, update, delete
@Service
public class ClientService extends AbstractService<ClientEntity>{
    @Autowired
    private ClientRepository clientRepo;
    
    public ClientService(ClientRepository clientRepo) {
	super(clientRepo);
        this.clientRepo = clientRepo;
    }
    
    // Assume it is a valid string, checks are done in frontend!
    public ClientEntity getClientByRut(String rut){
	return clientRepo.findByRut(rut).get();
    }

    public ClientEntity getClientByName(String name){
	return clientRepo.findByName(name).get();
    }

    public List<ClientEntity> getClientAllByBirthday(LocalDate day){
	return clientRepo.findAllByBirthday(day);
    }
}
