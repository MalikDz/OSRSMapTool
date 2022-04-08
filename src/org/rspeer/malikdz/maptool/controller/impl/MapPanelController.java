package org.rspeer.malikdz.maptool.controller.impl;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JOptionPane;
import org.rspeer.malikdz.maptool.model.MapArea;
import org.rspeer.malikdz.maptool.model.MapPosition;
import org.rspeer.malikdz.maptool.model.RunescapeMap;
import org.rspeer.malikdz.maptool.model.PositionGroup;
import org.rspeer.malikdz.maptool.view.impl.MapPanelView;
import org.rspeer.malikdz.maptool.controller.BaseController;

/**
 * 
 * @author MalikDz
 *
 */

public class MapPanelController extends BaseController<MapPanelView> {

	private RunescapeMap map;
	private PositionGroup currentPositionGroup = new MapArea();
	private static final String CODE_MESSAGE = "Code has been copied to the clipboard !";

	public MapPanelController() {
		map = new RunescapeMap();
	}

	@Override
	public void initView() {
		view = new MapPanelView(this);
		updateViewGraphicsData();
		initializeViewData();
	}

	private void initializeViewData() {
		view.setPositionGroup(currentPositionGroup);
		view.initializeMapPanelAndSize();
		view.registerInputHandler();
	}

	@Override
	public MapPanelView view() {
		return view;
	}

	public void endMapMovement() {
		map.endMapMovement();
	}

	public void initiateMapMovement(Point point) {
		map.initalMovementPoint(point);
	}

	public void clearPositionGroup() {
		currentPositionGroup.positions().clear();
	}

	public void setPositionGroup(PositionGroup positionGroup) {
		view().setPositionGroup(currentPositionGroup = positionGroup);
	}

	public void initiliazeMap(int initialMapWidth, int initialMapHeight) {
		map.setInitialSize(initialMapWidth, initialMapHeight);
	}

	private void updateTilesPostionOnScreen() {
		currentPositionGroup.updateScreenPositions(map.getScale(), map.getDrawingPosX(), map.getDrawingPosY());
	}

	public void updateViewGraphicsData() {
		view.setMapDrawingData(map.getDrawingPosX(), map.getDrawingPosY(), map.getScaledWidth(), map.getScaledHeight());
	}

	public void addTileAt(Point p) {
		currentPositionGroup.addPosition(new MapPosition(p, map.getScale(), map.getPositionX(), map.getPositionY()));
		updateTilesPostionOnScreen();
		view.component().repaint();
	}

	public void handleMapMovement(Point point) {
		map.moveMap(point);
		updateViewGraphicsData();
		updateTilesPostionOnScreen();
		view.component().repaint();
	}

	public void handleZoom(Point point, boolean zoomIn) {
		map.zoom(point, zoomIn);
		updateViewGraphicsData();
		updateTilesPostionOnScreen();
		view.component().repaint();
	}

	public void generateGroupPositionCode() {
		StringSelection selection = new StringSelection(currentPositionGroup.toRSPeerCode());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
		JOptionPane.showMessageDialog(null, CODE_MESSAGE, "Code copied", JOptionPane.INFORMATION_MESSAGE);
	}
}
