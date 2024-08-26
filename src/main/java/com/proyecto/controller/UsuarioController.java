package com.proyecto.controller;


import com.proyecto.domain.Rol;

import com.proyecto.domain.Usuario;
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



	@GetMapping("/administrarusuarios")
	public String administrarUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.getUsuarios();

		model.addAttribute("usuarios", usuarios);

		return "/usuario/listado";
	}


	@PostMapping("/register")
	public String registerUser(Usuario usuario, Model model) {

		if (usuario != null) {
			usuario.setRol(Rol.ROLE_USER.name());
		}
		usuarioService.guardar(usuario);
		return "redirect:/usuario/listado";
	}

	@PostMapping("/modifica")
	public String modifica(Usuario usuario, Model model) {

		if (usuario != null) {
			usuario.setRol(Rol.ROLE_USER.name());
		}
		usuarioService.guardar(usuario);
		return "redirect:/usuario/listado";
	}
}
