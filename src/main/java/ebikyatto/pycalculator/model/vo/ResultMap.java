package ebikyatto.pycalculator.model.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ResultMap {
	
	@Getter
	private String clubName;
	@Getter
	private Result level1;
	@Getter
	private Result level2;
	@Getter
	private Result level3;
	
	public ResultMap(String clubName, Result level1, 
			Result level2, Result level3) {
		this.clubName = clubName;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
	}

}
