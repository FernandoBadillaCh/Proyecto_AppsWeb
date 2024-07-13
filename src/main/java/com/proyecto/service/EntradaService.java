package com.proyecto.service;

import com.proyecto.domain.Entrada;
import java.util.List;


public interface EntradaService {
     public List<Entrada> getEntradas(boolean activos);
    
     // Se obtiene un Categoria, a partir del id de un categoria
    public Entrada getEntrada(Entrada entrada);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Entrada entrada);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Entrada entrada);
}
