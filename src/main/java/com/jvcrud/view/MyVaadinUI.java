package com.jvcrud.view;

import com.jvcrud.view.impl.LoginViewImpl;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
public class MyVaadinUI extends UI {

	private static final long serialVersionUID = 6727212326815879953L;

	@SuppressWarnings("serial")
	@Override
	protected void init(VaadinRequest request) {

		new Navigator(this, this);

		getNavigator().addView(LoginView.NAME, LoginViewImpl.class);//
		getNavigator().addView(Index.NAME, Index.class);

		getNavigator().setErrorView(e -> {
		});

		getNavigator().addViewChangeListener(new ViewChangeListener() {

			@Override
			public boolean beforeViewChange(ViewChangeEvent event) {

				boolean isLoggedIn = getSession().getAttribute("user") != null;
				boolean isLoginView = event.getNewView() instanceof LoginView;

				if (!isLoggedIn && !isLoginView) {
					getNavigator().navigateTo(LoginView.NAME);
					return false;

				} else if (isLoggedIn && isLoginView) {
					return false;
				}

				return true;
			}

			@Override
			public void afterViewChange(ViewChangeEvent event) {

			}
		});
	}
}