package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name="Reservas")
@NoArgsConstructor
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reserva")
	private Long idReserva;
	private Long idUsuario;
	private Date fecha;
	private Time hora;
	private Long cantidadPersonas;
}
