package com.proyecto.controller;


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
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private FirebaseStorageServiceImpl firebaseStorageService;

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

	@GetMapping("/{idProducto}")
	public String detalle(@PathVariable("idProducto") Long idProducto, Model model) {
		var producto = productoService.getProducto(idProducto);
		model.addAttribute("producto", producto);
		return "/producto/detalle";
	}

	@GetMapping("/eliminar/{idProducto}")
	public String productoEliminar(@PathVariable("idProducto") Long idProducto, Model model) {
		productoService.delete(idProducto);
		return "redirect:/producto/administrarproductos";
	}

	@GetMapping("/administrarproductos")
	public String productoNuevo(Model model) {
		var categorias = categoriaService.getCategorias();
		categorias.forEach(categoria -> {
			var productos = productoService.getProductosCategoria(categoria);
			categoria.setProductos(productos);
		});
		model.addAttribute("categorias", categorias);
		return "/producto/modifica";
	}

	@PostMapping("/guardar")
	public String categoriaGuardar(Producto producto,
	                               @RequestParam("imagenFile") MultipartFile imagenFile) {
		if (!imagenFile.isEmpty()) {
			productoService.guardar(producto);
			producto.setRutaImagen(
					firebaseStorageService.cargaImagen(
							imagenFile,
							"categoria",
							producto.getIdProducto()));
		}
		productoService.guardar(producto);
		return "redirect:/producto/administrarproductos";
	}

}
