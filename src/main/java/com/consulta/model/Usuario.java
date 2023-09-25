package com.consulta.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	// Cabecera de variables globales en la clase usuario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column(name = "username", nullable = false, length = 70)
	private String username;

	@Column(name = "password", nullable = false, length = 70)
	private String password;

	@Column(name = "horaFechaEvento", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate horaFechaEvento;

	@Column(name = "lugarEvento", nullable = false, length = 45)
	private String lugarEvento;

	@Column(name = "statusSeguimiento", nullable = false, length = 45)
	private String statusSeguimiento;

	@Column(name = "folioSeguimiento", nullable = false, length = 40)
	private String folioSeguimiento;

	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false)
	private Rol idRol;

	// Constructor con sobrecarga
	public Usuario() {
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password
				+ ", horaFechaEvento=" + horaFechaEvento + ", lugarEvento=" + lugarEvento + ", statusSeguimiento="
				+ statusSeguimiento + ", folioSeguimiento=" + folioSeguimiento + "]";
	}

}
