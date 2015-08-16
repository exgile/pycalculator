package org.ebikyatto.pycalculator.model.club;

import org.ebikyatto.pycalculator.common.test.TestCase;
import org.ebikyatto.pycalculator.model.vo.Environment;
import org.ebikyatto.pycalculator.model.vo.Result;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Club1WTest extends TestCase {
	
	@Autowired
	private Club1W club1W;
	
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

		Assert.assertEquals(23.487, result.getPbScale(), .1);
		Assert.assertEquals(4.6975, result.getMoca(), .1);
		Assert.assertEquals(92.972, result.getForce(), .1);
	}
}