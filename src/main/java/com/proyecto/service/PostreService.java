package com.proyecto.service;

import com.proyecto.domain.Postre;
import java.util.List;

public interface PostreService {
     public List<Postre> getPostres(boolean activos);
    
     // Se obtiene un Categoria, a partir del id de un categoria
    public Postre getPostre(Postre postre);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Postre postre);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Postre postre);
}
