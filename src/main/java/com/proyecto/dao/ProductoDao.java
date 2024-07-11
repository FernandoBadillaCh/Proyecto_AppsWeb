package com.proyecto.dao;

import com.proyecto.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long>{
}
