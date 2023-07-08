package com.consulta.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulta.dto.UsuarioDTO;
import com.consulta.model.Usuario;
import com.consulta.repositorio.IUsuarioRepo;
import com.consulta.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Usuario modificar(Usuario u) throws Exception {
		return usuarioRepo.save(u);
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		usuarioRepo.deleteById(id);
		
	}

	@Override
	public Usuario registrar(Usuario u) throws Exception {
		return usuarioRepo.save(u);
	}

	@Override
	public List<Usuario> listar() throws Exception {
		return usuarioRepo.findAll();
	}

	@Override
	public UsuarioDTO listarPorIdUsuarioDTO(Integer id) throws Exception {
		
		Usuario usuario = usuarioRepo.findById(id).get();
		UsuarioDTO usuariodto = mapper.map(usuario, UsuarioDTO.class);
		
		return usuariodto;
	}

	@Override
	public Usuario listarPorIdUsuario(Integer id) throws Exception {

		Usuario usuario = usuarioRepo.findById(id).get();
				
		return usuario;
	}

	

	
	
}
