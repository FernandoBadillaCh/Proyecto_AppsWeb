package com.proyecto.controller;

import com.proyecto.domain.Postre;
import com.proyecto.service.PostreService;

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
@RequestMapping("/postre") //(/categoria/listado)
public class PostreController {
    @Autowired
    private PostreService postreService;
 
    @GetMapping("/listado")
    public String inicio(Model model) {
        var postres = postreService.getPostres(false);
        model.addAttribute("postres", postres); //lista de categorias
        model.addAttribute("totalPostres", postres.size()); //
        return "/postre/listado";
    }
    
    @GetMapping("/nuevo")
    public String postreNuevo(Postre postre) {
        return "/postre/modifica";
    }
 
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    @PostMapping("/guardar")
    public String PostreGuardar(Postre postre,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            postreService.save(postre);
            postre.setImagenD(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "postre", 
                            postre.getIdPostre()));
        }
        postreService.save(postre);
        return "redirect:/postre/listado";
    }
 
    @GetMapping("/eliminar/{Id}")
    public String postreEliminar(Postre postre) {
        postreService.delete(postre);
        return "redirect:/postre/listado";
    }
 
    @GetMapping("/modificar/{Id}")
    public String postreModificar(Postre postre, Model model) {
        postre = postreService.getPostre(postre);
        model.addAttribute("postre", postre);
        return "/postre/modifica";
    }   
}
