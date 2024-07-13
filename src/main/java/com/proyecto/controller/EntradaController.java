package com.proyecto.controller;

import com.proyecto.domain.Entrada;
import com.proyecto.service.EntradaService;
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
@RequestMapping("/entrada") //(/categoria/listado)
public class EntradaController {
    @Autowired
    private EntradaService entradaService;
 
    @GetMapping("/listado")
    public String inicio(Model model) {
        var entradas = entradaService.getEntradas(false);
        model.addAttribute("entradas", entradas); //lista de categorias
        model.addAttribute("totalEntradas", entradas.size()); //
        return "/entrada/listado";
    }
    
    @GetMapping("/nuevo")
    public String entradaNuevo(Entrada entrada) {
        return "/entrada/modifica";
    }
 
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    @PostMapping("/guardar")
    public String EntradaGuardar(Entrada entrada,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            entradaService.save(entrada);
            entrada.setImagenE(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "entrada", 
                            entrada.getIdEntrada()));
        }
        entradaService.save(entrada);
        return "redirect:/entrada/listado";
    }
 
    @GetMapping("/eliminar/{Id}")
    public String entradaEliminar(Entrada entrada) {
        entradaService.delete(entrada);
        return "redirect:/entrada/listado";
    }
 
    @GetMapping("/modificar/{Id}")
    public String entradaModificar(Entrada entrada, Model model) {
        entrada = entradaService.getEntrada(entrada);
        model.addAttribute("entrada", entrada);
        return "/entrada/modifica";
    }   
}
