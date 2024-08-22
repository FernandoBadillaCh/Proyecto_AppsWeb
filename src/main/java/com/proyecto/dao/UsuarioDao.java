package com.proyecto.dao;

import com.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	Usuario findByCorreo(String correo);

	Usuario findByCorreoAndClave(String correo, String Clave);

	boolean existsByCorreo(String correo);
}
