package com.consulta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.consulta.model.Usuario;

@Service
public interface IUsuarioService {

	Usuario modificar(Usuario u) throws Exception;
	List<Usuario> listar() throws Exception;
	void eliminar(Integer id) throws Exception;
	Usuario registrar(Usuario u) throws Exception;
	Usuario listarPorIdUsuario(Integer id) throws Exception;
}
