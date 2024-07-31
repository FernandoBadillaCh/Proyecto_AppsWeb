package com.proyecto.service;

import com.proyecto.domain.Categoria;
import com.proyecto.domain.Usuario;

import java.util.List;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public Usuario getUsuario(Long idUsuario);

	public void eliminar(Long idUsuario);

	public void guardar(Usuario usuario);
}
