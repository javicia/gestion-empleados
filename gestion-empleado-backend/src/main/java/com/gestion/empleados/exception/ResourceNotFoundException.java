package com.gestion.empleados.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	@SuppressWarnings("unused")
	private static final long serialVersionId = 1L;
	
	public ResourceNotFoundException(String menssage) {
		super(menssage);
	}
}
