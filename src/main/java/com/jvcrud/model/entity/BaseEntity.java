package com.jvcrud.model.entity;

import java.io.Serializable;

public interface BaseEntity extends Serializable {
	public Long getId();
	public void setId(Long id);
	
	public boolean isSaved();	
}