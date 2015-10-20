package ebikyatto.pycalculator.app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ebikyatto.pycalculator.common.controller.BaseController;
import ebikyatto.pycalculator.model.vo.Result;
import ebikyatto.pycalculator.model.vo.ResultMap;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ModalController extends BaseController {

	@FXML
	private TextField club;
	@FXML
	private TextField specialShot;
	@FXML
	private TextField level1PbScale;
	@FXML
	private TextField level1Moca;
	@FXML
	private TextField level1Force;
	@FXML
	private TextField level2PbScale;
	@FXML
	private TextField level2Moca;
	@FXML
	private TextField level2Force;
	@FXML
	private TextField level3PbScale;
	@FXML
	private TextField level3Moca;
	@FXML
	private TextField level3Force;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setClub(String club) {
		this.club.setText(club);
	}
	
	public void setSpecialShot(String specialShot) {
		this.specialShot.setText(specialShot);
	}
	
	public void setClubAndSpecialShot(String club, String specialShot) {
		this.setClub(club);
		this.setSpecialShot(specialShot);
	}
	
	public void setResultMap(ResultMap resultMap) {
		Result level1 = resultMap.getLevel1();
		level1PbScale.setText(Double.toString(level1.getPbScale()));
		level1Moca.setText(Double.toString(level1.getMoca()));
		level1Force.setText(Double.toString(level1.getForce()));
		
		Result level2 = resultMap.getLevel2();
		level2PbScale.setText(Double.toString(level2.getPbScale()));
		level2Moca.setText(Double.toString(level2.getMoca()));
		level2Force.setText(Double.toString(level2.getForce()));
		
		Result level3 = resultMap.getLevel3();
		level3PbScale.setText(Double.toString(level3.getPbScale()));
		level3Moca.setText(Double.toString(level3.getMoca()));
		level3Force.setText(Double.toString(level3.getForce()));
	}
	
	public void show(String club, String specialShot, ResultMap map) {
		this.setClubAndSpecialShot(club, specialShot);
		this.setResultMap(map);
		this.show();
	}
}
