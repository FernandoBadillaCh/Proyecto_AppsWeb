package com.proyecto.dao;

import com.proyecto.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RolDao extends JpaRepository<Rol, Long> {



}
