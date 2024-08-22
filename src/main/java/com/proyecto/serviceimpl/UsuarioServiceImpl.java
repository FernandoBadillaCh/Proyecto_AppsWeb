package com.proyecto.serviceimpl;

import com.proyecto.dao.RolDao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private RolDao rolDao;

	@Override
	@Transactional
	public List<Usuario> getUsuarios() {
		return usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario getUsuario(Usuario usuario) {
		return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
	}


	@Override
	@Transactional
	public Usuario getUsuarioPorCorreo(String correo) {
		return usuarioDao.findByCorreo(correo);
	}

	@Override
	@Transactional
	public Usuario getUsuarioPorCorreoYClave(String correo, String clave) {
		return usuarioDao.findByCorreoAndClave(correo, clave);
	}

	@Override
	@Transactional
	public boolean existeUsuarioPorCorreo(String correo) {
		return usuarioDao.existsByCorreo(correo);
	}

	@Override
	public void save(Usuario usuario) {
		if (usuario.getRol() == null) {
			Rol rol = rolDao.findByNombre("ROLE_USER");
			usuario.setRol(rol);
		}
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Usuario usuario) {
		usuarioDao.delete(usuario);
	}
}
