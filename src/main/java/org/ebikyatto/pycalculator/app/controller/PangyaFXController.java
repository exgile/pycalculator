package org.ebikyatto.pycalculator.app.controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javax.annotation.Resource;

import org.ebikyatto.pycalculator.common.abstracts.Club;
import org.ebikyatto.pycalculator.model.vo.Environment;

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
	private Button btnTomahawk;
	@FXML
	private Button btnDunk;
	@FXML
	private Button btnBackspin;
	@FXML
	private Button btnCobra;
	@FXML
	private Button btnClear;
	
	@FXML
	private ComboBox<String> cbxClub;
	
	@Resource(name = "clubMap")
	private Map<String, Club> clubMap;
	
	private ModalController modal;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textFieldsFocus();
		
		btnTomahawk.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
		});
		
		btnDunk.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
		});
		
		btnBackspin.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
		});
		
		btnCobra.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
		});
		
		btnClear.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			clear();
		});
	}
	
	private Environment getEnvironment() {
		Environment environment = new Environment();
		
		double yard = getTextAsDouble(txtYard);
		double elevation = getTextAsDouble(txtElevation);
		double[] speedOfWinds = getTextAsDoubleArray(txtSpeedOfWinds);
		double[] angleOfWinds = getTextAsDoubleArray(txtAngleOfWinds);
		double[] ratioOfWinds = getTextAsDoubleArray(txtRatioOfWinds);
		double breakOfDip = getTextAsDouble(txtBreakOfDip);
		double yardOfMaxDip = getTextAsDouble(txtYardOfMaxDip);
		double yardOfLI = getTextAsDouble(txtYardOfLi);
		double pbScaleOfGreen = getTextAsDouble(txtPbScaleOfGreen);
		
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
	
	private double getTextAsDouble(TextField field) {
		String txt = field.getText().replaceAll("[^\\d.\\-]", "").trim();
		txt = defValIfEmpty(txt);
		return txt.length() > 0 ? Double.valueOf(txt) : 0;
	}
	
	private double[] getTextAsDoubleArray(TextField field) {
		String txt = field.getText().replaceAll("[^\\d.,\\-]", "").trim();
		txt = defValIfEmpty(txt);
		String[] txtArray = txt.split(",");
		double[] dbArray = new double[txtArray.length];
		for (int i = 0; i < txtArray.length; i++) {
			dbArray[i] = Double.valueOf(txtArray[i]);
		}
		return dbArray;
	}
	
	public void setModalController(ModalController modal) {
		this.modal = modal;
	}
	
	private String getClub() {
		return cbxClub.getValue();
	}
	
	private String defValIfEmpty(String txt) {
		return isEmpty(txt) ? "0" : txt;
	}
	
	private boolean isEmpty(String txt) {
		return txt == null || txt.isEmpty();
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
