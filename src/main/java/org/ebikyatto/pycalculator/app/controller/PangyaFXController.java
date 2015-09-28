package org.ebikyatto.pycalculator.app.controller;

import java.lang.reflect.Field;
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
import lombok.Setter;

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
	private Button btnReset;
	
	@FXML
	private ComboBox<String> cbxClub;
	@FXML
	private ComboBox<String> cbxSpecialShot;
	
	private Map<String, Club> clubMap;
	
	@Setter
	private ModalController modal;
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.clubMap = (Map<String, Club>) SpringUtil.getBean("clubMap");
		
		this.textFieldsFocus();
		
		this.btnCalculate.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Environment environment = getEnvironment();
			String clubValue = this.cbxClub.getValue();
			String specialShotValue = this.cbxSpecialShot.getValue();
			
			Club club = this.clubMap.get(clubValue);
			
			if (SpecialShot.TOMAHAWK.equals(specialShotValue)) {
				Result level1 = club.tomahawk(environment);
				Result level2 = club.tomahawkEnhance(environment);
				Result level3 = new Result(0, 0);
				
				ResultMap resultMap = new ResultMap(clubValue, level1, level2, level3);
				this.modal.setClubAndSpecialShot(clubValue, SpecialShot.TOMAHAWK);
				this.modal.setResultMap(resultMap);
				this.modal.show();
			}
			
			if (SpecialShot.DUNK.equals(specialShotValue)) {
				Result level1 = club.dunk(environment);
				Result level2 = club.dunkPowerful(environment);
				Result level3 = club.dunkEnhance(environment);
				
				ResultMap resultMap = new ResultMap(clubValue, level1, level2, level3);
				this.modal.setClubAndSpecialShot(clubValue, SpecialShot.DUNK);
				this.modal.setResultMap(resultMap);
				this.modal.show();
			}

			if (SpecialShot.BACKSPIN.equals(specialShotValue)) {
				Result level1 = club.backspin(environment);
				Result level2 = club.backspinPowerful(environment);
				Result level3 = club.backspinEnhance(environment);
				
				ResultMap resultMap = new ResultMap(clubValue, level1, level2, level3);
				this.modal.setClubAndSpecialShot(clubValue, SpecialShot.BACKSPIN);
				this.modal.setResultMap(resultMap);
				this.modal.show();
			}
			
			if (SpecialShot.COBRA.equals(specialShotValue)) {
				Result level1 = club.cobra(environment);
				Result level2 = club.cobraEnhance(environment);
				Result level3 = new Result(0, 0);
				
				ResultMap resultMap = new ResultMap(clubValue, level1, level2, level3);
				this.modal.setClubAndSpecialShot(clubValue, SpecialShot.COBRA);
				this.modal.setResultMap(resultMap);
				this.modal.show();
			}
		});
		
		this.btnReset.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> reset());
	}
	
	private Environment getEnvironment() {
		Environment environment = new Environment();
		
		double yard = DoubleUtil.parseDouble(this.txtYard.getText().trim());
		double elevation = DoubleUtil.parseDouble(this.txtElevation.getText().trim());
		double[] speedOfWinds = DoubleUtil.parseDoubleArray(this.txtSpeedOfWinds.getText().trim());
		double[] angleOfWinds = DoubleUtil.parseDoubleArray(this.txtAngleOfWinds.getText().trim());
		double[] ratioOfWinds = DoubleUtil.parseDoubleArray(this.txtRatioOfWinds.getText().trim());
		double breakOfDip = DoubleUtil.parseDouble(this.txtBreakOfDip.getText().trim());
		double yardOfMaxDip = DoubleUtil.parseDouble(this.txtYardOfMaxDip.getText().trim());
		double yardOfLI = DoubleUtil.parseDouble(this.txtYardOfLi.getText().trim());
		double pbScaleOfGreen = DoubleUtil.parseDouble(this.txtPbScaleOfGreen.getText().trim());
		
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
	
	private void textFieldsFocus() {
		TextField[] textFields = new TextField[] {
			this.txtYard, 
			this.txtElevation, 
			this.txtSpeedOfWinds, 
			this.txtAngleOfWinds, 
			this.txtRatioOfWinds, 
			this.txtBreakOfDip, 
			this.txtYardOfMaxDip, 
			this.txtYardOfLi, 
			this.txtPbScaleOfGreen
		};
		
		for (int idx = 0; idx < textFields.length; idx++) {
			final TextField fieldToFocus = idx + 1 != textFields.length ? textFields[idx + 1] : textFields[0];
			
			textFields[idx].addEventHandler(KeyEvent.KEY_PRESSED, e -> {
				if (e.getCode() == KeyCode.ENTER) {
					fieldToFocus.requestFocus();
				}
			});
		}
	}
	
	private void reset() {
		Field[] fileds = getClass().getDeclaredFields();
		
		for (Field field : fileds) {
			if (TextField.class.getName().equals(field.getType().getName())) {
				try {
					// Use reflection to call clear method
					field.setAccessible(true);
					Object object = field.get(this);
					object.getClass().getSuperclass().getDeclaredMethod("clear").invoke(object);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		this.txtYard.requestFocus();
	}
}
