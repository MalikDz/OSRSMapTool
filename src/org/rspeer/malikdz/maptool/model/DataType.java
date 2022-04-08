package org.rspeer.malikdz.maptool.model;

/**
 * 
 * @author MalikDz
 *
 */

public enum DataType {

	AREA("private static final Area AREA = Area.polygonal(%s);"), 
	PATH("private static final PredefinedPath PATH = new PredefinedPath(%s);");
	
	private String codeBase;

	private DataType(String codeBase) {
		this.codeBase = codeBase;
	}

	public String getCodeBase() {
		return codeBase;
	}
}
