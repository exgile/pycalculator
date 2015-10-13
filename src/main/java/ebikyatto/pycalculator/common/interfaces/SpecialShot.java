package ebikyatto.pycalculator.common.interfaces;

import ebikyatto.pycalculator.model.vo.Environment;
import ebikyatto.pycalculator.model.vo.Result;

public interface SpecialShot {
	
	String TOMAHAWK = "TOMAHAWK";
	String BACKSPIN = "BACKSPIN";
	String DUNK = "DUNK";
	String COBRA = "COBRA";
	String SPIKE = "SPIKE";
	
	Result tomahawk(Environment environment);
	Result tomahawkEnhance(Environment environment);
	Result dunk(Environment environment);
	Result dunkPowerful(Environment environment);
	Result dunkEnhance(Environment environment);
	Result backspin(Environment environment);
	Result backspinPowerful(Environment environment);
	Result backspinEnhance(Environment environment);
	Result cobra(Environment environment);
	Result cobraEnhance(Environment environment);
	Result spike(Environment environment);
	Result spikeEnhance(Environment environment);
}
