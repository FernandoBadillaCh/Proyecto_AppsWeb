package com.proyecto.controller;

import com.proyecto.domain.Rol;
import com.proyecto.service.RolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var roles = rolService.getRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("totalRoles", roles.size());
        return "/rol/listado";
    }

    @GetMapping("/nuevo")
    public String rolNuevo(Rol rol) {
        return "/rol/modifica";
    }

    @PostMapping("/guardar")
    public String rolGuardar(Rol rol) {
        rolService.save(rol);
        return "redirect:/rol/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String rolEliminar(Rol rol) {
        rolService.delete(rol);
        return "redirect:/rol/listado";
    }

    @GetMapping("/modificar/{id}")
    public String rolModificar(Rol rol, Model model) {
        rol = rolService.getRol(rol);
        model.addAttribute("rol", rol);
        return "/rol/modifica";
    }
}