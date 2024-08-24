package com.proyecto.controller;


import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;


	@GetMapping("/administrarusuarios")
	public String administrarUsuarios(Model model,
	                                  @RequestParam(defaultValue = "0") int page) {
		Pageable pageable = PageRequest.of(page, 15);
		Page<Usuario> usuariosPage = usuarioService.getUsuarios(pageable);
		var roles = rolService.getRoles();

		model.addAttribute("usuariosPage", usuariosPage);
		model.addAttribute("roles", roles);
		model.addAttribute("currentPage", page);

		return "/usuario/listado";
	}


	@PostMapping("/register")
	public String registerUser(Usuario usuario, Model model) {

		Rol rol = rolService.findById(1L);
		if (rol != null) {
			usuario.setRol(rol);
		}
		usuarioService.guardar(usuario);
		return "index";
	}

	@PostMapping("/modifica")
	public String modifica(Usuario usuario, Model model) {

		Rol rol = rolService.findById(1L);
		if (rol != null) {
			usuario.setRol(rol);
		}
		usuarioService.guardar(usuario);
		return "redirect:/administrarusuarios";
	}
}
