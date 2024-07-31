package com.proyecto.service;


import com.proyecto.domain.Categoria;
import com.proyecto.domain.Producto;

import java.util.List;

public interface ProductoService {

	public List<Producto> getProductos(boolean activos);

	public List<Producto> getProductosCategoria(Categoria categoria);

	public Producto getProducto(Long idProducto);

	public Producto delete(Long idProducto);

	public void guardar(Producto producto);
        
        public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
