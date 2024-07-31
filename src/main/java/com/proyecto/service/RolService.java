package com.proyecto.service;

import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;

import java.util.List;

public interface RolService {

	public List<Rol> getRoles();

	public Rol getRol(Long idRol);

	public void delete(Long idRol);

	public void guardar(Rol rol);

	public Rol findById(Long id);

}
