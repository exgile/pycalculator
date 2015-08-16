package org.ebikyatto.pycalculator.model.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Result {
	
	@Getter
	private double pbScale;
	@Getter
	private double moca;
	@Getter
	private double force;
	
	public Result(double pbScale, double force) {
		this.pbScale = pbScale;
		this.moca = pbScale / 5;
		this.force = force;
	}
}
