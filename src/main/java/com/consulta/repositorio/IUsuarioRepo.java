package com.consulta.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.consulta.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
  	
}
