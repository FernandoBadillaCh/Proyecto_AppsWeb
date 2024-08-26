package com.proyecto.serviceimpl;

import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> getUsuarios() {
		return usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario getUsuario(Long idUsuario) {
		return usuarioDao.findById(idUsuario).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long idUsuario) {
		usuarioDao.deleteById(idUsuario);
	}

	@Override
	@Transactional
	public void guardar(Usuario usuario) {
		usuarioDao.save(usuario);
	}


	@Override
	@jakarta.transaction.Transactional()
	public Usuario getUsuario(Usuario usuario) {
		return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
	}
	@Override
	@jakarta.transaction.Transactional()
	public Usuario getUsuarioPorUsername(String username) {
		return usuarioDao.findByUsername(username);
	}
	@Override
	@jakarta.transaction.Transactional()
	public Usuario getUsuarioPorUsernameYClave(String username, String password) {
		return usuarioDao.findByUsernameAndClave(username, password);
	}
	@Override
	@jakarta.transaction.Transactional()
	public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
		return usuarioDao.findByUsernameOrCorreo(username, correo);
	}
	@Override
	@jakarta.transaction.Transactional()
	public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
		return usuarioDao.existsByUsernameOrCorreo(username, correo);
	}
	@Override
	@jakarta.transaction.Transactional
	public void save(Usuario usuario, boolean crearRolUser) {
		if (crearRolUser) {
			usuario.setRol(Rol.ROLE_USER.name());
		}
		usuario=usuarioDao.save(usuario);
	}


}
