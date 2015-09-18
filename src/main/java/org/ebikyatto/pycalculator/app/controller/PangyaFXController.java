package org.ebikyatto.pycalculator.app.controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import org.ebikyatto.pycalculator.common.abstracts.Club;
import org.ebikyatto.pycalculator.common.interfaces.SpecialShot;
import org.ebikyatto.pycalculator.common.util.DoubleUtil;
import org.ebikyatto.pycalculator.common.util.SpringUtil;
import org.ebikyatto.pycalculator.model.vo.Environment;
import org.ebikyatto.pycalculator.model.vo.Result;
import org.ebikyatto.pycalculator.model.vo.ResultMap;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

@Component
public class PangyaFXController extends BaseController {
	
	@FXML
	private TextField txtYard;
	@FXML
	private TextField txtElevation;
	@FXML
	private TextField txtSpeedOfWinds;
	@FXML
	private TextField txtAngleOfWinds;
	@FXML
	private TextField txtRatioOfWinds;
	@FXML
	private TextField txtBreakOfDip;
	@FXML
	private TextField txtYardOfMaxDip;
	@FXML
	private TextField txtYardOfLi;
	@FXML
	private TextField txtPbScaleOfGreen;
	
	@FXML
	private Button btnCalculate;
	@FXML
	private Button btnClear;
	
	@FXML
	private ComboBox<String> cbxClub;
	@FXML
	private ComboBox<String> cbxSpecialShot;
	
	private Map<String, Club> clubMap;
	
	private ModalController modal;
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clubMap = (Map<String, Club>) SpringUtil.getBean("clubMap");
		
		this.textFieldsFocus();
		
		btnCalculate.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Environment environment = getEnvironment();
			String clubValue = cbxClub.getValue();
			String specialShotValue = cbxSpecialShot.getValue();
			
			Club club = clubMap.get(clubValue);
			
			if (SpecialShot.TOMAHAWK.equals(specialShotValue)) {
				Result level1 = club.tomahawk(environment);
				Result level2 = club.tomahawkEnhance(environment);
				Result level3 = new Result(0, 0);
				
				ResultMap resultMap = new ResultMap(clubValue, level1, level2, level3);
				modal.setClubAndSpecialShot(clubValue, SpecialShot.TOMAHAWK);
				modal.setResultMap(resultMap);
				modal.show();
			}
			
			if (SpecialShot.DUNK.equals(specialShotValue)) {
				Result level1 = club.dunk(environment);
				Result level2 = club.dunkPowerful(environment);
				Result level3 = club.dunkEnhance(environment);
				
				ResultMap resultMap = new ResultMap(clubValue, level1, level2, level3);
				modal.setClubAndSpecialShot(clubValue, SpecialShot.DUNK);
				modal.setResultMap(resultMap);
				modal.show();
			}

			if (SpecialShot.BACKSPIN.equals(specialShotValue)) {
				Result level1 = club.backspin(environment);
				Result level2 = club.backspinPowerful(environment);
				Result level3 = club.backspinEnhance(environment);
				
				ResultMap resultMap = new ResultMap(clubValue, level1, level2, level3);
				modal.setClubAndSpecialShot(clubValue, SpecialShot.BACKSPIN);
				modal.setResultMap(resultMap);
				modal.show();
			}
			
			if (SpecialShot.COBRA.equals(specialShotValue)) {
				Result level1 = club.cobra(environment);
				Result level2 = club.cobraEnhance(environment);
				Result level3 = new Result(0, 0);
				
				ResultMap resultMap = new ResultMap(clubValue, level1, level2, level3);
				modal.setClubAndSpecialShot(clubValue, SpecialShot.COBRA);
				modal.setResultMap(resultMap);
				modal.show();
			}
		});
		
		btnClear.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			this.clear();
		});
	}
	
	private Environment getEnvironment() {
		Environment environment = new Environment();
		
		double yard = DoubleUtil.parseDouble(txtYard.getText().trim());
		double elevation = DoubleUtil.parseDouble(txtElevation.getText().trim());
		double[] speedOfWinds = DoubleUtil.parseDoubleArray(txtSpeedOfWinds.getText().trim());
		double[] angleOfWinds = DoubleUtil.parseDoubleArray(txtAngleOfWinds.getText().trim());
		double[] ratioOfWinds = DoubleUtil.parseDoubleArray(txtRatioOfWinds.getText().trim());
		double breakOfDip = DoubleUtil.parseDouble(txtBreakOfDip.getText().trim());
		double yardOfMaxDip = DoubleUtil.parseDouble(txtYardOfMaxDip.getText().trim());
		double yardOfLI = DoubleUtil.parseDouble(txtYardOfLi.getText().trim());
		double pbScaleOfGreen = DoubleUtil.parseDouble(txtPbScaleOfGreen.getText().trim());
		
		if (ratioOfWinds.length == 1 && ratioOfWinds[0] == 0) {
			ratioOfWinds[0] = 1;
		}
		
		if (yardOfMaxDip == 0) {
			yardOfMaxDip = yard;
		}
		
		environment.setYard(yard);
		environment.setElevation(elevation);
		environment.setSpeedOfWinds(speedOfWinds);
		environment.setAngleOfWinds(angleOfWinds);
		environment.setRatioOfWinds(ratioOfWinds);
		environment.setBreakOfDip(breakOfDip);
		environment.setYardOfMaxDip(yardOfMaxDip);
		environment.setYardOfLI(yardOfLI);
		environment.setPbScaleOfGreen(pbScaleOfGreen);
		
		return environment;
	}
	
	public void setModalController(ModalController modal) {
		this.modal = modal;
	}
	
	private void textFieldsFocus() {
		TextField[] textFields = new TextField[] {
				txtYard, txtElevation, txtSpeedOfWinds, txtAngleOfWinds, 
				txtRatioOfWinds, txtBreakOfDip, txtYardOfMaxDip, txtYardOfLi, txtPbScaleOfGreen};
		
		for (int i = 0; i < textFields.length; i++) {
			TextField fieldToFocus = i + 1 != textFields.length ? textFields[i + 1] : textFields[0];
			
			textFields[i].addEventHandler(KeyEvent.KEY_PRESSED, e -> {
				if (e.getCode() == KeyCode.ENTER) {
					fieldToFocus.requestFocus();
				}
			});
		}
	}
	
	private void clear() {
		TextField[] textFields = new TextField[] {
				txtYard, txtElevation, txtSpeedOfWinds, txtAngleOfWinds, 
				txtRatioOfWinds, txtBreakOfDip, txtYardOfMaxDip, txtYardOfLi, txtPbScaleOfGreen};
		
		for (TextField field : textFields) {
			field.clear();
		}
		
		textFields[0].requestFocus();
	}
}
