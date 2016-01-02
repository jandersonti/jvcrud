package com.jvcrud.model.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

import com.jvcrud.model.entity.AbstractEntity;
import com.jvcrud.model.entity.Usuario;

@Entity(name="USUARIO")
@SequenceGenerator(name="SE_USUARIO", sequenceName="SE_USUARIO")
public class UsuarioImpl extends AbstractEntity implements Usuario {

	private static final long serialVersionUID = -3206984953008187908L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="SE_USUARIO")
    @Column(name="ID")
	private Long id;
	
	@Column(name="USERNAME", length=30, nullable=false)
	@NotBlank(message="Usuário requerido!")
	private String username;
	
	@Column(name="PASSWORD", length=30, nullable=false)
	@NotBlank(message="Senha requerida!")
	private String password;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
