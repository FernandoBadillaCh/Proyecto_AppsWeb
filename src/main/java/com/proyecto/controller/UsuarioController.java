package com.proyecto.controller;


import com.proyecto.domain.Categoria;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.ProductoService;
import com.proyecto.service.RolService;
import com.proyecto.service.UsuarioService;
import com.proyecto.serviceimpl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;



	@PostMapping("/register")
	public String registerUser(Usuario usuario, Model model) {

		Rol rol = rolService.findById(1L);
		if (rol != null) {
			usuario.setRol(rol);
		}
		usuarioService.guardar(usuario);
		return "index";
	}
}
