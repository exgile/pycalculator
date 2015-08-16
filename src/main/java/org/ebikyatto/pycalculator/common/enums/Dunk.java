package org.ebikyatto.pycalculator.common.enums;

public enum Dunk {
	NORMAL ("dunk.normal"),
	POWERFUL ("dunk.powerful"),
	ENHANCE ("dunk.enhance");
	
	private final String baseKey;
	
	Dunk(String baseKey) {
		this.baseKey = baseKey;
	}

	@Override
	public String toString() {
		return baseKey;
	}
}
