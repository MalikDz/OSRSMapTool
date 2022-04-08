package org.rspeer.malikdz.maptool.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 
 * @author MalikDz
 * 
 */

public abstract class PositionGroup {

	public abstract DataType getDataType();

	public abstract void renderPositionGroup(Graphics g);

	private ArrayList<MapPosition> positions = new ArrayList<MapPosition>();

	public ArrayList<MapPosition> positions() {
		return positions;
	}

	public void addPosition(MapPosition position) {
		positions.add(position);
	}

	public void updateScreenPositions(double mapScale, int mapPositionX, int mapPositionY) {
		this.positions.forEach(p -> p.calculateNewScreenPoint(mapScale, mapPositionX, mapPositionY));
	}

	public void drawScreenPositions(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.setFont(g.getFont().deriveFont(15.0F));
		positions().forEach(p -> g.fillOval(p.getScreenX(), p.getScreenY(), 5, 5));
		positions().forEach(p -> g.drawString(p.toString(), p.getScreenX() + 9, p.getScreenY() + 7));
	}

	public String toRSPeerCode() {
		ArrayList<MapPosition> positions = positions();
		MapPosition lastPosition = positions.get(positions.size() - 1);
		positions.remove(positions.size() - 1);
		StringBuilder areaCode = new StringBuilder();
		positions.forEach(p -> areaCode.append(p.toRSPeerCode() + ", "));
		return String.format(getDataType().getCodeBase(), areaCode.append(lastPosition.toRSPeerCode()).toString());
	}
}
