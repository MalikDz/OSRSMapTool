package org.rspeer.malikdz.maptool;

import javax.swing.UIManager;

import org.rspeer.malikdz.maptool.view.impl.MapToolFrameView;

import javax.swing.SwingUtilities;

/**
 * 
 * @author MalikDz
 *
 */

public class Boot implements Runnable {

	/**
	 * 
	 * launch the area maker frame
	 * 
	 */

	@Override
	public void run() {
		new MapToolFrameView();
	}

	/**
	 * 
	 * set the look and feel
	 * 
	 */

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Boot());
	}
}
