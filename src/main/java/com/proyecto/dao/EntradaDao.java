
package com.proyecto.dao;

import com.proyecto.domain.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EntradaDao extends JpaRepository <Entrada,Long> {
    
}
