package com.proyecto.dao;

import com.proyecto.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoDao extends JpaRepository<Producto, Long>{

	List<Producto> findByCategoriaIdCategoria(Long idCategoria);
}
