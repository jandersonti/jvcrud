package com.jvcrud.model.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("rawtypes")
@Repository
@Lazy
public abstract class AbstractDAO<T> extends AbstractSimpleDAO<T> implements DAO<T> {

	
	protected AbstractDAO(Class classType) {
		super(classType);
	}

	@Override
	@Transactional
	public void save(T entity) {

		getSession().saveOrUpdate(entity);
		getSession().flush();

	}

	@Override
	@Transactional
	public void delete(T entity) {

		getSession().delete(entity);

	}

	@Override
	@Transactional
	public void deleteById(long id) {
		T e = (T) get(id);

		getSession().delete(e);
	}

	@Override
	@Transactional
	public void delete(List<T> entities) {

		for (Iterator<T> it = entities.iterator(); it.hasNext();) {
			T t = it.next();

			delete(t);
		}
	}

	@Override
	@Transactional
	public void save(List<T> entities) {

		for (Iterator<T> it = entities.iterator(); it.hasNext();) {
			T t = it.next();

			save(t);

		}
	}
}
