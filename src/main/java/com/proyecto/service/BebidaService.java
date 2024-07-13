package com.proyecto.service;

import com.proyecto.domain.Bebida;
import java.util.List;


public interface BebidaService {
    public List<Bebida> getBebidas(boolean activos);
    
     // Se obtiene un Categoria, a partir del id de un categoria
    public Bebida getBebida(Bebida bebida);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Bebida bebida);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Bebida bebida);
}
