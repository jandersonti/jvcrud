package com.jvcrud.model.dao.impl;

import com.jvcrud.model.dao.AbstractDAO;
import com.jvcrud.model.dao.UsuarioDAO;
import com.jvcrud.model.entity.Usuario;
import com.jvcrud.model.entity.impl.UsuarioImpl;

public class UsuarioDAOImpl extends AbstractDAO<Usuario> implements UsuarioDAO {

	protected UsuarioDAOImpl() {
		super(UsuarioImpl.class);
	}

}
