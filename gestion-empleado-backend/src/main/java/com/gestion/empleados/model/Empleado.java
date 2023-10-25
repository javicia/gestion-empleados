package com.gestion.empleados.model;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;

	@Column(name = "apellidos", length = 60, nullable = false)
	private String apellidos;

	@Column(name = "email", length = 60, nullable = false, unique = true)
	private String email;
	
	@Column(name="telefono", length = 15)
	private int telefono;
	
	@Column(name="dni", length = 12, nullable = false, unique = true)
	private String dni;
	
	@Column(name="fechaNacimiento", length = 12, nullable = false, unique = true)
	private String fechaNacimiento;
	
	@Column(name="sueldo", length = 12, nullable = false, unique = true)
	private Double sueldo;
	
	@Column(name="dirección", length = 100, nullable = false, unique = true)
	private String direccion;
	
	 
    @Column(name = "departamento", length = 100, nullable = false, unique = true)
    private String departamento;

	public Empleado() {
	}

	
	

	public Empleado(long id, String nombre, String apellidos, String email, int telefono, String dni,
			String fechaNacimiento, Double sueldo, String direccion, String departamento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldo = sueldo;
		this.direccion = direccion;
		this.departamento = departamento;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public int getTelefono() {
		return telefono;
	}




	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}




	public String getFechaNacimiento() {
		return fechaNacimiento;
	}




	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




	public Double getSueldo() {
		return sueldo;
	}




	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getDepartamento() {
		return departamento;
	}




	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}




	
}
