package com.jvcrud.view.login;

import com.jvcrud.view.Index;
import com.vaadin.annotations.Theme;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@Theme("valo")
public class SimpleLoginView extends CustomComponent implements View, Button.ClickListener {

	private static final long serialVersionUID = -9132341019495834869L;

	public static final String NAME = "login";
	private final TextField user;
	private final PasswordField password;

	private final Button loginButton;

	public SimpleLoginView() {
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

	@Override
	public void enter(ViewChangeEvent event) {
		user.focus();
	}

	// Validator for validating the passwords
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

		if (!user.isValid() || !password.isValid()) {
			return;
		}

		String username = user.getValue();
		String password = this.password.getValue();

		//
		// Validate username and password with database here. For examples sake
		// I use a dummy username and password.
		//
		boolean isValid = username.equals("admin") && password.equals("admin");

		if (isValid) {

			// Store the current user in the service session
			getSession().setAttribute("user", username);

			// Navigate to main view
			getUI().getNavigator().navigateTo(Index.NAME);

		} else {

			// Wrong password clear the password field and refocuses it
			this.password.setValue(null);
			this.password.focus();

		}
	}
}