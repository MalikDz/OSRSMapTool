package org.rspeer.malikdz.maptool.model;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * @author MalikDz
 *
 */

public class MapArea extends PositionGroup {

	private static final Color AREA_FILING_COLOR = new Color(130, 20, 30, 80);

	public DataType getDataType() {
		return DataType.AREA;
	}

	private Polygon createPolygonArea() {
		Polygon onScreenArea = new Polygon();
		positions().forEach(p -> onScreenArea.addPoint(p.getScreenX(), p.getScreenY()));
		return onScreenArea;
	}

	public void renderPositionGroup(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		Polygon onScreenArea = createPolygonArea();
		g.setColor(AREA_FILING_COLOR);
		g.fillPolygon(onScreenArea);
		g.setColor(Color.BLACK);
		g.drawPolygon(onScreenArea);
		drawScreenPositions(g);
	}
}
