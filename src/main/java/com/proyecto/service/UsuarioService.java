package com.proyecto.service;

import com.proyecto.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public Usuario getUsuario(Long idUsuario);

	public void eliminar(Long idUsuario);

	public void guardar(Usuario usuario);

	public Page<Usuario> getUsuarios(Pageable pageable);
}
