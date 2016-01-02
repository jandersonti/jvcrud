package com.jvcrud.model.entity;

public abstract class AbstractEntity implements BaseEntity {

	private static final long serialVersionUID = -7702020166667220164L;

	public boolean isSaved() {
		
		if (getId() == null) return false;
		
		if (getId() > 0) return true;

		return false;
	}

}
