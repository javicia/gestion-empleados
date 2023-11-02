package com.gestion.empleados.controller;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gestion.empleados.exception.ResourceNotFoundException;
import com.gestion.empleados.model.Empleado;
import com.gestion.empleados.repository.IEmpleadoRepository;

import ch.qos.logback.core.model.Model;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {

	@Autowired
	private IEmpleadoRepository empleadoRepository;

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
	
	//Método para actualizar empleados
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
		Empleado empleado = empleadoRepository
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No existe el empleado con el ID: " + id));
		empleado.setNombre(detallesEmpleado.getNombre());
		empleado.setApellidos(detallesEmpleado.getApellidos());
		empleado.setEmail(detallesEmpleado.getEmail());
		empleado.setTelefono(detallesEmpleado.getTelefono());
		empleado.setDni(detallesEmpleado.getDni());
		empleado.setFechaNacimiento(detallesEmpleado.getFechaNacimiento());
		empleado.setSueldo(detallesEmpleado.getSueldo());
		empleado.setDireccion(detallesEmpleado.getDireccion());
		empleado.setDepartamento(detallesEmpleado.getDepartamento());
		
		Empleado empleadoActualizado = empleadoRepository.save(empleado);
		return ResponseEntity.ok(empleadoActualizado);
	}
	
	
	//Método para eliminar empleados
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEmplado(@PathVariable Long id){
		Empleado empleado = empleadoRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
		empleadoRepository.delete(empleado);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
		
	}
	


	@GetMapping("/empleados-detalles/{termino}")
	public String buscarEmpleado(@PathVariable String termino, Model model) {
	    String normalizedTermino = Normalizer.normalize(termino, Normalizer.Form.NFD)
	        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
	        .toLowerCase();

	    List<Empleado> empleados = empleadoRepository
	        .findAll()
	        .stream()
	        .filter(empleado -> {
	            String normalizedNombre = Normalizer.normalize(empleado.getNombre(), Normalizer.Form.NFD)
	                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
	                .toLowerCase();

	            String normalizedApellidos = Normalizer.normalize(empleado.getApellidos(), Normalizer.Form.NFD)
	                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
	                .toLowerCase();

	            String normalizedEmail = Normalizer.normalize(empleado.getEmail(), Normalizer.Form.NFD)
	                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
	                .toLowerCase();

	            String normalizedDni = Normalizer.normalize(empleado.getDni(), Normalizer.Form.NFD)
	                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
	                .toLowerCase();

	            return normalizedNombre.contains(normalizedTermino)
	                || normalizedApellidos.contains(normalizedTermino)
	                || normalizedEmail.contains(normalizedTermino)
	                || normalizedDni.contains(normalizedTermino);
	        })
	        .collect(Collectors.toList());

	    return "empleados-detalles"; // Puedes tener una vista llamada "empleados-detalles" para mostrar los detalles del empleado.
	}



	
}



