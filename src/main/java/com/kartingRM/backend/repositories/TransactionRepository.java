package com.kartingRM.backend.repositories;


import com.kartingRM.backend.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
/*
import com.kartingRM.backend.entities.DiscountEntity;
import com.kartingRM.backend.entities.ClientEntity;
*/

//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.*;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	//FIXME: findByFeeType?
	TransactionEntity findByIdAndReservationDate(Long id, LocalDateTime time);
	//FIXME: findByClientList?
}
