package com.proyecto.dao;

import com.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
}
