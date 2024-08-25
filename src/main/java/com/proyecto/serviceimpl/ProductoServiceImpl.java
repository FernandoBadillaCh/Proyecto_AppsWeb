package com.proyecto.serviceimpl;

import com.proyecto.dao.ProductoDao;

import com.proyecto.domain.Categoria;
import com.proyecto.domain.Item;
import com.proyecto.domain.Producto;
import com.proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Override
	public List<Producto> getProductos() {
		return productoDao.findAll();
	}

	@Override
	public List<Producto> getProductosCategoria(Categoria categoria) {
		return productoDao.findByCategoriaIdCategoria(categoria.getIdCategoria());
	}

	@Override
	public Producto getProducto(Producto producto) {
		return productoDao.findById(producto.getIdProducto()).orElse(null);
	}

	@Override
	public Producto delete(Long idProducto) {
		productoDao.deleteById(idProducto);
		return null;
	}

	@Override
	@Transactional
	public void guardar(Producto producto) {
		productoDao.save(producto);
	}
    
    @Override
    @Transactional (readOnly = true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup){
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
        
    }
    

}
