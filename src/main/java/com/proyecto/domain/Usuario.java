package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Entity
@Table(name="Usuarios")
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long idUsuario;
	private String username;
	private String nombre;
	private String correo;
	private String clave;
	private String direccion;
	private String telefono;
	private boolean activo;

	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;

	public Usuario(String username) {
		this.username = username;
	}


}
