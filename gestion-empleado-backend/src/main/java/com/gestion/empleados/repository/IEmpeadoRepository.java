package com.gestion.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.model.Empleado;

@Repository
public interface IEmpeadoRepository extends JpaRepository<Empleado, Long>{

}
