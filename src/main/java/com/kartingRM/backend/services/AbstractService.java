package com.kartingRM.backend.services;

//import com.kartingRM.backend.entities.FeeTypeEntity;
//import com.kartingRM.backend.repositories.FeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

// get, save, update, delete
//@Service
public abstract class AbstractService<T> {
    @Autowired
    public JpaRepository<T, Long> repo;
    //public R repo;

    //public AbstractService(JpaRepository<T,Long> repo) {
    public AbstractService(JpaRepository<T, Long> repo) {
        this.repo = repo;
    }

    public T getById(Long id){
	return repo.findById(id).get();
    }

    public List<T> getAll(){
	return (ArrayList<T>) repo.findAll();
    }

    public boolean save(T newFee){
        repo.save(newFee);
	return true;
    }

    //FIXME: assume it already exists?
    // Should the repo, service or controller do the check?
    public boolean update(T newFee){
	repo.save(newFee);
	return true;
    }

    public boolean delete(Long id) throws Exception {
        try {
		repo.deleteById(id);
		return true;
	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
    }
}
