package com.consulta.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.consulta.model.Usuario;
import com.consulta.repositorio.IUsuarioRepo;
import com.consulta.security.ErroresDetectados;
import com.consulta.security.UsuarioNoEncontrado;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioRepo usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = usuarioRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsuarioNoEncontrado("No se encontro el usuario ingresado");
		}
		return user;
	}

}
