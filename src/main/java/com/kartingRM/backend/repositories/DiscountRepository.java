package com.kartingRM.backend.entities;


import com.kartingRM.backend.entities.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
/*
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
*/

public interface usuarioRepository extends JpaRepository<DiscountEntity, Long> {

}
