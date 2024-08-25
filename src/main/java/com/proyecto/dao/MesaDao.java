package com.proyecto.dao;

import com.proyecto.domain.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaDao extends JpaRepository<Mesa, Long> {

	Mesa findByIdMesa(Long idMesa);
}
