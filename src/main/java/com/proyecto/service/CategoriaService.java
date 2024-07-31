package com.proyecto.service;

import com.proyecto.domain.Categoria;
import com.proyecto.domain.Producto;

import java.util.List;

public interface CategoriaService {

	public List<Categoria> getCategorias(boolean activos);

	public Categoria getCategoria(Categoria idCategoria);

	public void delete(Categoria idProducto);

	public void guardar(Categoria categoria);
}
