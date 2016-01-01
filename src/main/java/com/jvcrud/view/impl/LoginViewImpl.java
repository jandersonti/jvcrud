package com.jvcrud.view.impl;

import org.springframework.context.annotation.Scope;

import com.jvcrud.presenter.LoginPresenter;
import com.jvcrud.view.Index;
import com.jvcrud.view.LoginView;
import com.jvcrud.view.LoginViewHandler;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SpringView
@Scope
public class LoginViewImpl extends CustomComponent implements LoginView {

	private static final long serialVersionUID = 6833370322334533700L;

	private LoginViewHandler handler;

	protected TextField user;
	protected PasswordField password;

	protected Button loginButton;
	
	@Override
	public void init() {
		
		handler = new LoginPresenter();
		handler.setView(this);
		
		setSizeFull();

		user = new TextField("User:");
		user.setWidth("300px");
		user.setRequired(true);
		user.setInputPrompt("Your username (eg. joe.lost)");
		user.setInvalidAllowed(false);

		password = new PasswordField("Password:");
		password.setWidth("300px");
		password.addValidator(new PasswordValidator());
		password.setRequired(true);
		password.setValue("");
		password.setNullRepresentation("");

		loginButton = new Button("Login", this);

		VerticalLayout fields = new VerticalLayout(user, password, loginButton);
		fields.setCaption("Please login to access the application.");
		fields.setSpacing(true);
		fields.setMargin(new MarginInfo(true, true, true, false));
		fields.setSizeUndefined();

		VerticalLayout viewLayout = new VerticalLayout(fields);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
		viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
		setCompositionRoot(viewLayout);

		loginButton.setClickShortcut(KeyCode.ENTER);

	}
	
	public LoginViewImpl() {
		init();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		user.focus();
	}

	// Validator for validating the passwords
	@SuppressWarnings("serial")
	private static final class PasswordValidator extends AbstractValidator<String> {

		public PasswordValidator() {
			super("The password provided is not valid");
		}

		@Override
		protected boolean isValidValue(String value) {

			if (value == null) {
				return false;
			}
			return true;
		}

		@Override
		public Class<String> getType() {
			return String.class;
		}
	}

	@Override
	public void buttonClick(ClickEvent event) {
		handler.login();
	}

	public TextField getUser() {
		return user;
	}

	public PasswordField getPassword() {
		return password;
	}

	@Override
	public void afterSuccessfulLogin() {

		// Store the current user in the service session
		getSession().setAttribute("user", user.getValue());

		// Navigate to main view
		getUI().getNavigator().navigateTo(Index.NAME);
	}

}
