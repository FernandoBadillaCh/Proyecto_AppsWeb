package com.proyecto.serviceimpl;

import com.proyecto.dao.ReservaDao;
import com.proyecto.domain.Reserva;
import com.proyecto.service.ReservaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaDao reservaDao;

	@Transactional
	public Reserva guardarReserva(Reserva reserva) {
		return reservaDao.save(reserva);
	}

	public Reserva obtenerReservaPorId(Long id) {
		return reservaDao.findById(id).orElse(null);
	}

	public List<Reserva> obtenerReservas() {
		return reservaDao.findAll();
	}
}
