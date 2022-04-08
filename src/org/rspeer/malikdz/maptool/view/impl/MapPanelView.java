package org.rspeer.malikdz.maptool.view.impl;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import org.rspeer.malikdz.maptool.model.MapArea;
import org.rspeer.malikdz.maptool.view.BaseView;
import org.rspeer.malikdz.maptool.model.Utilities;
import org.rspeer.malikdz.maptool.model.PositionGroup;
import org.rspeer.malikdz.maptool.controller.impl.MapPanelController;

/**
 * 
 * @author MalikDz
 *
 */

public class MapPanelView extends BaseView<MapPanelController, JPanel> {

	private JPanel mapPanel;
	private InputHandler inputHandler;
	private PositionGroup currentPositionGroup = new MapArea();
	private int mapPositionX = 0, mapPositionY = 0, mapWidth, mapHeight;
	private static final String OSRS_MAIN_LAND_MAP_IMAGE = "res/img/osrs_world_map.png";
	private static final BufferedImage OSRS_MAP_IMAGE = Utilities.loadImageAndIgnoreException(OSRS_MAIN_LAND_MAP_IMAGE);
	private static final int INITIAL_MAP_HEIGHT = OSRS_MAP_IMAGE.getHeight();
	private static final int INITIAL_MAP_WIDTH = OSRS_MAP_IMAGE.getWidth();

	public MapPanelView(MapPanelController controller) {
		controller.initiliazeMap(INITIAL_MAP_WIDTH, INITIAL_MAP_HEIGHT);
		setController(controller);
	}

	public void setPositionGroup(PositionGroup currentPositionGroup) {
		this.currentPositionGroup = currentPositionGroup;
	}

	public void initializeMapPanelAndSize() {
		(mapPanel = new MapPanel()).setSize(mapWidth, mapHeight);
	}

	public void setMapDrawingData(int mapPositionX, int mapPositionY, int mapWidth, int mapHeight) {
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		this.mapPositionY = mapPositionY;
		this.mapPositionX = mapPositionX;
	}

	public void registerInputHandler() {
		inputHandler = new InputHandler();
		mapPanel.addMouseWheelListener(inputHandler);
		mapPanel.addMouseMotionListener(inputHandler);
		mapPanel.addMouseListener(inputHandler);
	}

	public JPanel component() {
		return mapPanel;
	}

	public class InputHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			controller().initiateMapMovement(e.getPoint());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			controller().endMapMovement();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			controller().handleMapMovement(e.getPoint());
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			controller().handleZoom(e.getPoint(), e.getWheelRotation() < 0);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			controller().addTileAt(e.getPoint());
		}
	}

	public class MapPanel extends JPanel {

		private static final long serialVersionUID = 6790353303450348443L;

		private void renderMapAndPositionGroup(Graphics g) {
			g.drawImage(OSRS_MAP_IMAGE, mapPositionX, mapPositionY, mapWidth, mapHeight, null);
			currentPositionGroup.renderPositionGroup(g);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			renderMapAndPositionGroup(g);
		}
	}
}