package com.proyecto.service;


import com.proyecto.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {



	List<Usuario> getUsuarios();

	Usuario getUsuario(Usuario usuario);

	Usuario getUsuarioPorCorreo(String correo);

	Usuario getUsuarioPorCorreoYClave(String correo, String clave);

	boolean existeUsuarioPorCorreo(String correo);

	void save(Usuario usuario);

	void delete(Usuario usuario);

}
