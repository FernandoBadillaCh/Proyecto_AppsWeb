package com.proyecto.service;

import com.proyecto.domain.Usuario;


import java.util.List;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public Usuario getUsuario(Long idUsuario);

	public void eliminar(Long idUsuario);

	public void guardar(Usuario usuario);


	// Se obtiene un Usuario, a partir del id de un usuario
	public Usuario getUsuario(Usuario usuario);

	// Se obtiene un Usuario, a partir del username de un usuario
	public Usuario getUsuarioPorUsername(String username);
	// Se obtiene un Usuario, a partir del username y el password de un usuario
	public Usuario getUsuarioPorUsernameYClave(String username, String clave);

	// Se obtiene un Usuario, a partir del username y el password de un usuario
	public Usuario getUsuarioPorUsernameOCorreo(String username, String correo);

	// Se valida si existe un Usuario considerando el username
	public boolean existeUsuarioPorUsernameOCorreo(String username, String correo);

	public void save(Usuario usuario,boolean crearRolUser);

}
