package ebikyatto.pycalculator.common.enums;

public enum Spike {
	NORMAL ("spike.normal"),
	ENHANCE ("spike.enhance");
	
	private final String baseKey;
	
	Spike(String baseKey) {
		this.baseKey = baseKey;
	}

	@Override
	public String toString() {
		return baseKey;
	}
}
