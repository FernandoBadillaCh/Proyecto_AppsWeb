package com.proyecto.service;

import com.proyecto.domain.Reserva;
import com.proyecto.domain.Rol;

import java.util.List;

public interface ReservaService {

	public List<Reserva> getReservas();

	public Reserva getReserva(Long idReserva);

	public void delete(Long idReserva);

	public void guardar(Reserva reserva);
}
