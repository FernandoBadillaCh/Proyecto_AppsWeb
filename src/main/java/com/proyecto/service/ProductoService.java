package com.proyecto.service;


import com.proyecto.domain.Categoria;
import com.proyecto.domain.Producto;

import java.util.List;

public interface ProductoService {

	public List<Producto> getProductos();

	public List<Producto> getProductosCategoria(Categoria categoria);
}
