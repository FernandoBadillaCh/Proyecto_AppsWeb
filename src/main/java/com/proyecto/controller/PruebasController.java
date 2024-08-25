package com.proyecto.controller;

import com.proyecto.domain.Categoria;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/pruebas")
public class PruebasController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos();
        var categorias = categoriaService.getCategorias();
        model.addAttribute("productos", productos); //lista de productos
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalProductos", productos.size()); //
        return "/pruebas/listado";
    }
    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Long categoria) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        var categorias = categoriaService.getCategorias();
        model.addAttribute("productos", productos); //lista de productos
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalProductos", productos.size()); //
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos); //lista de productos
        return "/pruebas/listado2";
    }
    
     @PostMapping("/query1")
    public String consultaQuery1(@RequestParam(value="precioInf") double precioInf, @RequestParam(value="precioSup") double precioSup, Model model){
        var productos = productoService.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }
    
}
