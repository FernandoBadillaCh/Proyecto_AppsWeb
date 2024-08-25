package com.proyecto.serviceimpl;
import com.proyecto.dao.MesaDao;
import com.proyecto.domain.Mesa;
import com.proyecto.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MesaServiceImpl implements MesaService {

	@Autowired
	private MesaDao mesaDao;

	@Override
	public List<Mesa> obtenerMesas() {
		return mesaDao.findAll();
	}

	@Override
	public Mesa obtenerMesaPorId(Long idMesa) {
		return mesaDao.findByIdMesa(idMesa);
	}

	@Override
	public Mesa guardarMesa(Mesa mesa) {
		return mesaDao.save(mesa);
	}

	@Override
	public void eliminarMesa(Long idMesa) {
		mesaDao.deleteById(idMesa);
	}
}

