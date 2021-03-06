package ebikyatto.pycalculator.common.abstracts;

import java.util.ResourceBundle;

import ebikyatto.pycalculator.common.enums.Backspin;
import ebikyatto.pycalculator.common.enums.Cobra;
import ebikyatto.pycalculator.common.enums.Dunk;
import ebikyatto.pycalculator.common.enums.Spike;
import ebikyatto.pycalculator.common.enums.Tomahawk;
import ebikyatto.pycalculator.common.interfaces.SpecialShot;
import ebikyatto.pycalculator.common.util.DoubleUtil;
import ebikyatto.pycalculator.common.util.PangyaUtil;
import ebikyatto.pycalculator.model.vo.Environment;
import ebikyatto.pycalculator.model.vo.Result;

public abstract class Club implements SpecialShot {
	private ResourceBundle bundle;
	
	public Club() {
		String baseName = this.getClass().getSimpleName().toLowerCase();
		bundle = ResourceBundle.getBundle("config/" + baseName);
	}

	private Result tomahawk(Environment environment, Tomahawk type) {
		double coefficient = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".coefficient"));
		double factorOfWind = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".factorOfWind"));
		double[] yardOfForce = DoubleUtil.parseDoubleArray(bundle.getString(type.toString() + ".yardOfForce"));
		
		double factorOfElevation = 0;
		if (environment.getElevation() >= 0) {
			factorOfElevation = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".rise.factorOfElevation"));
		} else {
			factorOfElevation = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".fall.factorOfElevation"));
		}
		
		double verticalWind = PangyaUtil.verticalWind(environment);
		environment.setVerticalWind(verticalWind);
		
		double horizontalWind = PangyaUtil.horizontalWind(environment);
		environment.setHorizontalWind(horizontalWind);
		
		double realVerticalWind = PangyaUtil.realVerticalWind(environment, yardOfForce[0], factorOfWind);
		double realElevation = PangyaUtil.realElevation(environment, yardOfForce[0], factorOfElevation);
		double yardToGo = PangyaUtil.yardToGo(environment, realVerticalWind, realElevation);
		double force = PangyaUtil.force(environment, yardToGo, yardOfForce);
		double hwiOfTomahawk = PangyaUtil.hwiOfTomahawk(environment, coefficient, .4);
		double pbScaleOfTomahawk = PangyaUtil.pbScaleOfTomahawk(environment, hwiOfTomahawk, .4);
		
		return new Result(pbScaleOfTomahawk, force);
	}
	
	private Result dunk(Environment environment, Dunk type) {
		double coefficient = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".coefficient"));
		double factorOfWind = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".factorOfWind"));
		double[] yardOfForce = DoubleUtil.parseDoubleArray(bundle.getString(type.toString() + ".yardOfForce"));
		
		double factorOfElevation = 0;
		if (environment.getElevation() >= 0) {
			factorOfElevation = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".rise.factorOfElevation"));
		} else {
			factorOfElevation = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".fall.factorOfElevation"));
		}
		
		double verticalWind = PangyaUtil.verticalWind(environment);
		environment.setVerticalWind(verticalWind);
		
		double horizontalWind = PangyaUtil.horizontalWind(environment);
		environment.setHorizontalWind(horizontalWind);
		
		double realVerticalWind = PangyaUtil.realVerticalWind(environment, yardOfForce[0], factorOfWind);
		double realElevation = PangyaUtil.realElevation(environment, yardOfForce[0], factorOfElevation);
		double yardToGo = PangyaUtil.yardToGo(environment, realVerticalWind, realElevation);
		double force = PangyaUtil.force(environment, yardToGo, yardOfForce);
		double hwiOfDunk = PangyaUtil.hwiOfDunk(environment, yardOfForce, coefficient, 1);
		double pbScaleOfDunk = PangyaUtil.pbScaleOfDunk(environment, hwiOfDunk, .5);
		
		return new Result(pbScaleOfDunk, force);
	}
	
	private Result backspin(Environment environment, Backspin type) {
		double coefficient = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".coefficient"));
		double factorOfWind = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".factorOfWind"));
		double[] yardOfForce = DoubleUtil.parseDoubleArray(bundle.getString(type.toString() + ".yardOfForce"));
		
		double factorOfElevation = 0;
		if (environment.getElevation() >= 0) {
			factorOfElevation = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".rise.factorOfElevation"));
		} else {
			factorOfElevation = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".fall.factorOfElevation"));
		}
		
		double verticalWind = PangyaUtil.verticalWind(environment);
		environment.setVerticalWind(verticalWind);
		
		double horizontalWind = PangyaUtil.horizontalWind(environment);
		environment.setHorizontalWind(horizontalWind);
		
		double realVerticalWind = PangyaUtil.realVerticalWind(environment, yardOfForce[0], factorOfWind);
		double realElevation = PangyaUtil.realElevation(environment, yardOfForce[0], factorOfElevation);
		double yardToGo = PangyaUtil.yardToGo(environment, realVerticalWind, realElevation);
		double force = PangyaUtil.force(environment, yardToGo, yardOfForce);
		double hwiOfBackspin = PangyaUtil.hwiOfBackspin(environment, coefficient, 1);
		double pbScaleOfBackspin = PangyaUtil.pbScaleOfBackspin(environment, hwiOfBackspin, .5);
		
		return new Result(pbScaleOfBackspin, force);
	}
	
	private Result cobra(Environment environment, Cobra type) {
		double coefficient = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".coefficient"));
		double factorOfWind = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".factorOfWind"));
		double[] yardOfForce = DoubleUtil.parseDoubleArray(bundle.getString(type.toString() + ".yardOfForce"));
		
		double factorOfElevation = 0;
		if (environment.getElevation() >= 0) {
			factorOfElevation = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".rise.factorOfElevation"));
		} else {
			factorOfElevation = DoubleUtil.parseDouble(bundle.getString(type.toString() + ".fall.factorOfElevation"));
		}
		
		double verticalWind = PangyaUtil.verticalWind(environment);
		environment.setVerticalWind(verticalWind);
		
		double horizontalWind = PangyaUtil.horizontalWind(environment);
		environment.setHorizontalWind(horizontalWind);
		
		double realVerticalWind = PangyaUtil.realVerticalWind(environment, yardOfForce[0], factorOfWind, true);
		double realElevation = PangyaUtil.realElevation(environment, yardOfForce[0], factorOfElevation, true);
		double yardToGo = PangyaUtil.yardToGo(environment, realVerticalWind, realElevation);
		double force = PangyaUtil.force(environment, yardToGo, yardOfForce);
		double hwiOfCobra = PangyaUtil.hwiOfCobra(environment, yardOfForce, coefficient, 1);
		double pbScaleOfCobra = PangyaUtil.pbScaleOfCobra(environment, hwiOfCobra, .6);
		
		return new Result(pbScaleOfCobra, force);
	}
	
	private Result spike(Environment environment, Spike type) {
		return null;
	}
	
	@Override
	public Result tomahawk(Environment environment) {
		return tomahawk(environment, Tomahawk.NORMAL);
	}

	@Override
	public Result tomahawkEnhance(Environment environment) {
		return tomahawk(environment, Tomahawk.ENHANCE);
	}

	@Override
	public Result dunk(Environment environment) {
		return dunk(environment, Dunk.NORMAL);
	}

	@Override
	public Result dunkPowerful(Environment environment) {
		return dunk(environment, Dunk.POWERFUL);
	}

	@Override
	public Result dunkEnhance(Environment environment) {
		return dunk(environment, Dunk.ENHANCE);
	}

	@Override
	public Result backspin(Environment environment) {
		return backspin(environment, Backspin.NORMAL);
	}

	@Override
	public Result backspinPowerful(Environment environment) {
		return backspin(environment, Backspin.POWERFUL);
	}

	@Override
	public Result backspinEnhance(Environment environment) {
		return backspin(environment, Backspin.ENHANCE);
	}

	@Override
	public Result cobra(Environment environment) {
		return cobra(environment, Cobra.NORMAL);
	}

	@Override
	public Result cobraEnhance(Environment environment) {
		return cobra(environment, Cobra.ENHANCE);
	}

	@Override
	public Result spike(Environment environment) {
		return spike(environment, Spike.NORMAL);
	}

	@Override
	public Result spikeEnhance(Environment environment) {
		return spike(environment, Spike.ENHANCE);
	}
}
