package com.jvcrud.model.entity;

public interface Usuario extends BaseEntity {
	
	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);

}
