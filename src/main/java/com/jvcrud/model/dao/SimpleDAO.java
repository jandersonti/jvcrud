package com.jvcrud.model.dao;

import java.util.List;

public interface SimpleDAO <T> {

	public T get(long id);
	
	public long count();

	public long count(Object search, String field, String filter);
	
	public List<T> findAll();
	
	public List<T> find(int firstResult, int maxResults);
		
	public List<T> find(String propertyName, Object value);

	public List<T> find(Object search, String field, String filter, int firstResult, int maxResults);

	public List<T> find(int firstResult, int maxResults, String orderBy);
	
	public List<T> findForWhereClause(String where, int firstResult, int maxResults);
	
}
