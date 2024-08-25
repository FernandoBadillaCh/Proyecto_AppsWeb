//package com.proyecto.controller;
//
//import com.proyecto.service.CategoriaService;
//import com.proyecto.service.ProductoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/")
//public class indexController {
//
//	@Autowired
//	private CategoriaService categoriaService;
//
//	@Autowired
//	private ProductoService productoService;
//
//	@GetMapping("/")
//	public String inicio(Model model) {
//		var categorias = categoriaService.getCategorias();
//		var productos = productoService.getProductos();
//		model.addAttribute("categorias", categorias);
//		model.addAttribute("productos", productos);
//		return "index/";
//	}
//}
