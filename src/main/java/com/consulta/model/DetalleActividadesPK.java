package com.consulta.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DetalleActividadesPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="id_rol", nullable = false)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable = false)
	private Usuario usuario;

	@Override
	public int hashCode() {
		return Objects.hash(rol, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleActividadesPK other = (DetalleActividadesPK) obj;
		return Objects.equals(rol, other.rol) && Objects.equals(usuario, other.usuario);
	}
	
	
}
