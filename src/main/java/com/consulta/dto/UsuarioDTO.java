package com.consulta.dto;

import java.time.LocalDate;
import java.util.List;

import com.consulta.model.Rol;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Id;

public class UsuarioDTO {

	@Id
	private Integer idUsuario;	
	private String username;
	private String password;
	/*
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate horaFechaEvento;
	private String lugarEvento;
	private String statusSeguimiento;
	private String folioSeguimiento;
	private Rol idRol;

	
	public UsuarioDTO(Integer idUsuario, String username, String password, LocalDate horaFechaEvento,
			String lugarEvento, String statusSeguimiento, String folioSeguimiento, Rol idRol) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.horaFechaEvento = horaFechaEvento;
		this.lugarEvento = lugarEvento;
		this.statusSeguimiento = statusSeguimiento;
		this.folioSeguimiento = folioSeguimiento;
		this.idRol = idRol;

	}



	public UsuarioDTO() {
		super();
	}
*/


	public Integer getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


/*
	public LocalDate getHoraFechaEvento() {
		return horaFechaEvento;
	}



	public void setHoraFechaEvento(LocalDate horaFechaEvento) {
		this.horaFechaEvento = horaFechaEvento;
	}



	public String getLugarEvento() {
		return lugarEvento;
	}



	public void setLugarEvento(String lugarEvento) {
		this.lugarEvento = lugarEvento;
	}



	public String getStatusSeguimiento() {
		return statusSeguimiento;
	}



	public void setStatusSeguimiento(String statusSeguimiento) {
		this.statusSeguimiento = statusSeguimiento;
	}



	public String getFolioSeguimiento() {
		return folioSeguimiento;
	}



	public void setFolioSeguimiento(String folioSeguimiento) {
		this.folioSeguimiento = folioSeguimiento;
	}



	public Rol getIdRol() {
		return idRol;
	}



	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}
*/
}
