package org.ebikyatto.pycalculator.model.club;

import org.ebikyatto.pycalculator.common.test.TestCase;
import org.ebikyatto.pycalculator.model.vo.Environment;
import org.ebikyatto.pycalculator.model.vo.Result;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Club1WTest extends TestCase {
	
	@Autowired
	private Club1W club1W;
	
	@Ignore
	@Test
	public void testTomahawk() {
		Environment environment = new Environment();

		double yard = 260;
		double elevation = -10;
		double[] speedOfWinds = new double[] {9};
		double[] angleOfWinds = new double[] {45};
		double[] ratioOfWinds = new double[] {1};
		double breakOfDip = -2;
		double yardOfMaxDip = 260;
		
		environment.setYard(yard);
		environment.setElevation(elevation);
		environment.setSpeedOfWinds(speedOfWinds);
		environment.setAngleOfWinds(angleOfWinds);
		environment.setRatioOfWinds(ratioOfWinds);
		environment.setBreakOfDip(breakOfDip);
		environment.setYardOfMaxDip(yardOfMaxDip);
		
		Result result = club1W.tomahawk(environment);
		this.getLogger().debug(result.toString());

		Assert.assertEquals(23.412, result.getPbScale(), .1);
		Assert.assertEquals(4.682, result.getMoca(), .1);
		Assert.assertEquals(92.972, result.getForce(), .1);
	}
	
	@Ignore
	@Test
	public void testTomahawkEnhance() {
		Environment environment = new Environment();

		double yard = 260;
		double elevation = -10;
		double[] speedOfWinds = new double[] {9};
		double[] angleOfWinds = new double[] {45};
		double[] ratioOfWinds = new double[] {1};
		double breakOfDip = -2;
		double yardOfMaxDip = 260;
		
		environment.setYard(yard);
		environment.setElevation(elevation);
		environment.setSpeedOfWinds(speedOfWinds);
		environment.setAngleOfWinds(angleOfWinds);
		environment.setRatioOfWinds(ratioOfWinds);
		environment.setBreakOfDip(breakOfDip);
		environment.setYardOfMaxDip(yardOfMaxDip);
		
		Result result = club1W.tomahawkEnhance(environment);
		this.getLogger().debug(result.toString());

		Assert.assertEquals(23.412, result.getPbScale(), .1);
		Assert.assertEquals(4.682, result.getMoca(), .1);
		Assert.assertEquals(90.388, result.getForce(), .1);
	}
	
	@Ignore
	@Test
	public void testDunk() {
		Environment environment = new Environment();

		double yard = 220;
		double elevation = -10;
		double[] speedOfWinds = new double[] {9};
		double[] angleOfWinds = new double[] {45};
		double[] ratioOfWinds = new double[] {1};
		double breakOfDip = -2;
		double yardOfMaxDip = 220;
		
		environment.setYard(yard);
		environment.setElevation(elevation);
		environment.setSpeedOfWinds(speedOfWinds);
		environment.setAngleOfWinds(angleOfWinds);
		environment.setRatioOfWinds(ratioOfWinds);
		environment.setBreakOfDip(breakOfDip);
		environment.setYardOfMaxDip(yardOfMaxDip);
		
		Result result = club1W.dunk(environment);
		this.getLogger().debug(result.toString());

		Assert.assertEquals(27.447, result.getPbScale(), .1);
		Assert.assertEquals(5.489, result.getMoca(), .1);
		Assert.assertEquals(96.599, result.getForce(), .1);
		
		environment = new Environment();

		yard = 160;
		elevation = -10;
		speedOfWinds = new double[] {9};
		angleOfWinds = new double[] {45};
		ratioOfWinds = new double[] {1};
		breakOfDip = -2;
		yardOfMaxDip = 160;
		
		environment.setYard(yard);
		environment.setElevation(elevation);
		environment.setSpeedOfWinds(speedOfWinds);
		environment.setAngleOfWinds(angleOfWinds);
		environment.setRatioOfWinds(ratioOfWinds);
		environment.setBreakOfDip(breakOfDip);
		environment.setYardOfMaxDip(yardOfMaxDip);
		
		result = club1W.dunk(environment);
		this.getLogger().debug(result.toString());

		Assert.assertEquals(13.541, result.getPbScale(), .1);
		Assert.assertEquals(2.708, result.getMoca(), .1);
		Assert.assertEquals(74.087, result.getForce(), .1);
	}
}