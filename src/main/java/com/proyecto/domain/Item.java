package com.proyecto.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class Item extends Producto{
 private int cantidad; 
    public Item() {
    }
    public Item(Producto producto){
        super.setIdProducto(producto.getIdProducto());
        super.setNombre(producto.getNombre());
        super.setDescripcion(producto.getDescripcion());
        super.setPrecio(producto.getPrecio());
        super.setRutaImagen(producto.getRutaImagen());
        this.cantidad = 0;
    }
}
