package com.proyecto.service;

import java.util.List;

import com.proyecto.domain.Usuario;

public interface UsuarioService {
    // Obtiene la lista de usuarios
    public List<Usuario> getUsuarios();
    
    // Obtiene un Usuario a partir del id del usuario
    public Usuario getUsuario(Usuario usuario);
    
    // Inserta un nuevo usuario si el id del usuario está vacío
    // Actualiza un usuario si el id del usuario NO está vacío
    public void save(Usuario usuario);
    
    // Elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuario usuario);
}