package com.jvcrud.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.jvcrud.model.dao.DAO;

@Service
@Lazy
public interface EntityService<T> extends DAO<T> {

}
