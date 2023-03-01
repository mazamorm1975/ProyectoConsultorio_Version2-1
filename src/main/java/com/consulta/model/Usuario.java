package com.consulta.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	// Cabecera de variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name = "nombreCompleto", nullable = false, length = 70)
	private String nombreCompleto;

	@Column(name = "horaFechaEvento", nullable = true)
	private Date horaFechaEvento;

	@Column(name = "lugarEvento", nullable = false, length = 45)
	private String lugarEvento;

	@Column(name = "statusSeguimiento", nullable = false, length = 45)
	private String statusSeguimiento;

	@Column(name = "folioSeguimiento", nullable = false, length = 40)
	private String folioSeguimiento;

	// Constructor con sobrecarga

	public Usuario() {
	}

	// Getters && Setters

	public String getFolioSeguimiento() {
		return folioSeguimiento;
	}

	public void setFolioSeguimiento(String folioSeguimiento) {
		this.folioSeguimiento = folioSeguimiento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	
	public Date getHoraFechaEvento() {
		return horaFechaEvento;
	}

	public void setHoraFechaEvento(Date horaFechaEvento) {
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

}
