package com.consulta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulta.model.Usuario;
import com.consulta.service.IUsuarioService;
import com.consulta.service.implementation.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	
	@PostMapping
	public Usuario registrar(@RequestBody Usuario usuario) throws Exception {
		
		return usuarioService.registrar(usuario);
	}

	
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
	public Usuario listarPorId(@PathVariable("id") Integer id) throws Exception {
		Usuario user = new Usuario();
		if (user != null) {
			Usuario user_2 = usuarioService.listarPorIdUsuario(id);
			return user_2;
		}
		return null;
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
