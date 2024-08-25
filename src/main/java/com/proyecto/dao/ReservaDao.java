package com.proyecto.dao;

import com.proyecto.domain.Mesa;
import com.proyecto.domain.Reserva;
import com.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaDao extends JpaRepository<Reserva, Long> {


}
