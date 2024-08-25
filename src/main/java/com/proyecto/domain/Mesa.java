package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name="Mesas")
@NoArgsConstructor
public class Mesa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_mesa")
	private Long idMesa;
	private String nombre;

	@OneToMany(mappedBy = "mesa")
	private List<Reserva> reservas;

}
