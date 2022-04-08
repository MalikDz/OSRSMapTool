package org.rspeer.malikdz.maptool.model;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * 
 * @author MalikDz
 *
 */

public class Utilities {

	/**
	 * 
	 * @return the loaded image from a specific path
	 * 
	 */

	public static BufferedImage loadImageAndIgnoreException(final String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (Exception e) {
		}
		return image;
	}
}
