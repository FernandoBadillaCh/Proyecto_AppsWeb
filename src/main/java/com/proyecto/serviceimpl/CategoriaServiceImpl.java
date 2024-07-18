package com.proyecto.serviceimpl;

import com.proyecto.dao.CategoriaDao;
import com.proyecto.domain.Categoria;
import com.proyecto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	@Transactional(readOnly=true)
	public List<Categoria> getCategorias() {
		return categoriaDao.findAll();
	}

	@Override
	public Categoria getCategoria(Long idCategoria) {
		return categoriaDao.findById(idCategoria).orElse(null);
	}
}
