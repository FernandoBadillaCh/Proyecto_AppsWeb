/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.PlatoFuerte;
import java.util.List;

/**
 *
 * @author pepon
 */
public interface PlatoFuerteService {
    public List<PlatoFuerte> getPlatosFuertes(boolean activos);
    
     // Se obtiene un Categoria, a partir del id de un categoria
    public PlatoFuerte PlatoFuerte(PlatoFuerte platoFuerte);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(PlatoFuerte platoFuerte);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(PlatoFuerte platoFuerte);
}
