
package com.proyecto.controller;

import com.proyecto.domain.PlatoFuerte;
import com.proyecto.service.PlatoFuerteService;
import com.proyecto.serviceimpl.FirebaseStorageServiceImpl;

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
@RequestMapping("/platoFuerte") //(/categoria/listado)
public class PlatoFuerteController {
    @Autowired
    private PlatoFuerteService platoFuerteService;
 
    @GetMapping("/listado")
    public String inicio(Model model) {
        var platosFuertes = platoFuerteService.getPlatosFuertes(false);
        model.addAttribute("platosFuertes", platosFuertes); //lista de categorias
        model.addAttribute("totalPlatosFuertes", platosFuertes.size()); //
        return "/platoFuerte/listado";
    }
    
    @GetMapping("/nuevo")
    public String platoFuerteNuevo(PlatoFuerte platoFuerte) {
        return "/platoFuerte/modifica";
    }
 
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    @PostMapping("/guardar")
    public String PlatoFuerteGuardar(PlatoFuerte platoFuerte,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            platoFuerteService.save(platoFuerte);
            platoFuerte.setImagenP(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "platoFuerte", 
                            platoFuerte.getIdPlatoFuerte()));
        }
        platoFuerteService.save(platoFuerte);
        return "redirect:/platoFuerte/listado";
    }
 
    @GetMapping("/eliminar/{Id}")
    public String platoFuerteEliminar(PlatoFuerte platoFuerte) {
        platoFuerteService.delete(platoFuerte);
        return "redirect:/platoFuerte/listado";
    }
 
    @GetMapping("/modificar/{Id}")
    public String platoFuerteModificar(PlatoFuerte platoFuerte, Model model) {
        platoFuerte = platoFuerteService.PlatoFuerte(platoFuerte);
        model.addAttribute("platoFuerte", platoFuerte);
        return "/platoFuerte/modifica";
    }   
}
