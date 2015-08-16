package org.ebikyatto.pycalculator.common.abstracts;

import java.util.ResourceBundle;

import org.ebikyatto.pycalculator.common.enums.Backspin;
import org.ebikyatto.pycalculator.common.enums.Cobra;
import org.ebikyatto.pycalculator.common.enums.Dunk;
import org.ebikyatto.pycalculator.common.enums.Spike;
import org.ebikyatto.pycalculator.common.enums.Tomahawk;
import org.ebikyatto.pycalculator.common.interfaces.SpecialShot;
import org.ebikyatto.pycalculator.model.vo.Environment;
import org.ebikyatto.pycalculator.model.vo.Result;

public abstract class Club implements SpecialShot {
	private ResourceBundle bundle;
	
	public Club() {
		String baseName = this.getClass().getSimpleName().toLowerCase();
		bundle = ResourceBundle.getBundle(baseName);
	}

	private Result tomahawk(Environment env, Tomahawk type) {
		return null;
	}
	
	private Result dunk(Environment env, Dunk type) {
		return null;
	}
	
	private Result backspin(Environment env, Backspin type) {
		return null;
	}
	
	private Result cobra(Environment env, Cobra type) {
		return null;
	}
	
	private Result spike(Environment env, Spike type) {
		return null;
	}
	
	@Override
	public Result tomahawk(Environment env) {
		return tomahawk(env, Tomahawk.NORMAL);
	}

	@Override
	public Result tomahawkEnhance(Environment env) {
		return tomahawk(env, Tomahawk.ENHANCE);
	}

	@Override
	public Result dunk(Environment env) {
		return dunk(env, Dunk.NORMAL);
	}

	@Override
	public Result dunkPowerful(Environment env) {
		return dunk(env, Dunk.POWERFUL);
	}

	@Override
	public Result dunkEnhance(Environment env) {
		return dunk(env, Dunk.ENHANCE);
	}

	@Override
	public Result backspin(Environment env) {
		return backspin(env, Backspin.NORMAL);
	}

	@Override
	public Result backspinPowerful(Environment env) {
		return backspin(env, Backspin.POWERFUL);
	}

	@Override
	public Result backspinEnhance(Environment env) {
		return backspin(env, Backspin.ENHANCE);
	}

	@Override
	public Result cobra(Environment env) {
		return cobra(env, Cobra.NORMAL);
	}

	@Override
	public Result cobraEnhance(Environment env) {
		return cobra(env, Cobra.ENHANCE);
	}

	@Override
	public Result spike(Environment env) {
		return spike(env, Spike.NORMAL);
	}

	@Override
	public Result spikeEnhance(Environment env) {
		return spike(env, Spike.ENHANCE);
	}
}
