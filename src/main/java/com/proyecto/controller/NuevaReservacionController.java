
package com.proyecto.controller;

import com.proyecto.service.CategoriaService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/NuevaReservacion") 
public class NuevaReservacionController {

    @Autowired
    private CategoriaService CategoriaService;

    @GetMapping("/NuevaReservacion")
    public String inicio(Model model) {
       // var categorias = CategoriaService.getCategorias(false);
       // model.addAttribute("categorias", categorias);
       // model.addAttribute("totalCategorias", categorias.size());
        return "/NuevaReservacion/NuevaReservacion";
    }
    
    @PostMapping("/guardar")
    public String reservaslistadoGuardar(){        
      
        return "redirect:/NuevaReservacion/NuevaReservacion";
    }
 
}