package com.proyecto.serviceimpl;

import com.proyecto.dao.RolDao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolDao rolDao;

	@Override
	@Transactional(readOnly=true)
	public List<Rol> getRoles() {
		return rolDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Rol getRol(Long idRol) {
		return rolDao.findById(idRol).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idRol) {
		rolDao.deleteById(idRol);
	}

	@Override
	@Transactional
	public void guardar(Rol rol) {
		rolDao.save(rol);
	}

	public Rol findById(Long id) {
		return rolDao.findById(id).orElse(null);
	}
}

