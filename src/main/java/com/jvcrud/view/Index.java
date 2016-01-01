package com.jvcrud.view;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@Title("JVCRUD - CRUD AGILE")
public class Index extends VerticalLayout implements View {

	private static final long serialVersionUID = -522126154958715472L;

	public static final String NAME = "index";

	protected MenuBar menuBar;
	protected MenuItem mnConfig;
	protected MenuItem mnCadastros;
	protected MenuItem mnSobre;
	protected MenuItem mnSair;

	public Index() {
		buildLayout();
	}

	private void buildLayout() {

		setResponsive(true);

		menuBar = new MenuBar();
		menuBar.setWidth(100, Unit.PERCENTAGE);

		mnConfig = menuBar.addItem("Configurações", e -> {
			ConfirmDialog.show(getUI(), "Please Confirm:", "Are you really sure?", "Sim", "Não", f -> {

				if (f.isConfirmed()) {
					System.out.println("YES");
				} else {
					System.out.println("NOT");
				}

			});

		});

		mnCadastros = menuBar.addItem("Cadastros", e -> {
		});

		mnSobre = menuBar.addItem("Sobre", e -> {
			Notification.show("This is the caption",
	                  "This is the description",
	                  Notification.Type.WARNING_MESSAGE);
		});

		mnSair = menuBar.addItem("Sair", e -> {
			getSession().setAttribute("user", null);
			getUI().getNavigator().navigateTo("");
		});

		addComponent(menuBar);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}