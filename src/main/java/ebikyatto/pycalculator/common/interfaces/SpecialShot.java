package ebikyatto.pycalculator.common.interfaces;

import ebikyatto.pycalculator.model.vo.Environment;
import ebikyatto.pycalculator.model.vo.Result;

public interface SpecialShot {
	
	public static final String TOMAHAWK = "TOMAHAWK";
	public static final String BACKSPIN = "BACKSPIN";
	public static final String DUNK = "DUNK";
	public static final String COBRA = "COBRA";
	public static final String SPIKE = "SPIKE";
	
	public Result tomahawk(Environment environment);
	public Result tomahawkEnhance(Environment environment);
	public Result dunk(Environment environment);
	public Result dunkPowerful(Environment environment);
	public Result dunkEnhance(Environment environment);
	public Result backspin(Environment environment);
	public Result backspinPowerful(Environment environment);
	public Result backspinEnhance(Environment environment);
	public Result cobra(Environment environment);
	public Result cobraEnhance(Environment environment);
	public Result spike(Environment environment);
	public Result spikeEnhance(Environment environment);
}
