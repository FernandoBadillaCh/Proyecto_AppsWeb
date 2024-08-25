package com.proyecto.controller;

import com.proyecto.domain.Reserva;
import com.proyecto.domain.Usuario;
import com.proyecto.service.MesaService;
import com.proyecto.service.ReservaService;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@Autowired
	private MesaService mesaService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/nueva")
	public String mostrarFormularioReserva(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		if (userDetails == null) {
			return "redirect:/login";
		}

		Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());

		model.addAttribute("mesas", mesaService.obtenerMesas());
		model.addAttribute("usuario", usuario);
		return "reserva/listado";
	}

	@PostMapping("/guardar")
	public String guardarReserva(Reserva reserva, @AuthenticationPrincipal UserDetails userDetails) {
		if (userDetails == null) {
			return "redirect:/login";
		}

		Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());
		reserva.setUsuario(usuario);

		reservaService.guardarReserva(reserva);
		return "redirect:/reservas/nueva";
	}
}