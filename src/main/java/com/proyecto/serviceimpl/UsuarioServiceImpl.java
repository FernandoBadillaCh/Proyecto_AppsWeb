package com.proyecto.serviceimpl;

import com.proyecto.dao.CategoriaDao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Categoria;
import com.proyecto.domain.Usuario;
import com.proyecto.service.CategoriaService;
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
}
