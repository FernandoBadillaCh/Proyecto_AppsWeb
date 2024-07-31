package com.proyecto.serviceimpl;

import com.proyecto.dao.CategoriaDao;
import com.proyecto.domain.Categoria;
import com.proyecto.domain.Producto;
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
	public List<Categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

	@Override
	public Categoria getCategoria(Categoria categoria) {
		return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
	}

	@Override
	public void delete(Categoria categoria) {
		categoriaDao.delete(categoria); //Eliminar el id (categoria)
	}

	@Override
	@Transactional
	public void guardar(Categoria categoria) {
		categoriaDao.save(categoria);
	}
}
