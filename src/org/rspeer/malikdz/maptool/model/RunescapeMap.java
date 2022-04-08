package org.rspeer.malikdz.maptool.model;

import java.awt.Point;

/**
 * 
 * @author MalikDz
 *
 */

public class RunescapeMap {

	private double mapScale = 0.17;
	private Point initalMovementPoint;
	private int mapPositionX = 0, mapPositionY = 0;
	private int initialMapWidth = 0, initialMapHeight = 0;
	private int mapPositionXOffSet = 0, mapPositionYOffSet = 0;
	public static final int MAP_TILE_X_OFFSET = 1144;
	public static final int MAP_TILE_Y_OFFSET = 4104;

	public void initalMovementPoint(Point initalMovementPoint) {
		this.initalMovementPoint = initalMovementPoint;
	}

	public double getScale() {
		return mapScale;
	}

	public int getPositionX() {
		return mapPositionX;
	}

	public int getPositionY() {
		return mapPositionY;
	}

	public int getDrawingPosX() {
		return mapPositionX + mapPositionXOffSet;
	}

	public int getDrawingPosY() {
		return mapPositionY + mapPositionYOffSet;
	}

	public int getScaledWidth() {
		return (int) (mapScale * initialMapWidth);
	}

	public int getScaledHeight() {
		return (int) (mapScale * initialMapHeight);
	}

	public void endMapMovement() {
		mapPositionX += mapPositionXOffSet;
		mapPositionY += mapPositionYOffSet;
		mapPositionYOffSet = 0;
		mapPositionXOffSet = 0;
	}

	public void setInitialSize(int initialMapWidth, int initialMapHeight) {
		this.initialMapHeight = initialMapHeight;
		this.initialMapWidth = initialMapWidth;
	}

	private void updateMapPosition(Point cursorPos, double xMapRatio, double yMapRatio) {
		mapPositionX = (int) (cursorPos.x - (mapScale * initialMapWidth) * xMapRatio);
		mapPositionY = (int) (cursorPos.y - (mapScale * initialMapHeight) * yMapRatio);
	}

	public void moveMap(Point currentMovementPoint) {
		mapPositionXOffSet = (int) (currentMovementPoint.getX() - initalMovementPoint.getX());
		mapPositionYOffSet = (int) (currentMovementPoint.getY() - initalMovementPoint.getY());
	}

	public void zoom(Point pointOnPanel, boolean zoomInMap) {
		double xMapRatio = ((pointOnPanel.x - mapPositionX)) / (initialMapWidth * mapScale);
		double yMapRatio = ((pointOnPanel.y - mapPositionY)) / (initialMapHeight * mapScale);
		mapScale += ((mapScale * 0.1) * (zoomInMap ? 1 : -1));
		updateMapPosition(pointOnPanel, xMapRatio, yMapRatio);
	}

	public void addTile(Point point) {
		double x = ((point.getX() + (mapPositionX * -1)) / (3 * mapScale)) + MAP_TILE_X_OFFSET;
		double y = MAP_TILE_Y_OFFSET - ((point.getY() + (mapPositionY * -1)) / (3 * mapScale));
		System.out.println(x + " ," + y);
	}
}
