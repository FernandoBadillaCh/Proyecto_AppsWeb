package com.proyecto.controller;


import com.proyecto.service.CategoriaService;
import com.proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ProductoService productoService;

	@GetMapping("/listado")
	public String inicio(Model model) {
		var categorias = categoriaService.getCategorias();
		categorias.forEach(categoria -> {
			var productos = productoService.getProductosCategoria(categoria);
			categoria.setProductos(productos);
		});
		model.addAttribute("categorias", categorias);
		return "producto/listado";
	}




	@GetMapping("/lista/{idCategoria}")
	public String detalle(@PathVariable("idCategoria") Long idCategoria, Model model) {
		var categoria = categoriaService.getCategoria(idCategoria);
		var productos = productoService.getProductosCategoria(categoria);
		model.addAttribute("categoria", categoria);
		model.addAttribute("productos", productos);
		return "/categoria/listado";
	}


}