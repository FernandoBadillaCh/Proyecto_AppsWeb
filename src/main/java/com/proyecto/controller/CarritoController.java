package com.proyecto.controller;

import com.proyecto.domain.Item;
import com.proyecto.domain.Producto;
import com.proyecto.domain.Usuario;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.ItemService;
import com.proyecto.service.ProductoService;
import com.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.security.Principal;

@Controller
public class CarritoController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ProductoService productoService;

    @Autowired
	private CategoriaService categoriaService;
    @Autowired
	private UsuarioService usuarioService;



    @GetMapping("/")
    private String listado(Model model, @AuthenticationPrincipal Authentication authentication) {

        var categorias = categoriaService.getCategorias();
        var productos = productoService.getProductos();
        model.addAttribute("categorias", categorias);
        model.addAttribute("productos", productos);

        return "index";
    }

//Para ver el carrito

    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.gets();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal",
                carritoTotalVenta);
        return "/carrito/listado";
    }
//Para Agregar un producto al carrito

    @GetMapping("/carrito/agregar/{idProducto}")
    public ModelAndView agregarItem(Model model, Item item) {
        Item item2 = itemService.get(item);

        if (item2 == null) {
            Producto producto = productoService.getProducto(item);
            item2 = new Item(producto);

        }
        itemService.save(item2);
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);

        return new ModelAndView("redirect:/producto/listado");
    }
    //Para mofificar un producto del carrito
    @GetMapping("/carrito/modificar/{idProducto}")
    public String modificarItem(Item item, Model model) {
        item = itemService.get(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }

    //Para eliminar un elemento del carrito
    @GetMapping("/carrito/eliminar/{idProducto}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    //Para actualizar un producto del carrito (cantidad)
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }
}
