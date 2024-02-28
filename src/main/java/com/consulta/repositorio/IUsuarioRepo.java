package com.consulta.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.User;

import com.consulta.dto.UsuarioDTO;
import com.consulta.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
  	//public User findByUsername(String username);
  	
  	  	
}
