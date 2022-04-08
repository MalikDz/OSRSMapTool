package org.rspeer.malikdz.maptool.controller.impl;

import org.rspeer.malikdz.maptool.model.MapArea;
import org.rspeer.malikdz.maptool.model.MapPath;
import org.rspeer.malikdz.maptool.model.DataType;
import org.rspeer.malikdz.maptool.controller.BaseController;
import org.rspeer.malikdz.maptool.view.impl.MenuToolbarView;

/**
 * 
 * @author MalikDz
 *
 */

public class MenuToolbarController extends BaseController<MenuToolbarView> {

	private MapPanelController mapPanelController;

	public MenuToolbarController(MapPanelController mapPanelController) {
		this.mapPanelController = mapPanelController;
	}

	@Override
	public void initView() {
		view = new MenuToolbarView(this);
	}

	public void generateCode() {
		mapPanelController.generateGroupPositionCode();
	}

	public void clearPositionGroup() {
		mapPanelController.clearPositionGroup();
		mapPanelController.view().component().repaint();
	}

	public void initiateNewDataType(DataType type) {
		mapPanelController.setPositionGroup(DataType.AREA.equals(type) ? new MapArea() : new MapPath());
	}

	@Override
	public MenuToolbarView view() {
		return view;
	}
}
