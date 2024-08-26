package com.proyecto.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends Producto {
	private int cantidad;

	public Item() {
		super();
	}

	public Item(Producto producto) {
		super();
		this.setIdProducto(producto.getIdProducto());
		this.setNombre(producto.getNombre());
		this.setDescripcion(producto.getDescripcion());
		this.setPrecio(producto.getPrecio());
		this.setRutaImagen(producto.getRutaImagen());
		this.cantidad = 0;
	}
}

