package com.kartingRM.backend.controllers;

import com.kartingRM.backend.entities.ClientEntity;
import com.kartingRM.backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Service; 

import java.util.List;
import java.time.*;

@RestController                                                                 
@RequestMapping("/api/v1/client")                                            
@CrossOrigin("*")
public class ClientController {
	//get,save,update,delete, getRut,getName, getAllBirthday
	@Autowired
	ClientService clientService;

	@GetMapping("/")
	public List<ClientEntity> listClients() {
		return clientService.getAll();
	}

	@GetMapping("/{id}")
	public ClientEntity getClientById(@PathVariable Long id){
		return clientService.getById(id);
	}

	@GetMapping("/name/")
	public ClientEntity getClientByName(@RequestParam String name){
		return clientService.getClientByName(name);
	}
	
	@GetMapping("/rut/")
	public ClientEntity getClientByRut(@RequestParam String rut){
		return clientService.getClientByRut(rut);
	}
	
	@GetMapping("/birth/")
	public List<ClientEntity> getClientAllByBirthday(@RequestParam LocalDate birthdate){
		return clientService.getClientAllByBirthday(birthdate);
	}
	
	@PostMapping("/")
	public boolean saveClient(@RequestBody ClientEntity client){
		boolean result = clientService.save(client);
		return result;
	}

	@PutMapping("/")
	public boolean updateClient(@RequestBody ClientEntity client){
		boolean result = clientService.update(client);
		return result;
	}

	@DeleteMapping("/{id}")
	public boolean deleteClient(@PathVariable Long id){
		boolean result = clientService.delete(id);
		return result;
	}
}
