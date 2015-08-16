package org.ebikyatto.pycalculator.common.util;

import org.ebikyatto.pycalculator.model.vo.Environment;

public final class PangyaUtil {

	private static final double POWERBAR_SCALE_RATIO = .22;
	
	private PangyaUtil() {
	}

	public static double verticalWind(Environment environment) {
		double verticalWind = 0;

		double[] speedOfWinds = environment.getSpeedOfWinds();
		double[] angleOfWinds = environment.getAngleOfWinds();
		double[] ratioOfWinds = environment.getRatioOfWinds();

		for (int index = 0; index < speedOfWinds.length; index++) {
			verticalWind += MathUtil.cos(speedOfWinds[index], angleOfWinds[index]) * ratioOfWinds[index];
		}
		return verticalWind;
	}
	
	public static double horizontalWind(Environment environment) {
		double horizontalWind = 0;

		double[] speedOfWinds = environment.getSpeedOfWinds();
		double[] angleOfWinds = environment.getAngleOfWinds();
		double[] ratioOfWinds = environment.getRatioOfWinds();

		for (int index = 0; index < speedOfWinds.length; index++) {
			horizontalWind += MathUtil.sin(speedOfWinds[index], angleOfWinds[index]) * ratioOfWinds[index];
		}
		return horizontalWind;
	}
	
	public static double realVerticalWind(Environment environment, double maxYardOfSpShot, double factorOfWind) {
		double verticalWind = verticalWind(environment);
		double yard = environment.getYard();
		double yardOfLI = environment.getYardOfLI();
		double elevation = environment.getElevation();
		
		return verticalWind * MathUtil.square((yard + yardOfLI - elevation + verticalWind) / maxYardOfSpShot) * factorOfWind;
	}
	
	public static double realElevation(Environment environment, double maxYardOfSpShot, double factorOfElevation) {
		double verticalWind = verticalWind(environment);
		double yard = environment.getYard();
		double yardOfLI = environment.getYardOfLI();
		double elevation = environment.getElevation();
		
		return elevation * MathUtil.square(maxYardOfSpShot / (yard + yardOfLI + verticalWind - elevation)) * factorOfElevation;
	}
	
	public static double yardToGo(Environment environment, double realVerticalWind, double realElevation) {
		double yard = environment.getYard();
		double yardOfLI = environment.getYardOfLI();
		
		return yard + yardOfLI + realVerticalWind + realElevation;
	}
	
	public static double force(Environment environment, double yardToGo, double[] yardOfForce) {
		double[] scaleOfForce = new double[yardOfForce.length - 1];
		
		for (int index = 0; index < yardOfForce.length - 1; index++) {
			double scale = (yardOfForce[index] - yardOfForce[index + 1]) / 5;
			scaleOfForce[index] = scale;
		}
		
		double thresholdOfForce = 100;
		double forceToGo = 0;
		
		for (int index = 0; index < scaleOfForce.length; index++) {
			if (index != scaleOfForce.length - 1 && yardToGo >= yardOfForce[index + 1]) {
				thresholdOfForce -= 5;
			} else {
				forceToGo = thresholdOfForce - (yardOfForce[index] - yardToGo) / scaleOfForce[index];
				break;
			}
		}
		
		return forceToGo;
	}
	
	public static double hwiOfTomahawk(Environment environment, double coefficient) {
		double yard = environment.getYard();
		double yardOfLI = environment.getYardOfLI();
		double verticalWind = environment.getVerticalWind();
		double elevation = environment.getElevation();
		
		double yardOfHWI = yard + yardOfLI + verticalWind - elevation * .4;

		return yardOfHWI * coefficient - 1;
	}
	
	public static double hwiOfDunk(Environment environment, double coefficient) {
		return hwiOfTomahawk(environment, coefficient);
	}
	
	public static double hwiOfBackspin(Environment environment, double coefficient) {
		return hwiOfTomahawk(environment, coefficient);
	}
	
	public static double hwiOfCobra(Environment environment, double coefficient) {
		double yard = environment.getYard();
		return yard * coefficient - 1;
	}
	
	public static double massOfDip(Environment environment, double factorOfDip) {
		double yard = environment.getYard();
		double yardOfLI = environment.getYardOfLI();
		double elevation = environment.getElevation();
		double verticalWind = environment.getVerticalWind();
		double breakOfDip = environment.getBreakOfDip();
		double yardOfMaxDip = environment.getYardOfMaxDip();
		
		return (yard + yardOfLI + verticalWind - elevation) * .001 * breakOfDip * (yardOfMaxDip / yard) * factorOfDip;
	}
	
	public static double pbScaleOfTomahawk(Environment environment, double hwi, double factorOfDip) {
		
		double horizontalWind = environment.getHorizontalWind();
		double massOfDip = massOfDip(environment, factorOfDip);
		
		return (horizontalWind + massOfDip) * hwi / POWERBAR_SCALE_RATIO;
	}
	
	public static double pbScaleOfDunk(Environment environment, double hwi) {
		
		double horizontalWind = environment.getHorizontalWind();
		double massOfDip = massOfDip(environment, .5);
		
		return (horizontalWind + massOfDip) * hwi / POWERBAR_SCALE_RATIO;
	}
	
	public static double pbScaleOfBackspin(Environment environment, double hwi) {
		
		double horizontalWind = environment.getHorizontalWind();
		double massOfDip = massOfDip(environment, .5);
		double pbScaleOfGreen = environment.getPbScaleOfGreen();
		
		return ((horizontalWind + massOfDip) / POWERBAR_SCALE_RATIO + pbScaleOfGreen) * hwi;
	}
	
	public static double pbScaleOfCobra(Environment environment, double hwi) {
		
		double horizontalWind = environment.getHorizontalWind();
		double massOfDip = massOfDip(environment, .6);
		
		return (horizontalWind + massOfDip) * hwi / POWERBAR_SCALE_RATIO;
	}
	
}
