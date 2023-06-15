package com.consulta.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UsuarioNoEncontrado extends RuntimeException {

	public UsuarioNoEncontrado(String mensaje) {
		
		super(mensaje);
	}
}
