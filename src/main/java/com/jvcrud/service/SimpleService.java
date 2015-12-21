package com.jvcrud.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.jvcrud.model.dao.SimpleDAO;

@Service
@Lazy
public interface SimpleService<T> extends SimpleDAO<T> {

}
