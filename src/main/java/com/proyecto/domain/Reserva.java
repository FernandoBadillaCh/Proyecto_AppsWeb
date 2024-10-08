package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

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
	private Date fecha;
	private String hora;

	@ManyToOne
	@JoinColumn(name="id_mesa")
	private Mesa mesa;

	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
}
