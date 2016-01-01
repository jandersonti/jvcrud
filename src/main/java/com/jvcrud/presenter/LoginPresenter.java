package com.jvcrud.presenter;

import com.jvcrud.view.LoginView;
import com.jvcrud.view.LoginViewHandler;

public class LoginPresenter implements LoginViewHandler {

	private LoginView view;
	
	public void setView(LoginView view){
		this.view = view;
	}
	
	@Override
	public void login() {
		
		String username = view.getUser().getValue();
		String password = view.getPassword().getValue();
		
		if (!view.getUser().isValid() || !view.getPassword().isValid()) {
			return;
		}

		boolean isValid = username.equals("admin") && password.equals("admin");

		if (!isValid) {

			// Wrong password clear the password field and refocuses it
			view.getPassword().setValue(null);
			view.getPassword().focus();
		}
		
		else view.afterSuccessfulLogin();
	}

}
