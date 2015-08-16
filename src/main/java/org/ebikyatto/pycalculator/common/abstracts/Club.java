package org.ebikyatto.pycalculator.common.abstracts;

import java.util.ResourceBundle;

import org.ebikyatto.pycalculator.common.enums.Backspin;
import org.ebikyatto.pycalculator.common.enums.Cobra;
import org.ebikyatto.pycalculator.common.enums.Dunk;
import org.ebikyatto.pycalculator.common.enums.Spike;
import org.ebikyatto.pycalculator.common.enums.Tomahawk;
import org.ebikyatto.pycalculator.common.interfaces.SpecialShot;
import org.ebikyatto.pycalculator.common.util.DoubleUtil;
import org.ebikyatto.pycalculator.common.util.PangyaUtil;
import org.ebikyatto.pycalculator.model.vo.Environment;
import org.ebikyatto.pycalculator.model.vo.Result;

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
		double hwiOfTomahawk = PangyaUtil.hwiOfTomahawk(environment, coefficient);
		double pbScaleOfTomahawk = PangyaUtil.pbScaleOfTomahawk(environment, hwiOfTomahawk, .4);
		
		return new Result(pbScaleOfTomahawk, force);
	}
	
	private Result dunk(Environment environment, Dunk type) {
		return null;
	}
	
	private Result backspin(Environment environment, Backspin type) {
		return null;
	}
	
	private Result cobra(Environment environment, Cobra type) {
		return null;
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
