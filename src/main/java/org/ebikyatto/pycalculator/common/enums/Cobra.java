package org.ebikyatto.pycalculator.common.enums;

public enum Cobra {
	NORMAL ("cobra.normal"),
	ENHANCE ("cobra.enhance");
	
	private final String baseKey;
	
	Cobra(String baseKey) {
		this.baseKey = baseKey;
	}

	@Override
	public String toString() {
		return this.baseKey;
	}
}
