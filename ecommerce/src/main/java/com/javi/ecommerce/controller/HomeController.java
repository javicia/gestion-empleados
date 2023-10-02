package com.javi.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javi.ecommerce.model.DetalleOrden;
import com.javi.ecommerce.model.Orden;
import com.javi.ecommerce.model.Producto;
import com.javi.ecommerce.service.ProductoService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	//variable para imprimir en consola en vez de print
	private final Logger log= LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ProductoService productoService;
	
	//Almacenamos los detalles de la orden
	List<DetalleOrden> detalles= new ArrayList<DetalleOrden>();
	
	//Almacena los datos de la orden
	Orden orden = new Orden();
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return"usuario/home";	}
	
	@GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
		log.info("Id producto enviado como parámetro {}", id);
		Producto producto = new Producto();
		Optional<Producto> productoOptional = productoService.get(id);
		producto = productoOptional.get();
		
		model.addAttribute("producto", producto);
		return "usuario/productoHome";
	}
	
	@PostMapping("/cart")
	public String addCard(@RequestParam Integer id, @RequestParam Integer cantidad) {
		DetalleOrden detalleOrden= new DetalleOrden();
		Producto producto = new Producto();
		double sumaTotal = 0;
		
		Optional<Producto> optionalProducto = productoService.get(id);
		log.info("Producto añadido: {}", optionalProducto.get());
		log.info("Cantidad: {}", cantidad);
		
		return"usuario/carrito";
	}
	
	
}
