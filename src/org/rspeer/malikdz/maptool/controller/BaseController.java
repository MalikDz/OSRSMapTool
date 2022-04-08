package org.rspeer.malikdz.maptool.controller;

import org.rspeer.malikdz.maptool.view.BaseView;

/**
 * 
 * @author MalikDz
 *
 */

@SuppressWarnings("rawtypes")
public abstract class BaseController<T extends BaseView> {

	/**
	 * 
	 * our fields
	 * 
	 */

	protected T view;

	public abstract void initView();

	public abstract BaseView view();

}