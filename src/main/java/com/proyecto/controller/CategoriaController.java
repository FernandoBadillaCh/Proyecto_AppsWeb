package com.proyecto.controller;


import com.proyecto.domain.Categoria;
import com.proyecto.domain.Producto;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.ProductoService;
import com.proyecto.serviceimpl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private FirebaseStorageServiceImpl firebaseStorageService;

	@GetMapping("/listado")
	public String inicio(Model model) {
		var categorias = categoriaService.getCategorias();
		model.addAttribute("categorias", categorias);
		return "categoria/listadocategorias";
	}

	@GetMapping("/lista/{idCategoria}")
	public String detalle(@PathVariable("idCategoria") Long idCategoria, Model model) {
		var categoria = categoriaService.getCategoria(idCategoria);
		var productos = productoService.getProductosCategoria(categoria);
		model.addAttribute("categoria", categoria);
		model.addAttribute("productos", productos);
		return "categoria/listado";
	}

	@GetMapping("/administrarcategorias")
	public String categoriaNueva(Model model) {
		var categorias = categoriaService.getCategorias();
		model.addAttribute("categorias", categorias);
		return "categoria/modifica";
	}

	@PostMapping("/guardar")
	public String categoriaGuardar(Categoria categoria,
	                               @RequestParam("imagenFile") MultipartFile imagenFile) {
		if (!imagenFile.isEmpty()) {
			categoriaService.guardar(categoria);
			categoria.setRutaImagen(
					firebaseStorageService.cargaImagen(
							imagenFile,
							"categoria",
							categoria.getIdCategoria()));
		}
		categoriaService.guardar(categoria);
		return "redirect:/categoria/administrarcategorias";
	}


	@GetMapping("/eliminar/{idCategoria}")
	public String categoriaEliminar(@PathVariable("idCategoria") Long idCategoria, Model model) {
		categoriaService.delete(idCategoria);
		return "redirect:/categoria/administrarcategorias";
	}

}
