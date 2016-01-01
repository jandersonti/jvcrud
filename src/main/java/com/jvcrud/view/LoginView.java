package com.jvcrud.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public interface LoginView extends View, Button.ClickListener {

	public static final String NAME = "login";
	
	public TextField getUser();
	public PasswordField getPassword();
	
	public void init();
	
	public void afterSuccessfulLogin();

}