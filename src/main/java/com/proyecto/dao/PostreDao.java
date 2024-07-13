package com.proyecto.dao;

import com.proyecto.domain.Postre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostreDao extends JpaRepository <Postre,Long> {
    
}
