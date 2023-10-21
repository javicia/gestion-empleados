package com.gestion.empleados.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.exception.ResourceNotFoundException;
import com.gestion.empleados.model.Empleado;
import com.gestion.empleados.repository.IEmpeadoRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoController {

	@Autowired
	private IEmpeadoRepository empleadoRepository;

	//Método sirve para listar todos los empleados
	@GetMapping("/empleados")
	public List<Empleado> listarTodosLosEmpleados() {
		return empleadoRepository.findAll();
	}

	//Método para poder guardar un empleado
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	//Método para buscar un empleado por id
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
		Empleado empleado = empleadoRepository
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No existe el empleado con el ID: " + id));
		return ResponseEntity.ok(empleado);
	}
	
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
		Empleado empleado = empleadoRepository
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No existe el empleado con el ID: " + id));
		empleado.setNombre(detallesEmpleado.getNombre());
		empleado.setApellidos(detallesEmpleado.getApellidos());
		empleado.setEmail(detallesEmpleado.getEmail());
		
		Empleado empleadoActualizado = empleadoRepository.save(empleado);
		return ResponseEntity.ok(empleado);
	}
}

