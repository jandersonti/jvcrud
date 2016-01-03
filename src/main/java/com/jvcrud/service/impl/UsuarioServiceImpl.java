package com.jvcrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvcrud.model.dao.UsuarioDAO;
import com.jvcrud.model.entity.Usuario;
import com.jvcrud.service.AbstractService;
import com.jvcrud.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends AbstractService<UsuarioDAO, Usuario> implements UsuarioService {

	@Override
	@Autowired
	protected void setDAO(UsuarioDAO entityDAO) {
		dao = entityDAO;		
	}

	@Override
	public boolean login(String username, String password) {
		
		if(username == null || password == null) return false;
		
		List<Usuario> usuarios = find("username", username);
		
		if(usuarios.isEmpty()) return false;
		
		if(usuarios.get(0).getPassword().equals(password)) return true;
		
		return false;
	}

}
