package org.ebikyatto.pycalculator.common.enums;

public enum Backspin {
	NORMAL ("backspin.normal"),
	POWERFUL ("backspin.powerful"),
	ENHANCE ("backspin.enhance");
	
	private final String baseKey;
	
	Backspin(String baseKey) {
		this.baseKey = baseKey;
	}

	@Override
	public String toString() {
		return baseKey;
	}
}
