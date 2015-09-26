package org.ebikyatto.pycalculator.app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.ebikyatto.pycalculator.model.vo.Result;
import org.ebikyatto.pycalculator.model.vo.ResultMap;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Component
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
		setClub(club);
		setSpecialShot(specialShot);
	}
	
	public void setResultMap(ResultMap resultMap) {
		Result level1 = resultMap.getLevel1();
		this.level1PbScale.setText(Double.toString(level1.getPbScale()));
		this.level1Moca.setText(Double.toString(level1.getMoca()));
		this.level1Force.setText(Double.toString(level1.getForce()));
		
		Result level2 = resultMap.getLevel2();
		this.level2PbScale.setText(Double.toString(level2.getPbScale()));
		this.level2Moca.setText(Double.toString(level2.getMoca()));
		this.level2Force.setText(Double.toString(level2.getForce()));
		
		Result level3 = resultMap.getLevel3();
		this.level3PbScale.setText(Double.toString(level3.getPbScale()));
		this.level3Moca.setText(Double.toString(level3.getMoca()));
		this.level3Force.setText(Double.toString(level3.getForce()));
	}
	
	public void show(String club, String specialShot, ResultMap map) {
		setClubAndSpecialShot(club, specialShot);
		setResultMap(map);
		show();
	}
}
