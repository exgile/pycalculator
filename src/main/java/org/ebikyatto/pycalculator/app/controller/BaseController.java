package org.ebikyatto.pycalculator.app.controller;

import org.springframework.stereotype.Component;

import javafx.fxml.Initializable;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

@Component
public abstract class BaseController implements Initializable {
	
	@Getter @Setter
	protected Stage stage;
	
	public void show() {
		stage.show();
	}
	
	public void hide() {
		stage.hide();
	}
	
	public void showAndWait() {
		stage.showAndWait();
	}
}
