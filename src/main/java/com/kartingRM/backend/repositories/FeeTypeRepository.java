package com.kartingRM.backend.repositories;


import com.kartingRM.backend.entities.FeeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeTypeRepository extends JpaRepository<FeeTypeEntity, Long> {

	List<FeeTypeEntity> findAllByLaps(int laps);
	List<FeeTypeEntity> findAllByLapsTime(int lapstime);
	List<FeeTypeEntity> findByCost(int cost);
	List<FeeTypeEntity> findByTotalTime(int totaltime);
}
