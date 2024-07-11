package com.proyecto.controller;

import com.proyecto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/")
	public String inicio(Model model) {
		var categorias = categoriaService.getCategorias();
		model.addAttribute("categorias", categorias);
		return "index";
	}
}
