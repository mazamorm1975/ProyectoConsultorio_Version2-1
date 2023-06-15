package com.consulta.security;

import java.time.LocalDate;

public class ErroresDetectados {

	private LocalDate tiempo;
	private String detallesError;
	private String mensaje;
	
	
	//Constructor
	public ErroresDetectados(LocalDate tiempo, String detallesError, String mensaje) {
		super();
		this.tiempo = tiempo;
		this.detallesError = detallesError;
		this.mensaje = mensaje;
	}
	
	//Getters and Setters
	
	public LocalDate getTiempo() {
		return tiempo;
	}
	public void setTiempo(LocalDate tiempo) {
		this.tiempo = tiempo;
	}
	public String getDetallesError() {
		return detallesError;
	}
	public void setDetallesError(String detallesError) {
		this.detallesError = detallesError;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
