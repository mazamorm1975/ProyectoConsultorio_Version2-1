package com.consulta.serviceImplTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.consulta.model.Rol;
import com.consulta.model.Usuario;
import com.consulta.repositorio.IUsuarioRepo;
import com.consulta.service.IUsuarioService;
import com.consulta.service.implementation.UsuarioServiceImpl;

class ServiceImplTest {

	@InjectMocks
	UsuarioServiceImpl usuarioService;
	
	
	@Mock
	IUsuarioRepo usuarioRepo;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testRegistrar() throws Exception {
		
		
		
		//Se simula el cuerpo del JSON de tipo Usuario
		Usuario usuario = new Usuario();
		usuario.setUsername("Mario");
		usuario.setFolioSeguimiento("MX-14577");
		usuario.setHoraFechaEvento(LocalDate.now());
		usuario.setLugarEvento("Toluca");
		usuario.setPassword("Cu213lona1212");
		usuario.setStatusSeguimiento("No Activo");
		usuario.setIdRol(new Rol(1, "Admin", "SuperUser"));
				
		when(usuarioRepo.save(usuario)).thenReturn(usuario);
		
		Usuario user1 = usuarioService.registrar(usuario);
		  
		assertNotNull(user1);
		
		assertEquals("Toluca", user1.getLugarEvento());
	}

}
