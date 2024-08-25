package com.proyecto.service;


import com.proyecto.dao.ReservaDao;
import com.proyecto.domain.Reserva;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReservaService {


	@Transactional
	public Reserva guardarReserva(Reserva reserva);

	public Reserva obtenerReservaPorId(Long id);

	public List<Reserva> obtenerReservas();


}
