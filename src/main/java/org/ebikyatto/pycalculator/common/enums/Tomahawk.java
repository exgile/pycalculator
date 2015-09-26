package org.ebikyatto.pycalculator.common.enums;

public enum Tomahawk {
	NORMAL ("tomahawk.normal"),
	ENHANCE ("tomahawk.enhance");
	
	private final String baseKey;
	
	Tomahawk(String baseKey) {
		this.baseKey = baseKey;
	}

	@Override
	public String toString() {
		return this.baseKey;
	}
}
