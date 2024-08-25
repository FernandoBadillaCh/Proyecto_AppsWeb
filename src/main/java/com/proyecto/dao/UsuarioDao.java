package com.proyecto.dao;

import com.proyecto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);

	Usuario findByUsernameAndClave(String username, String Password);

	Usuario findByUsernameOrCorreo(String username, String correo);

	boolean existsByUsernameOrCorreo(String username, String correo);
}
