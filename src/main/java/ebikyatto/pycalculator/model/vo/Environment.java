package ebikyatto.pycalculator.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Environment {
	
	@Getter @Setter
	private double yard;
	@Getter @Setter
	private double elevation;
	@Getter @Setter
	private double[] speedOfWinds;
	@Getter @Setter
	private double[] angleOfWinds;
	@Getter @Setter
	private double[] ratioOfWinds;
	@Getter @Setter
	private double breakOfDip;
	@Getter @Setter
	private double yardOfMaxDip;
	@Getter @Setter
	private double yardOfLI;
	@Getter @Setter
	private double pbScaleOfGreen;
	@Getter @Setter
	private double verticalWind;
	@Getter @Setter
	private double horizontalWind;

}
