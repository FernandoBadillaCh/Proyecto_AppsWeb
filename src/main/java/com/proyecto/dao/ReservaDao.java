package com.proyecto.dao;

import com.proyecto.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Long>{
}
