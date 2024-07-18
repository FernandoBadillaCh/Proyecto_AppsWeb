package com.proyecto.dao;

import com.proyecto.domain.Categoria;
import com.proyecto.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaDao  extends JpaRepository<Categoria, Long> {

	List<Producto> findByIdCategoria(Long idCategoria);
}
