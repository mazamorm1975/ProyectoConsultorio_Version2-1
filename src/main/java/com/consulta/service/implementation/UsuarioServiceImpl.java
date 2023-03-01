package com.consulta.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulta.model.Usuario;
import com.consulta.repositorio.IUsuarioRepo;
import com.consulta.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepo usuarioRepo;
	
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
		// TODO Auto-generated method stub
		return usuarioRepo.save(u);
	}

	
	@Override
	public List<Usuario> listar() throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario listarPorIdUsuario(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Usuario> op = usuarioRepo.findById(id);
		return op.isPresent() ? op.get(): new Usuario();
	}

	
	
}
