package com.proyecto.controller;


import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;

	@GetMapping("/administrarusuarios")
	public String administrarUsuarios(Model model) {
		// Obtener todos los usuarios sin paginación
		List<Usuario> usuarios = usuarioService.getUsuarios();
		var roles = rolService.getRoles();

		// Agregar los usuarios y roles al modelo
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("roles", roles);

		return "/usuario/listado";
	}



	@PostMapping("/register")
	public String registerUser(Usuario usuario, Model model) {

		Rol rol = rolService.findById(1L);
		if (rol != null) {
			usuario.setRol(rol);
		}
		usuarioService.save(usuario);
		return "index";
	}

	@PostMapping("/modifica")
	public String modifica(Usuario usuario, Model model) {

		Rol rol = rolService.findById(1L);
		if (rol != null) {
			usuario.setRol(rol);
		}
		usuarioService.save(usuario);
		return "redirect:/administrarusuarios";
	}
}
