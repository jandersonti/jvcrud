package com.jvcrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvcrud.model.entity.Usuario;
import com.jvcrud.service.AbstractService;
import com.jvcrud.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends AbstractService<UsuarioService, Usuario> {

	@Override
	@Autowired
	protected void setDAO(UsuarioService entityDAO) {
		dao = entityDAO;		
	}

}
