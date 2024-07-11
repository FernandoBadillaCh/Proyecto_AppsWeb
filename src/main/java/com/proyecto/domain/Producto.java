package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Entity
@Table(name="Productos")
@NoArgsConstructor
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Long idProducto;
	private String nombre;
	private String descripcion;
	private double precio;
	private String rutaImagen;
	private Integer idCategoria;
}
