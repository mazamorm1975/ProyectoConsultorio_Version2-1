package com.consulta.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {

	@Id
	private Integer idRol;
	
	@Column(name="tipo")
	private String tipo;

	@Column(name="descripcion")
	private String descripcion;

		
	public Rol() {
		super();
	}

	
	public Rol(Integer idRol, String tipo, String descripcion) {
		super();
		this.idRol = idRol;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(idRol);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(idRol, other.idRol);
	}


	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", tipo=" + tipo + ", descripcion=" + descripcion + "]";
	}
	
	

}
