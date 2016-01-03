package com.jvcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jvcrud.model.dao.DAO;

@Service
public abstract class AbstractSimpleService<D extends DAO<T>, T> implements SimpleService<T>{
	
protected D dao;
	
	protected abstract void setDAO(D entityDAO);
	
	protected D getDAO(){
		return dao;
	}
	
	@Override
	public T get(long id) {
		return getDAO().get(id);
	}

	@Override
	public long count() {
		return getDAO().count();
	}

	@Override
	public long count(Object search, String field, String filter) {
		return getDAO().count(search, field, filter);
	}

	@Override
	public List<T> findAll() {
		return getDAO().findAll();
	}

	@Override
	public List<T> find(int firstResult, int maxResults) {
		return getDAO().find(firstResult, maxResults);
	}

	@Override
	public List<T> find(String propertyName, Object value) {
		return getDAO().find(propertyName, value);
	}

	@Override
	public List<T> find(Object search, String field, String filter, int firstResult, int maxResults) {
		return getDAO().find(search, field, filter, firstResult, maxResults);
	}

	@Override
	public List<T> find(int firstResult, int maxResults, String orderBy) {
		return getDAO().find(firstResult, maxResults, orderBy);
	}

	@Override
	public List<T> findForWhereClause(String where, int firstResult, int maxResults) {
		return getDAO().findForWhereClause(where, firstResult, maxResults);
	}

}
