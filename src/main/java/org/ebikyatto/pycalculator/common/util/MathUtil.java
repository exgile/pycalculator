package org.ebikyatto.pycalculator.common.util;

public final class MathUtil {
	
	private static final double SQUARE_POWER = 2;
	
	private MathUtil() {
	}
	
	public static double square(double numberToSquare) {
		return Math.pow(numberToSquare, MathUtil.SQUARE_POWER);
	}
	
	public static double sin(double number, double angle) {
		return number * Math.sin(Math.toRadians(angle));
	}
	
	public static double cos(double number, double angle) {
		return number * Math.cos(Math.toRadians(angle));
	}
}
