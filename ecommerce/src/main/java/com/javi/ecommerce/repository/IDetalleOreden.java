package com.javi.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javi.ecommerce.model.DetalleOrden;

@Repository
public interface IDetalleOreden extends JpaRepository<DetalleOrden, Integer>{

}
