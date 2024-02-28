package com.consulta;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.assertj.core.api.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.consulta.model.Rol;
import com.consulta.model.Usuario;
import com.consulta.repositorio.IUsuarioRepo;
import com.consulta.service.implementation.UsuarioServiceImpl;


@SpringBootTest
class ProyectoConsultorioVersion21ApplicationTests {

	@Test
	void metodoRegistrar() throws Exception {
						
		
		UsuarioServiceImpl userImpl = mock(UsuarioServiceImpl.class);
		
		//Se simula el cuerpo del JSON de tipo Usuario
		Usuario usuario = new Usuario();
		usuario.setUsername("Mario");
		usuario.setFolioSeguimiento("MX-14577");
		usuario.setHoraFechaEvento(LocalDate.now());
		usuario.setLugarEvento("Toluca");
		usuario.setPassword("Cu213lona1212");
		usuario.setStatusSeguimiento("No Activo");
		usuario.setIdRol(new Rol(1, "Admin", "SuperUser"));
			
		userImpl.registrar(usuario);	
		
		
	}
	
	

}
