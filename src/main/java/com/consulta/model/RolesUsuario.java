package com.consulta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="RolesUsuario")
public class RolesUsuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRolUsuario;
		
	@ManyToOne
	@JoinColumn(name="id_rol", nullable = false)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable = false)
	private Usuario usuario;
	
	@Column(name="descripcion")
	private String descripcion;
	
	
}
