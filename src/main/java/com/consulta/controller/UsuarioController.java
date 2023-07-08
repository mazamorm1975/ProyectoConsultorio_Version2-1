package com.consulta.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulta.dto.UsuarioDTO;
import com.consulta.model.Usuario;
import com.consulta.service.IUsuarioService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private ModelMapper mapper;
	
	/*
	@PostMapping("/ingresarUsuario")
	public ResponseEntity<UsuarioDTO> registrar(@Valid @RequestBody UsuarioDTO usuariodto) throws Exception {
		//mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Usuario user = mapper.map(usuariodto, Usuario.class);
		usuarioService.registrar(user);
		UsuarioDTO userdto = mapper.map(user, UsuarioDTO.class);
		
		return new ResponseEntity<UsuarioDTO>(userdto, HttpStatus.CREATED);
	}*/

	@PostMapping("/ingresarUsuario")
	public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario usuario) throws Exception{
		
		Usuario user2 = usuarioService.registrar(usuario);
		
		return new ResponseEntity<Usuario>(user2, HttpStatus.CREATED);
	}
	
	//Se realiza la modificación total del registro y se requiere el numero existente de Id del usuario
	@PutMapping("/modificar/{id}")
	public Usuario modificar(@PathVariable("id") Integer id, @RequestBody Usuario usuario) throws Exception {
     
		Usuario user_2 = usuarioService.listarPorIdUsuario(id);
		
		if (user_2 != null) {
		  usuario.setIdUsuario(id);
		return usuarioService.modificar(usuario);
		}
		return null;
	}

	
	@GetMapping("/listadoCompleto")
	public List<Usuario> listaTotal() throws Exception {

		List<Usuario> listadoUsuarios = usuarioService.listar();

		return listadoUsuarios;
	}

	
	@GetMapping("/listarPorId/{id}")
	public ResponseEntity<UsuarioDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
	
		UsuarioDTO user_2 = usuarioService.listarPorIdUsuarioDTO(id);
		
		return new ResponseEntity(user_2, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminarUsuario(@PathVariable("id") Integer id) throws Exception {
		Usuario user = new Usuario();
		if(user != null) {
			usuarioService.eliminar(id);
			System.out.println("Usuario Eliminado");
		}
		
	}

}
