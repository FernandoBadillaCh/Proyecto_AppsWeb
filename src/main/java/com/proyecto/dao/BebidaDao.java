package com.proyecto.dao;

import com.proyecto.domain.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BebidaDao extends JpaRepository <Bebida,Long> {
    
}
