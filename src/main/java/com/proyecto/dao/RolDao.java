package com.proyecto.dao;

import com.proyecto.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol, Long> {

	Rol findByNombre(String roleUser);
}
