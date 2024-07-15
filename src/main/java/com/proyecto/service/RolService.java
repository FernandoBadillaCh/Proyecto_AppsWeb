package com.proyecto.service;

import java.util.List;

import com.proyecto.domain.Rol;

public interface RolService {
    // Obtiene la lista de roles
    public List<Rol> getRoles();
    
    // Obtiene un Rol a partir del id del rol
    public Rol getRol(Rol rol);
    
    // Inserta un nuevo rol si el id del rol está vacío
    // Actualiza un rol si el id del rol NO está vacío
    public void save(Rol rol);
    
    // Elimina el rol que tiene el id pasado por parámetro
    public void delete(Rol rol);
}