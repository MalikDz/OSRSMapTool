package org.rspeer.malikdz.maptool.model;

import java.util.List;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.GeneralPath;

/**
 * 
 * @author MalikDz
 *
 */

public class MapPath extends PositionGroup {

	@Override
	public DataType getDataType() {
		return DataType.PATH;
	}

	@Override
	public void renderPositionGroup(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		drawRunescapePathOnScreen(graphics);
		drawScreenPositions(graphics);
	}

	private void drawRunescapePathOnScreen(Graphics2D graphics) {
		List<MapPosition> positions = positions();
		GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO);
		if (positions.size() == 0)
			return;
		graphics.setColor(Color.BLACK);
		graphics.setStroke(new BasicStroke(1.0f));
		path.moveTo(positions.get(0).getScreenX(), positions.get(0).getScreenY());
		for (int x = 1; positions.size() > 1 && x < positions.size(); x++)
			path.lineTo(positions.get(x).getScreenX(), positions.get(x).getScreenY());
		graphics.draw(path);
	}
}
