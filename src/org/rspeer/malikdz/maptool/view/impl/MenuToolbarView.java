package org.rspeer.malikdz.maptool.view.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import org.rspeer.malikdz.maptool.view.BaseView;
import org.rspeer.malikdz.maptool.model.DataType;
import org.rspeer.malikdz.maptool.controller.impl.MenuToolbarController;

/**
 * 
 * @author MalikDz
 *
 */

public class MenuToolbarView extends BaseView<MenuToolbarController, JMenuBar> implements ActionListener {

	private JMenuBar menubar;
	private JMenu settingsNOptionMenu, typeMenu;
	private JCheckBoxMenuItem pathSubMenu, areaSubMenu;

	public MenuToolbarView(MenuToolbarController menuController) {
		settingsNOptionMenu = new JMenu("Settings");
		typeMenu = new JMenu("Type");
		menubar = new JMenuBar();

		areaSubMenu = new JCheckBoxMenuItem("Area");
		areaSubMenu.setSelected(true);
		typeMenu.add(areaSubMenu);

		pathSubMenu = new JCheckBoxMenuItem("Path");
		typeMenu.add(pathSubMenu);

		pathSubMenu.addActionListener(this);
		areaSubMenu.addActionListener(this);

		settingsNOptionMenu.add(typeMenu);

		JMenuItem clearItem = new JMenuItem("Clear");
		settingsNOptionMenu.add(clearItem);

		JMenuItem generateItem = new JMenuItem("Generate");
		settingsNOptionMenu.add(generateItem);

		clearItem.addActionListener(this);
		generateItem.addActionListener(this);

		pathSubMenu.addActionListener(this);
		areaSubMenu.addActionListener(this);
		settingsNOptionMenu.addActionListener(this);

		setController(menuController);
		menubar.add(settingsNOptionMenu);
	}

	@Override
	public JMenuBar component() {
		return menubar;
	}

	private void handleDataType(ActionEvent event) {
		JCheckBoxMenuItem item = ((JCheckBoxMenuItem) event.getSource());
		(item.equals(pathSubMenu) ? areaSubMenu : pathSubMenu).setSelected(false);
		controller().initiateNewDataType(item.getText().equals("Path") ? DataType.PATH : DataType.AREA);
		item.setSelected(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JCheckBoxMenuItem) handleDataType(event);
		if (((JMenuItem) event.getSource()).getText().equals("Clear")) controller().clearPositionGroup();
		if (((JMenuItem) event.getSource()).getText().equals("Generate")) controller().generateCode();
	}
}
