package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="Categorias")
@NoArgsConstructor
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private Long idCategoria;

	private String nombre;
	private String rutaImagen;

	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;
}
