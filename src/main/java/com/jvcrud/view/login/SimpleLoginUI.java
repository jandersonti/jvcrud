package com.jvcrud.view.login;

import com.jvcrud.view.Index;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public class SimpleLoginUI extends UI {

	private static final long serialVersionUID = 6727212326815879953L;

	@Override
	protected void init(VaadinRequest request) {


		new Navigator(this, this);
		
		getNavigator().addView(SimpleLoginView.NAME, SimpleLoginView.class);//
		getNavigator().addView(Index.NAME, Index.class);
		
		getNavigator().setErrorView(i -> {});

		getNavigator().addViewChangeListener(new ViewChangeListener() {

			@Override
			public boolean beforeViewChange(ViewChangeEvent event) {

				boolean isLoggedIn = getSession().getAttribute("user") != null;
				boolean isLoginView = event.getNewView() instanceof SimpleLoginView;

				if (!isLoggedIn && !isLoginView) {
					getNavigator().navigateTo(SimpleLoginView.NAME);
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