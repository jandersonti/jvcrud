package com.jvcrud.config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.jvcrud.view.login.SimpleLoginUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = SimpleLoginUI.class)
public class MyServlet extends VaadinServlet implements SessionInitListener, SessionDestroyListener {

	private static final long serialVersionUID = 5105249294894541289L;

	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
		getService().addSessionInitListener(this);
		getService().addSessionDestroyListener(this);
	}

	@Override
	public void sessionInit(SessionInitEvent event) throws ServiceException {
		// Do session start stuff here
	}

	@Override
	public void sessionDestroy(SessionDestroyEvent event) {
		// Do session end stuff here
	}
}
