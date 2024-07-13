
package com.proyecto.controller;

import com.proyecto.domain.Bebida;
import com.proyecto.service.BebidaService;
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
@RequestMapping("/bebida") //(/categoria/listado)
public class BebidaController {
    @Autowired
    private BebidaService bebidaService;
 
    @GetMapping("/listado")
    public String inicio(Model model) {
        var bebidas = bebidaService.getBebidas(false);
        model.addAttribute("bebidas", bebidas); //lista de categorias
        model.addAttribute("totalBebidas", bebidas.size()); //
        return "/bebida/listado";
    }
    
    @GetMapping("/nuevo")
    public String bebidaNuevo(Bebida bebida) {
        return "/bebida/modifica";
    }
 
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    @PostMapping("/guardar")
    public String BebidaGuardar(Bebida bebida,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            bebidaService.save(bebida);
            bebida.setImagenB(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "bebida", 
                            bebida.getIdBebida()));
        }
        bebidaService.save(bebida);
        return "redirect:/bebida/listado";
    }
 
    @GetMapping("/eliminar/{Id}")
    public String bebidaEliminar(Bebida bebida) {
        bebidaService.delete(bebida);
        return "redirect:/bebida/listado";
    }
 
    @GetMapping("/modificar/{Id}")
    public String bebidaModificar(Bebida bebida, Model model) {
        bebida = bebidaService.getBebida(bebida);
        model.addAttribute("bebida", bebida);
        return "/bebida/modifica";
    }   
}
