package com.proyecto.service;

import com.proyecto.domain.Categoria;
import com.proyecto.domain.Producto;

import java.util.List;

public interface CategoriaService {

	public List<Categoria> getCategorias();

	public Categoria getCategoria(Long idCategoria);

	public Categoria delete(Long idProducto);

	public void guardar(Categoria categoria);
}
