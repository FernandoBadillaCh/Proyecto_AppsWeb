package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Entity
@Table(name="Roles")
@NoArgsConstructor
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Long idRol;
	private String nombre;
}
