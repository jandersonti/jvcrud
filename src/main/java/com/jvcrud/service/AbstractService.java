package com.jvcrud.service;

import java.util.List;

import com.jvcrud.model.dao.DAO;

public abstract class AbstractService<D extends DAO<T>, T> extends AbstractSimpleService<D,T> implements EntityService<T>{

	@Override
	public void save(T entity) {
		getDAO().save(entity);		
	}

	@Override
	public void save(List<T> entities) {
		getDAO().save(entities);		
	}

	@Override
	public void delete(T entity) {
		getDAO().delete(entity);
	}

	@Override
	public void delete(List<T> entities) {
		getDAO().delete(entities);
		
	}

	@Override
	public void deleteById(long id) {
		getDAO().deleteById(id);
		
	}
}
