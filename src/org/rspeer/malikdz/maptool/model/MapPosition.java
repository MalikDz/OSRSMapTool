package org.rspeer.malikdz.maptool.model;

import java.awt.Point;

/**
 * 
 * @author MalikDz
 *
 */

public class MapPosition {

	private double mapX, mapY;
	private int screenX, screenY;
	private static final String POSITION_STRING_FORMAT = "(%d,%d)";
	private static final String RSPEER_POSITION_CODE_FORMAT = "new Position(%d,%d)";

	public MapPosition(Point clickPoint, double mapScale, int mapPositionX, int mapPositionY) {
		mapX = ((clickPoint.getX() + (mapPositionX * -1)) / (3 * mapScale)) + RunescapeMap.MAP_TILE_X_OFFSET;
		mapY = RunescapeMap.MAP_TILE_Y_OFFSET - ((clickPoint.getY() + (mapPositionY * -1)) / (3 * mapScale));
	}

	public void calculateNewScreenPoint(double mapScale, int mapPositionX, int mapPositionY) {
		screenX = (int) (((mapX - RunescapeMap.MAP_TILE_X_OFFSET) * (3 * mapScale)) - (mapPositionX * -1));
		screenY = (int) ((((mapY - RunescapeMap.MAP_TILE_Y_OFFSET) / -1) * (3 * mapScale)) - (mapPositionY * -1));
	}

	public String toRSPeerCode() {
		return String.format(RSPEER_POSITION_CODE_FORMAT, (int) mapX, (int) mapY);
	}

	@Override
	public String toString() {
		return String.format(POSITION_STRING_FORMAT, (int) mapX, (int) mapY);
	}

	public double getMapX() {
		return mapX;
	}

	public double getMapY() {
		return mapY;
	}

	public int getScreenX() {
		return screenX;
	}

	public int getScreenY() {
		return screenY;
	}
}
