package org.rspeer.malikdz.maptool.view.impl;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import org.rspeer.malikdz.maptool.controller.impl.MapPanelController;
import org.rspeer.malikdz.maptool.controller.impl.MenuToolbarController;

/**
 * 
 * @author MalikDz
 *
 */

public class MapToolFrameView extends JFrame {

	/**
	 * 
	 * @author MalikDz
	 *
	 */
	
	private MapPanelController mapPanelController;
	private MenuToolbarController toolbarController;
	private static final long serialVersionUID = 1L;
	private static final String AREA_MAKER_NAME = "Map tool";

	public MapToolFrameView() {
		super(AREA_MAKER_NAME);

		mapPanelController = new MapPanelController();
		mapPanelController.initView();

		toolbarController = new MenuToolbarController(mapPanelController);
		toolbarController.initView();

		setLayout(new BorderLayout(0, 0));
		Dimension scaledDim = mapPanelController.view().component().getSize();
		setSize((int) (scaledDim.getWidth() + 15), (int) (scaledDim.getHeight() + 30));

		add(toolbarController.view().component(), BorderLayout.NORTH);
		add(mapPanelController.view().component());

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
