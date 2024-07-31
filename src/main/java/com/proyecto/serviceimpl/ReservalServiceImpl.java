package com.proyecto.serviceimpl;

import com.proyecto.dao.ReservaDao;
import com.proyecto.dao.RolDao;
import com.proyecto.domain.Reserva;
import com.proyecto.domain.Rol;
import com.proyecto.service.ReservaService;
import com.proyecto.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservalServiceImpl implements ReservaService {

	@Autowired
	private ReservaDao reservaDao;

	@Override
	@Transactional(readOnly=true)
	public List<Reserva> getReservas() {
		return reservaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Reserva getReserva(Long idReserva) {
		return reservaDao.findById(idReserva).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idReserva) {
		reservaDao.deleteById(idReserva);
	}

	@Override
	@Transactional
	public void guardar(Reserva reserva) {
		reservaDao.save(reserva);
	}
}

