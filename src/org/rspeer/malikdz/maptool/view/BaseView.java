package org.rspeer.malikdz.maptool.view;

import java.awt.Component;
import org.rspeer.malikdz.maptool.controller.BaseController;

/**
 * 
 * @author MalikDz
 *
 */

@SuppressWarnings("rawtypes")
public abstract class BaseView<T extends BaseController, C extends Component> {

	/**
	 * 
	 * the view should have an instance of his presenter
	 * 
	 */

	private T controller;

	public abstract C component();

	/**
	 * 
	 * creates the view by passing an instance of his presenter
	 * 
	 */

	public void setController(T controller) {
		this.controller = controller;
	}

	/**
	 * 
	 * @return the controller for this view
	 *
	 */

	public T controller() {
		return controller;
	}
}