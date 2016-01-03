package com.jvcrud.model.dao.impl;

import org.springframework.stereotype.Repository;

import com.jvcrud.model.dao.AbstractDAO;
import com.jvcrud.model.dao.UsuarioDAO;
import com.jvcrud.model.entity.Usuario;
import com.jvcrud.model.entity.impl.UsuarioImpl;

@Repository
public class UsuarioDAOImpl extends AbstractDAO<Usuario> implements UsuarioDAO {

	protected UsuarioDAOImpl() {
		super(UsuarioImpl.class);
	}

}
