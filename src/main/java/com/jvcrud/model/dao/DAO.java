package com.jvcrud.model.dao;

import java.util.List;


public interface DAO<T> extends SimpleDAO<T> {
    
    public void save(T entity);
    
    public void save(List<T> entities);
    
    public void delete(T entity);
    
    public void delete(List<T> entities);
    
    public void deleteById(long id);		
}
