package com.kartingRM.backend.repositories;


import com.kartingRM.backend.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByRut(String rut);
    ClientEntity findByName(String name);
    ClientEntity findByBirthday(Date bday);
    //ClientEntity findByMonthlyRecord(int count);

}
